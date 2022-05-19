package project;

import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class JdbcUtilTest {


    @Test
    void connectSql() {

    }

    @Test
    void sqlCusSelect() throws SQLException, ClassNotFoundException {
        Map<String,String> res = JdbcUtil.sqlCusSelect(7);
        System.out.println(res);
    }

    @Test
    void sqlProSelect() {
    }

    @Test
    void sqlVehicleSelect() {
    }

    @Test
    void sqlOrderSelect() {
    }

    @Test
    void sqlCusInsert() throws SQLException, ClassNotFoundException {
//        JdbcUtil.sqlCusInsert("name", "pw", "2022-01-10", "2131231@gmail.com", "12345678", "male");

    }

    @Test
    void sqlProInsert() throws SQLException, ClassNotFoundException {
//        JdbcUtil.sqlProInsert("name", "pw", "2022-01-10", "2131231@gmail.com", "12345678", "male", "wollogong");

    }

    @Test
    void sqlVehInsert() {
    }

    @Test
    void sqlOrdInsert() {
    }

    @Test
    void updateCustomer() throws SQLException, ClassNotFoundException {
        Map<String,String > map = new HashMap<>();
        map.put("uid", String.valueOf(8));
        map.put("cusPw", String.valueOf(123455));
        map.put("gender","male");
        map.put("cusName","william2");
        map.put("phone","420275558");
        map.put("dob","2022-05-19");
        map.put("model","undefined");
        map.put("plateNum","jmnh");
        map.put("email","ym554@uowmail.edu.au");

        JdbcUtil.updateCustomer(map);
    }

    @Test
    void updateProfessional() {
    }

    @Test
    void sqlDeleteVehicle() {
    }

    @Test
    void getNewID() {
    }

    @Test
    void toSqlData() {
        int time = 30;
        Date d = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String currdate = format.format(d);
        System.out.println("现在的日期是：" + currdate);

        Calendar ca = Calendar.getInstance();
        ca.add(Calendar.DATE, time);// num为增加的天数，可以改变的
        d = ca.getTime();
        String enddate = format.format(d);
        System.out.println(enddate);
    }
    @Test
    void getDistance(){
        String a = "-34.41631237896929#150.88914851692778";
        String b = "-34.414328674061366#150.87101276065172";
        double dis = JdbcUtil.getDistance(a,b);
        System.out.println(dis);
    }
    @Test
    void sqlCurrOrderSelect() throws SQLException, ClassNotFoundException {
        String te = "-34.39350965887256#150.88522712732396";
        String res = JdbcUtil.sqlCurrOrderSelect(te);
        System.out.println(res);
    }


    @Test
    void sqlOrderInsert() throws SQLException, ClassNotFoundException {
        Map<String, String> map = new HashMap<String, String>();
        map = JdbcUtil.sqlcurOrderSelect("1");
        map.remove("cur_orderid");
        map.remove("sstate");
        map.put("orderid","1");
        map.put("payType","payType");
        map.put("payCardNum","payCardNum");
        map.put("star","4");
        map.put("comm","comm");
        map.put("payType","payType");
        map.put("orderEndDate","2022-05-18");
        System.out.println(map);
        JdbcUtil.sqlOrderInsert(map);
    }
    @Test
    void sqlUpdateVIP() throws SQLException, ClassNotFoundException {
        JdbcUtil.sqlUpdateVIP("7","2022-06-18");

    }
}