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
@WebServlet("/Renew")
public class Renew extends HttpServlet {
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
        String              Num = reqmap.get("Num");
        String              phone     = reqmap.get("phone");
        String              membNum = reqmap.get("membNum");
        String              birthday = reqmap.get("birthday");
        String              cardName     = reqmap.get("cardName");
        String              cardNum = reqmap.get("cardNum");
        String              expDate = reqmap.get("expDate");
        String              CVV     = reqmap.get("cvv");
        String res      = "";
        if (Num.equals("mobileNum")) {
            try {
                res = JdbcUtil.sqlRenewSelect(phone,true);
                if (res==null||"".equals(res)){
                    JdbcUtil.sqlRenewInsert(phone,membNum,birthday,cardName,cardNum,expDate,CVV);
                }else {
                    JdbcUtil.sqlRenewUpdateByPhone(phone,birthday,cardName,cardNum,expDate,CVV);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

        } else {
            try {
                res = JdbcUtil.sqlRenewSelect(membNum,false);
                if (res==null||"".equals(res)){
                    JdbcUtil.sqlRenewInsert(phone,membNum,birthday,cardName,cardNum,expDate,CVV);
                }else {
                    JdbcUtil.sqlRenewUpdateByMembNum(membNum,birthday,cardName,cardNum,expDate,CVV);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        PrintWriter pw   = resp.getWriter();
        pw.print("{\"status\":\"success\"}");
        pw.flush();
    }

}