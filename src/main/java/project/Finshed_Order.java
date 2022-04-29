package project;

public class Finshed_Order extends Pre_Order{
    private Professional professional;
    private String orderEndDate;
    private String review;
    private float rating;
    private String payCardNum;
    private PayType payType;

    public Finshed_Order(){

    }

    public Finshed_Order(Professional professional, String orderEndDate, String review, float rating, String payCardNum, PayType payType) {
        this.professional = professional;
        this.orderEndDate = orderEndDate;
        this.review = review;
        this.rating = rating;
        this.payCardNum = payCardNum;
        this.payType = payType;
    }

    public Finshed_Order(String orderID, String orderStartDate, Customer customer, double price, Vehicle vehicle, String location, String issue, Professional professional, String orderEndDate, String review, float rating, String payCardNum, PayType payType) {
        super(orderID, orderStartDate, customer, price, vehicle, location, issue);
        this.professional = professional;
        this.orderEndDate = orderEndDate;
        this.review = review;
        this.rating = rating;
        this.payCardNum = payCardNum;
        this.payType = payType;
    }

    public Professional getProfessional() {
        return professional;
    }

    public void setProfessional(Professional professional) {
        this.professional = professional;
    }

    public String getOrderEndDate() {
        return orderEndDate;
    }

    public void setOrderEndDate(String orderEndDate) {
        this.orderEndDate = orderEndDate;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getPayCardNum() {
        return payCardNum;
    }

    public void setPayCardNum(String payCardNum) {
        this.payCardNum = payCardNum;
    }

    public PayType getPayType() {
        return payType;
    }

    public void setPayType(PayType payType) {
        this.payType = payType;
    }

//    public String toJson(){
//
//
//    }
}
