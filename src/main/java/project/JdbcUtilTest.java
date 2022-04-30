package project;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class JdbcUtilTest {


    @Test
    void connectSql() {

    }

    @Test
    void sqlCusSelect() {
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
        JdbcUtil.sqlCusInsert("name", "pw", "2022-01-10", "2131231@gmail.com", "12345678", "male");
        Customer testCus = JdbcUtil.sqlCusSelect("name", "pw");
        assertEquals("name", testCus.getUserName());
    }

    @Test
    void sqlProInsert() throws SQLException, ClassNotFoundException {
        JdbcUtil.sqlProInsert("name", "pw", "2022-01-10", "2131231@gmail.com", "12345678", "male", "wollogong");
        Professional testCus = JdbcUtil.sqlProSelect("name", "pw");
        assertEquals("name", testCus.getUserName());
    }

    @Test
    void sqlVehInsert() {
    }

    @Test
    void sqlOrdInsert() {
    }

    @Test
    void updateCustomer() {
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