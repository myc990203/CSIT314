import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import project.*;

@WebServlet("/Login")
public class Login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String              username = req.getParameter("u");
        String              password = req.getParameter("p");
        String              role     = req.getParameter("drone");
        Map<String, String> res      = new HashMap<String, String>();
        if (role.equals("cus")) {
            try {
                res = JdbcUtil.sqlCusLoginSelect(username);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            if (password.equals(res.get("cusPw"))) {
                resp.setCharacterEncoding("utf-8");
                resp.setContentType("text/html;charset=UTF-8");
                resp.sendRedirect("./customer/customer.html");
            } else {
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