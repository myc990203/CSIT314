package project;

import java.util.ArrayList;

public class Customer extends User{
    private String vipStart;
    private String vipEnd;
    private ArrayList<Vehicle> vehicleList = new ArrayList<>();
    private Pre_Order curOrder;

    public Customer(){

    }

    public Customer(String vipStart, String vipEnd, ArrayList<Vehicle> vehicleList, Pre_Order curOrder) {
        this.vipStart = vipStart;
        this.vipEnd = vipEnd;
        this.vehicleList = vehicleList;
        this.curOrder = curOrder;
    }

    public Customer(int userID, String userName, String gender, String DOB, String phoneNum, String password, String email, String vipStart, String vipEnd, ArrayList<Vehicle> vehicleList, Pre_Order curOrder) {
        super(userID, userName, gender, DOB, phoneNum, password,email);
        this.vipStart = vipStart;
        this.vipEnd = vipEnd;
        this.vehicleList = vehicleList;
        this.curOrder = curOrder;
    }

    public String getVipStart() {
        return vipStart;
    }

    public void setVipStart(String vipStart) {
        this.vipStart = vipStart;
    }

    public String getVipEnd() {
        return vipEnd;
    }

    public void setVipEnd(String vipEnd) {
        this.vipEnd = vipEnd;
    }

    public ArrayList<Vehicle> getVehicleList() {
        return vehicleList;
    }

    public void setVehicleList(ArrayList<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
    }

    public Pre_Order getCurOrder() {
        return curOrder;
    }

    public void setCurOrder(Pre_Order curOrder) {
        this.curOrder = curOrder;
    }
//    public boolean isVip(){
//
//
//    }
//    public String toJson(){
//
//
//    }
}
