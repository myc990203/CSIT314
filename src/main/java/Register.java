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
        //获取用户请求额的数据

        String userType = req.getParameter("user_type");
        if (userType == "customer"){
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            String DOB = req.getParameter("dob");
            String email = req.getParameter("email");
            String phoneNum = req.getParameter("phoneNum");
            String gender = req.getParameter("gender");
            try {
                JdbcUtil.sqlCusInsert(userType,username,password,DOB,email,phoneNum,gender);
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
                JdbcUtil.sqlProInsert(userType,username,password,DOB,email,phoneNum,gender,location);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter pw = resp.getWriter();
        resp.sendRedirect("login.html");
    }

}
