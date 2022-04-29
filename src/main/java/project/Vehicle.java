package project;

public class Vehicle {
    private String plateNum;
    private String model;

    public Vehicle(String plateNum, String model) {
        this.plateNum = plateNum;
        this.model    = model;
    }
    public Vehicle() {

    }
    public String getPlateNum() {
        return plateNum;
    }

    public void setPlateNum(String plateNum) {
        this.plateNum = plateNum;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
