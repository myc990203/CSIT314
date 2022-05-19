import project.JSONLIKE;
import project.JdbcUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/payment/payment")

public class Payload extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.print("Payload");
        BufferedReader bufferedReader_pay = req.getReader();
        StringBuilder  stringBuilder_pay  = new StringBuilder();
        String         line_pay;
        while ((line_pay = bufferedReader_pay.readLine()) != null) {
            stringBuilder_pay.append(line_pay);
        }
        String str = stringBuilder_pay.toString();
        System.out.println(str);
        Map<String, String> map = JSONLIKE.myJson(str);
        String              oid = map.get("oid");
        Map<String, String> res = new HashMap<String, String>();
        try {
            res = JdbcUtil.sqlcurOrderSelect(oid);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        PrintWriter pw   = resp.getWriter();
        String      json = JSONLIKE.myMap2JSON(res);
        System.out.println(json);
        System.out.println(json);
        pw.print(json);
        pw.flush();
    }
}
