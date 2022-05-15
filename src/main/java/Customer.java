import project.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
@WebServlet("/customer/Customer")
public class Customer extends HttpServlet{
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

        Map<String,String> map = JSONLIKE.myJson(str);

        int uid = Integer.parseInt(map.get("uid"));
        String              username = map.get("name");
        String              phone = map.get("Phone");
        String              date     = map.get("Time");
        String              address     = map.get("Address");
        String              issue     = map.get("Value");
        String              Review     = map.get("Review");
        String              Plate     = map.get("Plate");
        float price = 50;
        float vipPrice = 0;
        Map<String, String> res      = new HashMap<String, String>();
        try {

            res=JdbcUtil.sqlCusSelect(uid);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        String vipEnd=res.get("vipEnd");
        SimpleDateFormat curDate = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = new Date();
        Date date2 = new Date();
        int compare=0;
        try {
            date1 = curDate.parse(vipEnd);
            date2 = curDate.parse(date);
            compare=date1.compareTo(date2);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        //no vip
        if(compare<0){
            try {
                JdbcUtil.sqlCurrOrderInsert(date,Plate,price,address,issue, String.valueOf(uid));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }else{
            try {
                JdbcUtil.sqlCurrOrderInsert(date,Plate,vipPrice,address,issue, String.valueOf(uid));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        Map<String, String> oidmap      = new HashMap<String, String>();
        try {
            oidmap = JdbcUtil.sqlcurOrderIdSelect(uid);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        PrintWriter pw   = resp.getWriter();
        String      json = JSONLIKE.myMap2JSON(oidmap);
        System.out.println(json);
        System.out.println(json);
        pw.print(json);
        pw.flush();
    }
}

