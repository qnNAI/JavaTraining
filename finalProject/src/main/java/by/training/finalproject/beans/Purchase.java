package by.training.finalproject.beans;

import by.training.finalproject.beans.infoEnum.ObtainingMethod;

public class Purchase extends Entity {
    private int productID;
    private int userID;
    private double finalPrice;
    private String address;
    private int localAddressID;
    private String date;
    private State state;
    private ObtainingMethod obtainingMethod;

    public Purchase() {}

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public double getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(double finalPrice) {
        this.finalPrice = finalPrice;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getLocalAddressID() {
        return localAddressID;
    }

    public void setLocalAddressID(int localAddressID) {
        this.localAddressID = localAddressID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public ObtainingMethod getObtainingMethod() {
        return obtainingMethod;
    }

    public void setObtainingMethod(ObtainingMethod obtainingMethod) {
        this.obtainingMethod = obtainingMethod;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "productID=" + productID +
                ", userID=" + userID +
                ", finalPrice=" + finalPrice +
                ", address='" + address + '\'' +
                ", localAddressID=" + localAddressID +
                ", date='" + date + '\'' +
                ", state=" + state +
                ", obtainingMethod=" + obtainingMethod +
                '}';
    }

    public enum State {
        ADDED,
        ORDERED,
        DELIVERED
    }
}
