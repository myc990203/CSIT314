package project;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.HashMap;
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
    }
}