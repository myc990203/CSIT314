package project;

public class Payment {
    private String transType;
    private String transDate;
    private double amount;

    public Payment(){

    }
    public Payment(String transType, String transDate, double amount) {
        this.transType = transType;
        this.transDate = transDate;
        this.amount = amount;
    }

    public String getTransType() {
        return transType;
    }

    public void setTransType(String transType) {
        this.transType = transType;
    }

    public String getTransDate() {
        return transDate;
    }

    public void setTransDate(String transDate) {
        this.transDate = transDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
//    public String toJson(){
//
//
//    }
}
