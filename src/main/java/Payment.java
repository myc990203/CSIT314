import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import project.*;

@WebServlet("/payment/Payment")

public class Payment extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        System.out.print("11111111111");
//        String pay_type = req.getParameter("pay_type");
//        System.out.print(pay_type + "\t");
        BufferedReader bufferedReader_pay = req.getReader();
        StringBuilder  stringBuilder_pay  = new StringBuilder();
        String         line_pay;
        while ((line_pay = bufferedReader_pay.readLine()) != null) {
            stringBuilder_pay.append(line_pay);
        }
        String str = stringBuilder_pay.toString();
        System.out.println(str);
    }
}
