import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/professional/Professional")
public class Professional extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String address = req.getParameter("address");
        String issue   = req.getParameter("issue");
        String other   = req.getParameter("ifOther");

        System.out.println(address);
        System.out.println(issue);
        System.out.println(other);
    }
}
