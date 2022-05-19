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
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/renew/renew")
public class Renew extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("/renew/renew");
        BufferedReader bufferedReader = req.getReader();
        StringBuilder  stringBuilder  = new StringBuilder();
        String         line;
        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line);
        }
        String str = stringBuilder.toString();
        System.out.println(str);
        Map<String, String> reqmap = JSONLIKE.myJson(str);
        int              time   = Integer.parseInt(reqmap.get("time"))*30;
        String           uid = reqmap.get("uid");
        Date d = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar ca = Calendar.getInstance();
        ca.add(Calendar.DATE, time);// num为增加的天数，可以改变的
        d = ca.getTime();
        String enddate = format.format(d);
        try {
            JdbcUtil.sqlUpdateVIP(uid,enddate);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        PrintWriter pw = resp.getWriter();
        pw.print("{\"status\":\"success\"}");
        pw.flush();

    }

}