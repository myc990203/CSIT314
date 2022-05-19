import project.JSONLIKE;
import project.JdbcUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/modify_pro_info/UpdatePro")
public class UpdatePro extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("UpdatePro.java");
        BufferedReader bufferedReader = req.getReader();
        StringBuilder  stringBuilder  = new StringBuilder();
        String         line;
        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line);
        }
        String              str = stringBuilder.toString();
        Map<String, String> res = new HashMap<String, String>();
        Map<String, String> map = JSONLIKE.myJson(str);
        System.out.println(map.toString());
        String userID   = map.get("uid");
        String userType = map.get("type");
        try {
            JdbcUtil.updateProfessional(map);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

}
