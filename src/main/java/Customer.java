import project.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
@WebServlet("/customer/Customer")
public class Customer extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String address = req.getParameter("address");
        String issue = req.getParameter("issue");
        String other = req.getParameter("ifOther");

        System.out.println(address);
        System.out.println(issue);
        System.out.println(other);

    }
}

