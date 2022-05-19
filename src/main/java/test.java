import project.JSONLIKE;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;


@WebServlet("/test")
public class test extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        BufferedReader bufferedReader = req.getReader();
        StringBuilder  stringBuilder  = new StringBuilder();
        String         line;
        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line);
        }
        String str = stringBuilder.toString();
        System.out.println(str);
        Map<String, String> map = JSONLIKE.myJson(str);
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        PrintWriter pw   = resp.getWriter();
        String      json = JSONLIKE.myMap2JSON(map);
        System.out.println(json);
        pw.print(json);
        pw.flush();
        //resp.getOutputStream().print(jsonObject);


        //        System.out.println("post_test");
//        JSONObject reqJson;
//        JSONObject respJson = new JSONObject();
////get Reader from request
//        Reader     reqReader = req.getReader();
//        JSONParser parser    = new JSONParser();
////parse our request to json
//        try {
//            reqJson = (JSONObject) parser.parse(reqReader);
//            System.out.println(reqJson);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }


//        StringBuffer jb = new StringBuffer();
//        String line = null;
//        BufferedReader reader = req.getReader();
//        while ((line = reader.readLine()) != null) {
//            jb.append(line);
//        }
//        JSONObject jsonObject =  HTTP.toJSONObject(jb.toString());
//        System.out.println(jsonObject.getJSONObject("uid"));

//        resp.setCharacterEncoding("utf-8");
//        resp.setContentType("application/json;charset=UTF-8");
//        PrintWriter pw = resp.getWriter();
//        Map<String,String> map = new HashMap<>();
//        map.put("username",req.getParameter("u"));
//        pw.write(map.toString());
    }

}
