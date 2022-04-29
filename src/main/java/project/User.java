package project;

public class User {
    protected int userID;
    protected String userName;
    protected String gender;
    protected String DOB;
    protected String phoneNum;
    protected String password;
    protected String email;
    public User(){

    }
    public User(int userID, String userName, String gender, String DOB, String phoneNum, String password, String email) {
        this.userID = userID;
        this.userName = userName;
        this.gender = gender;
        this.DOB = DOB;
        this.phoneNum = phoneNum;
        this.password = password;
        this.email = email;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //    public String toJson(){
//
//
//    }
}
