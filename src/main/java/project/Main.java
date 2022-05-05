package project;

import java.sql.*;
import java.util.ArrayList;



enum PayType {
    VISA, MASTERCARD, UNIONPAY, PAYPAL;
}

public class Main {
    ArrayList curCustomer = new ArrayList<Customer>();
    static String json = "{\"contacDetails\": {\n" +   //JSON text in the file is written here
                         "            \"firstName\": \"Ram\",\n" +
                         "            \"lastName\": \"Sharma\"\n" +
                         "    },\n" +
                         "    \"phoneNumbers\": [\n" +
                         "            {\n" +
                         "                \"type\": \"home\",\n" +
                         "                \"phone-number\": \"212 888-2365\",\n" +
                         "            }\n" +
                         "    ]" +
                         "}";

    public static void main(String[] args) throws Exception {



    }
//    //初始化连接sql
//    public static Connection connectSql() throws ClassNotFoundException, SQLException {
//        //final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
//        //final String DB_URL      = "jdbc:mysql://localhost:3306/RUNOOB";
//
//        final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
//        final String DB_URL = "jdbc:mysql://localhost/CSIT314?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
//
//
//        // 数据库的用户名与密码，需要根据自己的设置
//        final String USER = "root";
//        final String PASS = "123456";
//
//        Connection conn = null;
//        Statement  stmt = null;
//        // 注册 JDBC 驱动
//        Class.forName(JDBC_DRIVER);
//
//        // 打开链接
//        System.out.println("连接数据库...");
//        conn = DriverManager.getConnection(DB_URL, USER, PASS);
//        return conn;
//    }
//    //sql select
//    public static Customer sqlCusSelect(JSONObject ob) throws SQLException, ClassNotFoundException {
//        Connection conn = connectSql();
//        int cusID = ob.getInt("cusID");
//        String sql = "select * from CUSTOMER where cusID = ?";
//        PreparedStatement psmt = conn.prepareStatement(sql);
//        psmt.setInt(1,cusID);
//        ResultSet rs = psmt.executeQuery();
//        ArrayList<Vehicle> vehicleList = sqlVehicleSelect(ob);
//        Pre_Order curOrder = new Pre_Order();
//        Customer cus = new Customer(rs.getInt("cusId"),rs.getString("userName"),rs.getString("gender"),rs.getString("DOB"), rs.getNString("phoneNum"),rs.getString("password"),
//                                    rs.getString("email"),rs.getString("vipStart"),rs.getString("vipEnd"),vehicleList,curOrder);
//        return cus;
//    }
//
//    public static Professional sqlProSelect(JSONObject ob) throws SQLException, ClassNotFoundException {
//        Connection conn = connectSql();
//        int proID = ob.getInt("proID");
//        String sql = "select * from PROFESSION where proID = ?";
//        PreparedStatement psmt = conn.prepareStatement(sql);
//        psmt.setInt(1,proID);
//        ResultSet rs = psmt.executeQuery();
//        Professional pro = new Professional(rs.getInt("proId"),rs.getString("userName"),rs.getString("gender"),rs.getString("DOB"), rs.getNString("phoneNum"),rs.getString("password"),
//                                    rs.getString("email"),rs.getFloat("plevel"),rs.getDouble("balance"),rs.getString("location"));
//        return pro;
//    }
//    public static ArrayList sqlVehicleSelect(JSONObject ob) throws SQLException, ClassNotFoundException {
//        Connection conn = connectSql();
//        int cusID = ob.getInt("cusID");
//        String sql = "select * from VEHICLE where cusID = ?";
//        PreparedStatement psmt = conn.prepareStatement(sql);
//        psmt.setInt(1,cusID);
//        ResultSet rs = psmt.executeQuery();
//        ArrayList vehicleList = new ArrayList<Vehicle>();
//        while (rs.next()){
//            Vehicle vehicle = new Vehicle(rs.getString("plateNum"),rs.getString("model"));
//            vehicleList.add(vehicle);
//        }
//        return vehicleList;
//    }
//
//    public static JSONObject sqlOrderSelect(JSONObject ob) throws SQLException, ClassNotFoundException {
//        Connection conn = connectSql();
//        int userID = ob.getInt("userID");
//        String sql = "select * from ORDER where userID = ?";
//        PreparedStatement psmt = conn.prepareStatement(sql);
//        psmt.setInt(1,userID);
//        ResultSet rs = psmt.executeQuery();
//        JSONObject result = new JSONObject();
//        while (rs.next()){
//            //返回一个Json
//        }
//        return result;
//    }
//
//
//    //sql insert customer
//    public static boolean sqlCusInsert(JSONObject ob) throws SQLException, ClassNotFoundException {
//        Connection con = connectSql();
//
//        int userID =0;
//        String userName="";
//        String gender="";
//        String DOB="";
//        String phoneNum="";
//        String password="";
//        String email="";
//        String vipStart="";
//        String vipEnd="";
//
//        String sql="insert into CUSTOMER (userID,userName,gender,DOB,phoneNum,password,email,vipStart,vipEnd) values (?,?,?,?,?,?,?,?,?);";
//
//        PreparedStatement psmt = con.prepareStatement(sql);
//        int columnOfSql=1;
//        psmt.setInt(columnOfSql, userID);
//        psmt.setString(columnOfSql++, userName);
//        psmt.setString(columnOfSql++, gender);
//        psmt.setString(columnOfSql++, DOB);
//        psmt.setString(columnOfSql++, phoneNum);
//        psmt.setString(columnOfSql++, password);
//        psmt.setString(columnOfSql++, email);
//        psmt.setString(columnOfSql++, vipStart);
//        psmt.setString(columnOfSql++, vipEnd);
//
//        return psmt.execute();
//    }
//    //sql insert professional
//    public static boolean sqlProInsert(JSONObject ob) throws SQLException, ClassNotFoundException {
//        Connection con = connectSql();
//
//        int userID =0;
//        String userName="";
//        String gender="";
//        String DOB="";
//        String phoneNum="";
//        String password="";
//        String email="";
//        float plevel = 1;
//        double balance = 1.0;
//        String location = "";
//
//        String sql="insert into CUSTOMER (userID,userName,gender,DOB,phoneNum,password,email,plevel,balance,location) values (?,?,?,?,?,?,?,?,?,?)";
//        PreparedStatement psmt = con.prepareStatement(sql);
//        int columnOfSql=1;
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
//        return psmt.execute();
//    }
//    //sql insert vehicle
//    public static boolean sqlVehInsert(JSONObject ob) throws SQLException, ClassNotFoundException {
//        Connection con = connectSql();
//
//        int userID =0;
//        String plateNum="";
//        String model="";
//
//
//        String sql="insert into CUSTOMER (userID,plateNum,model) values (?,?,?)";
//        PreparedStatement psmt = con.prepareStatement(sql);
//        int columnOfSql=1;
//        psmt.setInt(columnOfSql, userID);
//        psmt.setString(columnOfSql++, plateNum);
//        psmt.setString(columnOfSql++, model);
//        return psmt.execute();
//    }
//    //sql insert order
//    public static boolean sqlOrdInsert(JSONObject ob) throws SQLException, ClassNotFoundException {
//        Connection con = connectSql();
//
//        String orderID="";
//        String orderStartDate="";
//        Customer customerID = new Customer();
//        double price=1;
//        Vehicle vehiclePlate = new Vehicle();
//        String location="";
//        String issue="";
//        Professional professional= new Professional();
//        String orderEndDate="";
//        String review="";
//        float rating=1;
//        String payCardNum="";
//        PayType payType=PayType.valueOf("VISA");
//        String sql="insert into CUSTOMER (orderID,orderStartDate,customerID,price,vehiclePlate,location,issue,professional,orderEndDate,review,rating,payCardNum,payType) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
//        PreparedStatement psmt = con.prepareStatement(sql);
//        int columnOfSql=1;
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
//        return psmt.execute();
//    }
//
//    //sql update customer
//    public static boolean updateCustomer(JSONObject ob) throws SQLException, ClassNotFoundException {
//        Connection con = connectSql();
//
//
//        int userID =0;
//        String userName="";
//        String gender="";
//        String DOB="";
//        String phoneNum="";
//        String password="";
//        String email="";
//        String vipStart="";
//        String vipEnd="";
//
//        String sql = "" +
//                "update CUSTOMER " +
//                "set userName=?,gender=?,DOB=?,phoneNum=?,password=?,email=?,vipStart=?,vipEnd=?," +
//                "where userID=?";
//        //预编译sql语句
//        PreparedStatement psmt = con.prepareStatement(sql);
//        int columnOfSql=1;
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
//    //sql update Professional
//    public static boolean updateProfessional(JSONObject ob) throws SQLException, ClassNotFoundException {
//        Connection con = connectSql();
//
//        int userID =0;
//        String userName="";
//        String gender="";
//        String DOB="";
//        String phoneNum="";
//        String password="";
//        String email="";
//        float plevel = 1;
//        double balance = 1.0;
//        String location = "";
//
//        String sql = "" +
//                "update CUSTOMER " +
//                "set userName=?,gender=?,DOB=?,phoneNum=?,password=?,email=?,plevel=?,balance=?,location=?" +
//                "where userID=?";
//        //预编译sql语句
//        PreparedStatement psmt = con.prepareStatement(sql);
//        int columnOfSql=1;
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
//        Connection conn = connectSql();
//        int cusID = ob.getInt("cusID");
//        String plantNum = ob.getString("plantNum");
//        String sql = "delete * from VEHICLE where cusID = ? and plantNum = ?";
//        PreparedStatement psmt = conn.prepareStatement(sql);
//        psmt.setInt(1,cusID);
//        psmt.setString(2,plantNum);
//        return psmt.execute();
//    }
//
//
//    //TODO
//    //sql语句查询最后一个已存在的用户ID
//    public int getNewID() throws SQLException, ClassNotFoundException {
//        Connection conn = connectSql();
//        String sql = "select MAX(cusID) from CUSTOMER;";
//        PreparedStatement psmt = conn.prepareStatement(sql);
//        ResultSet rs = psmt.executeQuery();
//        int newID = rs.getInt("cusID");
//        newID++;
//        return newID;
//    }
//
//    public static JSONObject readJson(String json) throws Exception {
//        JSONObject ob = new JSONObject(json);
//        return ob;
//    }
//
//    public static void register(JSONObject ob) throws Exception {
//        //getting first and last name
//        String firstName = ob.getJSONObject("contacDetails").getString("firstName");
//        String lastName  = ob.getJSONObject("contacDetails").getString("lastName");
//        System.out.println("FirstName " + firstName);
//        System.out.println("LastName " + lastName);
//
//        //loop for printing the array as phoneNumber is stored as array.
//        JSONArray arr = ob.getJSONArray("phoneNumbers");
//        for (int i = 0; i < arr.length(); i++) {
//            String post_id = arr.getJSONObject(i).getString("phone-number");
//            System.out.println(post_id);
//        }
//    }

}
