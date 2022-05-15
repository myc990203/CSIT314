import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;


import project.*;

@WebServlet ("/register/Register")

public class Register extends HttpServlet {
    //处理post 请求
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("username");
        System.out.print(name + "\t");
        String pw = req.getParameter("password");
        System.out.print(pw + "\t");
        String userT = req.getParameter("user_type");
        System.out.print(userT + "\t");
        String date = req.getParameter("dob");
        System.out.print(date + "\t");
        String email = req.getParameter("email");
        System.out.print(email + "\t");
        String phone = req.getParameter("phoneNum");
        System.out.print(phone + "\t");
        String gender = req.getParameter("gender");
        System.out.print(gender + "\t");
        String plateN = req.getParameter("plateN");
        System.out.print(plateN + "\t");
        String vhn = req.getParameter("vm");
        System.out.print(vhn);
        String location = req.getParameter("location");

        if (userT.equals("cus")) {
            try {
                JdbcUtil.sqlCusInsert(name, pw, date, email, phone, gender, plateN, vhn);
                resp.setCharacterEncoding("utf-8");
                resp.setContentType("text/html;charset=UTF-8");
                resp.sendRedirect("../index.jsp");
            } catch (SQLException e) {
                resp.setCharacterEncoding("utf-8");
                resp.setContentType("text/html;charset=UTF-8");
                resp.sendRedirect("register.html");
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                resp.setCharacterEncoding("utf-8");
                resp.setContentType("text/html;charset=UTF-8");
                resp.sendRedirect("register.html");
                throw new RuntimeException(e);
            }
        } else if (userT.equals("pro")) {
            try {
                JdbcUtil.sqlProInsert(name, pw, date, email, phone,gender, location);
                resp.setCharacterEncoding("utf-8");
                resp.setContentType("text/html;charset=UTF-8");
                resp.sendRedirect("../index.jsp");
            } catch (SQLException e) {
                resp.setCharacterEncoding("utf-8");
                resp.setContentType("text/html;charset=UTF-8");
                resp.sendRedirect("register.html");
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                resp.setCharacterEncoding("utf-8");
                resp.setContentType("text/html;charset=UTF-8");
                resp.sendRedirect("register.html");
                throw new RuntimeException(e);
            }
        }
    }

}
