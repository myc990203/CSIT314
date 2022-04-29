package project;

public class Pre_Order {
    protected String orderID;
    protected String orderStartDate;
    protected Customer customer;
    protected double price;
    protected Vehicle vehicle;
    protected String location;
    protected String issue;

    public Pre_Order() {

    }
    public Pre_Order(String orderID, String orderStartDate, Customer customer, double price, Vehicle vehicle, String location, String issue) {
        this.orderID = orderID;
        this.orderStartDate = orderStartDate;
        this.customer = customer;
        this.price = price;
        this.vehicle = vehicle;
        this.location = location;
        this.issue = issue;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getOrderStartDate() {
        return orderStartDate;
    }

    public void setOrderStartDate(String orderStartDate) {
        this.orderStartDate = orderStartDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }
    //    public String toJson(){
//
//
//    }
}
