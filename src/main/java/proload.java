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
import java.util.Map;


@WebServlet("/professional/proload")
public class proload extends HttpServlet {
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
        Map<String, String> map         = JSONLIKE.myJson(str);
        String              cusNum      = map.get("uid");
        String              coordinates = map.get("coordinates");
        System.out.println(coordinates);
        System.out.println("cusID= " + cusNum);
//        Map<String, String> cus    = new HashMap<>();
        String currentOrders = new String();
        try {
            currentOrders = JdbcUtil.sqlCurrOrderSelect(coordinates);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        PrintWriter pw = resp.getWriter();
//        String      json = JSONLIKE.myMap2JSON(cus);
        System.out.println("this is currentOrders： " + currentOrders);
        pw.print(currentOrders);
        pw.flush();
        System.out.println("professional/professional");
    }
}