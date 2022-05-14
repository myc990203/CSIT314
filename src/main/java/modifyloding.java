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
import java.util.HashMap;
import java.util.Map;

@WebServlet("/user_info/user_info")
public class modifyloding extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("post");
        BufferedReader bufferedReader = req.getReader();
        StringBuilder  stringBuilder  = new StringBuilder();
        String         line;
        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line);
        }
        String str = stringBuilder.toString();
        System.out.println(str);
        Map<String,String>  res = new HashMap<String, String>();
        Map<String, String> map = JSONLIKE.myJson(str);
        String              userID = map.get("uid");
        String userType = map.get("type");
        System.out.println(userType);
        if (userType.equals("cus")){
            try {
                res = JdbcUtil.sqlCusSelect(1);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }else {
            try {
                res = JdbcUtil.sqlProSelect(userID);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        PrintWriter pw   = resp.getWriter();
        String      json = JSONLIKE.myMap2JSON(res);
        System.out.println(json);
        pw.print(json);
        pw.flush();
    }
}