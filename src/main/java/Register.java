import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;


import project.*;
@WebServlet("/Register")
public class Register extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getParameter("user_type"));
        String userType = req.getParameter("user_type");
        if (userType.equals("1")){
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            String DOB = req.getParameter("dob");
            String email = req.getParameter("email");
            String phoneNum = req.getParameter("phoneNum");
            String gender = req.getParameter("gender");
            try {
                JdbcUtil.sqlCusInsert(username,password,DOB,email,phoneNum,gender);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }else {
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            String DOB = req.getParameter("dob");
            String email = req.getParameter("email");
            String phoneNum = req.getParameter("phoneNum");
            String gender = req.getParameter("gender");
            String location = req.getParameter("location");
            try {
                JdbcUtil.sqlProInsert(username,password,DOB,email,phoneNum,gender,location);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");
        resp.sendRedirect("index.jsp");
    }
}
