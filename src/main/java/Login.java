import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import project.*;
//1231
@WebServlet("/Login")
public class Login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader bufferedReader = req.getReader();
        StringBuilder  stringBuilder  = new StringBuilder();
        String         line;
        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line);
        }
        String str = stringBuilder.toString();
        System.out.println(str);
        Map<String,String> reqmap = JSONLIKE.myJson(str);
        String              username = reqmap.get("userName");
        String              password = reqmap.get("password");
        String              role     = reqmap.get("type");
        Map<String, String> res      = new HashMap<String, String>();
        Map<String,String> map = new HashMap<String, String>();

        if (role.equals("cus")) {
            try {
                res = JdbcUtil.sqlCusLoginSelect(username);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            System.out.println(res.get("cusPw"));
            if (password.equals(res.get("cusPw"))) {
                resp.setCharacterEncoding("UTF-8");
                resp.setContentType("application/json");
                PrintWriter pw = resp.getWriter();
                map.put("uid",res.get("cusNum"));
                String json = JSONLIKE.myMap2JSON(map);
                System.out.println(json);
                pw.print(json);
                pw.flush();
            } else {
                System.out.println("f");
                resp.setCharacterEncoding("utf-8");
                resp.setContentType("text/html;charset=UTF-8");
                resp.sendRedirect("index.jsp");
            }
        } else if (role.equals("pro")) {
            try {
                res = JdbcUtil.sqlProLoginSelect(username);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            if (password.equals(res.get("proPw"))) {
                resp.setCharacterEncoding("utf-8");
                resp.setContentType("text/html;charset=UTF-8");
                resp.sendRedirect("./professional/professional.html");
            } else {
                resp.setCharacterEncoding("utf-8");
                resp.setContentType("text/html;charset=UTF-8");
                resp.sendRedirect("index.jsp");
            }
        }
    }

}