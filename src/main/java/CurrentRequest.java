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


@WebServlet("/current_request/current_request")
public class CurrentRequest extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("CurrentRequest in");
        BufferedReader bufferedReader = req.getReader();
        StringBuilder  stringBuilder  = new StringBuilder();
        String         line;
        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line);
        }
        String str = stringBuilder.toString();
        System.out.println(str);
        Map<String, String> map         = JSONLIKE.myJson(str);
        String              requestID   = map.get("requestID");
        String              pid         = map.get("pid");
        String              coordinates = map.get("coordinates");
        String              status      = map.get("status");
        try {
            JdbcUtil.updateCurrentOrder(requestID, pid, "processing");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println("update finish");
        Map<String, String> currentRequest = new HashMap<>();
        try {
            currentRequest = JdbcUtil.sqlCurrentRequest(coordinates, requestID);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println("select finish");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        PrintWriter pw   = resp.getWriter();
        String      json = JSONLIKE.myMap2JSON(currentRequest);
        pw.print(json);
        pw.flush();

    }
}

