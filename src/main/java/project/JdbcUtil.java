package project;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.json.JSONArray;

//import org.json.JSONObject;

import javax.xml.crypto.Data;
//test
public class JdbcUtil {
    //初始化连接sql
    public static Connection connectSql() throws ClassNotFoundException, SQLException {
        //final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        //final String DB_URL      = "jdbc:mysql://localhost:3306/RUNOOB";

        // MySQL 8.0 以上版本 - JDBC 驱动名及数据库 URL
        final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
        final String DB_URL      = "jdbc:mysql://localhost/CSIT314?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";


        // 数据库的用户名与密码，需要根据自己的设置
        final String USER = "root";
        final String PASS = "123456";

        Connection conn = null;
        Statement  stmt = null;
        // 注册 JDBC 驱动
        Class.forName(JDBC_DRIVER);

        // 打开链接
        System.out.println("连接数据库...");
        conn = DriverManager.getConnection(DB_URL, USER, PASS);
        return conn;
    }


    //sql select
    //TODO 判断密码，如果密码错误，解决报错并发送前端

    public static Customer sqlCusSelect(String userName, String pw) throws SQLException, ClassNotFoundException {
        Connection        conn = connectSql();
        String            sql  = "select * from Customer where cusName = ? and cusPw = ?;";
        PreparedStatement psmt = conn.prepareStatement(sql);
        psmt.setString(1, userName);
        psmt.setString(2, pw);
        ResultSet rs     = psmt.executeQuery();
        int       cusNum = 1;
        Customer  cus    = new Customer();
        while (rs.next()) {
            cusNum = rs.getInt("cusNum");
            System.out.println(cusNum);
            ArrayList<Vehicle> vehicleList = sqlVehicleSelect(cusNum);
            Pre_Order          curOrder    = new Pre_Order();
            cus = new Customer(rs.getInt("cusNum"), rs.getString("cusName"), rs.getString("gender"), rs.getString("cusDOB"), rs.getNString("phoneNum"), rs.getString("cusPw"),
                               rs.getString("email"), rs.getString("vipStart"), rs.getString("vipEnd"), vehicleList, curOrder);

        }
        return cus;
    }

    public static Professional sqlProSelect(String userName, String pw) throws SQLException, ClassNotFoundException {
        Connection conn = connectSql();

        String            sql  = "select * from Professional where proName = ? and proPw = ?;";
        PreparedStatement psmt = conn.prepareStatement(sql);
        psmt.setString(1, userName);
        psmt.setString(2, pw);
        ResultSet    rs     = psmt.executeQuery();
        int          proNum = 1;
        Professional pro    = new Professional();
        while (rs.next()) {
            proNum = rs.getInt("proNum");
            System.out.println(proNum);
            pro = new Professional(rs.getInt("proNum"), rs.getString("proName"), rs.getString("gender"), rs.getString("proDOB"), rs.getNString("phoneNum"), rs.getString("proPw"),
                                   rs.getString("email"), rs.getFloat("pLevel"), rs.getDouble("balance"), rs.getString("location"));
        }
        return pro;
    }

    public static ArrayList sqlVehicleSelect(int cusNum) throws SQLException, ClassNotFoundException {
        Connection        conn = connectSql();
        String            sql  = "select * from VEHICLE where cusNum = ?";
        PreparedStatement psmt = conn.prepareStatement(sql);
        psmt.setInt(1, cusNum);
        ResultSet rs          = psmt.executeQuery();
        ArrayList vehicleList = new ArrayList<Vehicle>();
        while (rs.next()) {
            Vehicle vehicle = new Vehicle(rs.getString("plateNum"), rs.getString("model"));
            System.out.println(vehicle.getPlateNum());
            vehicleList.add(vehicle);
        }
        return vehicleList;
    }

    public static String sqlOrderSelect(String userNum) throws SQLException, ClassNotFoundException {
        Connection        conn   = connectSql();
        String            sql    = "select * from ORDER where userID = ?";
        PreparedStatement psmt   = conn.prepareStatement(sql);
        psmt.setString(1, userNum);
        ResultSet  rs     = psmt.executeQuery();
        String res = "";
        while (rs.next()) {
            res = rs.getString(1);
        }
        return res;
    }


    //sql insert customer
    public static void sqlCusInsert(String username, String password, String DOB, String email, String phoneNum, String gender) throws SQLException, ClassNotFoundException {
        Connection con = connectSql();
        String     sql = "";
        sql = "insert into CUSTOMER (cusPw,cusName,cusDOB,phoneNum,vipStart,vipEnd,email,gender) values (?,?,?,?,?,?,?,?);";
        PreparedStatement psmt = con.prepareStatement(sql);
        psmt.setString(1, password);
        psmt.setString(2, username);
        //java.sql.Date dob= toSqlData(DOB);
        psmt.setString(3, DOB);
        psmt.setString(4, phoneNum);
        psmt.setString(5, "2022-01-01");
        psmt.setString(6, "2022-01-01");
        psmt.setString(7, email);
        psmt.setString(8, gender);
        psmt.execute();
        con.close();
    }

    //sql insert professional
    public static void sqlProInsert(String username, String password, String DOB, String email, String phoneNum, String gender, String location) throws SQLException, ClassNotFoundException {
        Connection        con  = connectSql();
        String            sql  = "insert into PROFESSIONAL (proPw,proName,proDOB,phoneNum,pLevel,balance,location,email,gender) values (?,?,?,?,?,?,?,?,?);";
        PreparedStatement psmt = con.prepareStatement(sql);
        psmt.setString(1, password);
        psmt.setString(2, username);
        psmt.setString(3, DOB);
        psmt.setString(4, phoneNum);
        psmt.setFloat(5, 5);
        psmt.setFloat(6, 0);
        psmt.setString(7, location);
        psmt.setString(8, email);
        psmt.setString(9, gender);
        psmt.execute();
        con.close();
    }

    //sql insert vehicle
    public static void sqlVehInsert(int userID,String plateNum,String model ) throws SQLException, ClassNotFoundException {
        Connection con = connectSql();
        String            sql         = "insert into VEHICLE (userID,plateNum,model) values (?,?,?)";
        PreparedStatement psmt        = con.prepareStatement(sql);
        psmt.setInt(1, userID);
        psmt.setString(2, plateNum);
        psmt.setString(3, model);
        con.close();
    }

//    //sql insert order
//    public static void sqlOrdInsert(String x) throws SQLException, ClassNotFoundException {
//        Connection con = connectSql();
//
//        String            sql            = "insert into ORDERS (orderID,orderStartDate,customerID,price,vehiclePlate,location,issue,professional,orderEndDate,review,rating,payCardNum,payType) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
//        PreparedStatement psmt           = con.prepareStatement(sql);
//        int               columnOfSql    = 1;
//        psmt.setString(columnOfSql, orderID);
//        psmt.setString(columnOfSql++, orderStartDate);
//        psmt.setInt(columnOfSql++, customerID.getUserID());
//        psmt.setDouble(columnOfSql++, price);
//        psmt.setString(columnOfSql++, vehiclePlate.getPlateNum());
//        psmt.setString(columnOfSql++, location);
//        psmt.setString(columnOfSql++, issue);
//        psmt.setInt(columnOfSql++, professional.getUserID());
//        psmt.setString(columnOfSql++, orderEndDate);
//        psmt.setString(columnOfSql++, review);
//        psmt.setFloat(columnOfSql++, rating);
//        psmt.setString(columnOfSql++, payCardNum);
//        psmt.setString(columnOfSql++, String.valueOf(payType));
//
//        con.close();
//    }
//
//    //sql update customer
//    public static boolean updateCustomer(JSONObject ob) throws SQLException, ClassNotFoundException {
//        Connection con = connectSql();
//
//
//        int    userID   = 0;
//        String userName = "";
//        String gender   = "";
//        String DOB      = "";
//        String phoneNum = "";
//        String password = "";
//        String email    = "";
//        String vipStart = "";
//        String vipEnd   = "";
//
//        String sql = "" +
//                     "update CUSTOMER " +
//                     "set userName=?,gender=?,DOB=?,phoneNum=?,password=?,email=?,vipStart=?,vipEnd=?," +
//                     "where userID=?";
//        //预编译sql语句
//        PreparedStatement psmt        = con.prepareStatement(sql);
//        int               columnOfSql = 1;
//        //先对应SQL语句，给SQL语句传递参数
//        psmt.setInt(columnOfSql, userID);
//        psmt.setString(columnOfSql++, userName);
//        psmt.setString(columnOfSql++, gender);
//        psmt.setString(columnOfSql++, DOB);
//        psmt.setString(columnOfSql++, phoneNum);
//        psmt.setString(columnOfSql++, password);
//        psmt.setString(columnOfSql++, email);
//        psmt.setString(columnOfSql++, vipStart);
//        psmt.setString(columnOfSql++, vipEnd);
//        //执行SQL语句
//        return psmt.execute();
//    }
//
//    //sql update Professional
//    public static boolean updateProfessional(JSONObject ob) throws SQLException, ClassNotFoundException {
//        Connection con = connectSql();
//
//        int    userID   = 0;
//        String userName = "";
//        String gender   = "";
//        String DOB      = "";
//        String phoneNum = "";
//        String password = "";
//        String email    = "";
//        float  plevel   = 1;
//        double balance  = 1.0;
//        String location = "";
//
//        String sql = "" +
//                     "update CUSTOMER " +
//                     "set userName=?,gender=?,DOB=?,phoneNum=?,password=?,email=?,plevel=?,balance=?,location=?" +
//                     "where userID=?";
//        //预编译sql语句
//        PreparedStatement psmt        = con.prepareStatement(sql);
//        int               columnOfSql = 1;
//        //先对应SQL语句，给SQL语句传递参数
//        psmt.setInt(columnOfSql, userID);
//        psmt.setString(columnOfSql++, userName);
//        psmt.setString(columnOfSql++, gender);
//        psmt.setString(columnOfSql++, DOB);
//        psmt.setString(columnOfSql++, phoneNum);
//        psmt.setString(columnOfSql++, password);
//        psmt.setString(columnOfSql++, email);
//        psmt.setFloat(columnOfSql++, plevel);
//        psmt.setDouble(columnOfSql++, balance);
//        psmt.setString(columnOfSql++, location);
//        //执行SQL语句
//        return psmt.execute();
//    }
//
//    //sql delete
//    public boolean sqlDeleteVehicle(JSONObject ob) throws SQLException, ClassNotFoundException {
//        Connection        conn     = connectSql();
//        int               cusID    = ob.getInt("cusID");
//        String            plantNum = ob.getString("plantNum");
//        String            sql      = "delete * from VEHICLE where cusID = ? and plantNum = ?";
//        PreparedStatement psmt     = conn.prepareStatement(sql);
//        psmt.setInt(1, cusID);
//        psmt.setString(2, plantNum);
//        return psmt.execute();
//    }


    //TODO
    //sql语句查询最后一个已存在的用户ID
    public int getNewID() throws SQLException, ClassNotFoundException {
        Connection        conn  = connectSql();
        String            sql   = "select MAX(cusID) from CUSTOMER;";
        PreparedStatement psmt  = conn.prepareStatement(sql);
        ResultSet         rs    = psmt.executeQuery();
        int               newID = rs.getInt("cusID");
        newID++;
        return newID;
    }

    public static java.sql.Date toSqlData(String data) {
        SimpleDateFormat sdf   = new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Date    sdate = null; //初始化
        try {
            java.util.Date udate = sdf.parse(data);
            sdate = new java.sql.Date(udate.getTime()); //2013-01-14
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return sdate;
    }

}
