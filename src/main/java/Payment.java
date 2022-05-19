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

import project.*;

@WebServlet("/payment/Payment")

public class Payment extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        BufferedReader bufferedReader_pay = req.getReader();
        StringBuilder  stringBuilder_pay  = new StringBuilder();
        String         line_pay;
        while ((line_pay = bufferedReader_pay.readLine()) != null) {
            stringBuilder_pay.append(line_pay);
        }
        String str = stringBuilder_pay.toString();
        System.out.println(str);
        Map<String,String> map = JSONLIKE.myJson(str);
        String oid = map.get("oid");
        String payType = map.get("Card_type");
        String payCardNum = map.get("Bank_num");
        String[] starS = map.get("star").split(" ");
        String star = starS[0];
        String comm = map.get("comm");
        String orderEndDate = map.get("endTime");

        Map<String, String> curOmap = new HashMap<String, String>();
        try {
            curOmap = JdbcUtil.sqlcurOrderSelect(oid);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        curOmap.remove("cur_orderid");
        map.remove("sstate");
        curOmap.put("orderid",oid);
        curOmap.put("payType",payType);
        curOmap.put("payCardNum",payCardNum);
        curOmap.put("star",star);
        curOmap.put("comm",comm);
        curOmap.put("orderEndDate",orderEndDate);
        System.out.println(curOmap);
        try {
            JdbcUtil.sqlOrderInsert(curOmap);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        PrintWriter pw   = resp.getWriter();
        pw.print("{\"oid\":\"43\"}");
        pw.flush();

    }
}
