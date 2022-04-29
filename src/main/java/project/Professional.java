package project;

public class Professional extends User{
    private float plevel;
    private double balance;
    private String location;

    public Professional() {

    }
    public Professional(float plevel, double balance, String location) {
        this.plevel = plevel;
        this.balance = balance;
        this.location = location;
    }

    public Professional(int userID, String userName, String gender, String DOB, String phoneNum, String password, String email, float plevel, double balance, String location) {
        super(userID, userName, gender, DOB, phoneNum, password,email);
        this.plevel = plevel;
        this.balance = balance;
        this.location = location;
    }

    public float getPlevel() {
        return plevel;
    }

    public void setPlevel(float plevel) {
        this.plevel = plevel;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
//    public float calPlevel(ArrayList<Finshed_Order>){
//
//    }
//    public String toJson(){
//
//    }
}
