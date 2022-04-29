import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import project.*;

@WebServlet("/Login")
public class Login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取用户请求额的数据
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String bod = req.getParameter("bod");
        String customer_type = req.getParameter("customer_type");
        String email = req.getParameter("email");
        System.out.println("提交的数据："+username+"\t"+password+"\t"+bod+"\t"+customer_type+"\t"+email);
        resp.setContentType("text/html;charset=UTF-8");

        PrintWriter pw = resp.getWriter();
        //resp.sendRedirect("主页");
    }

}