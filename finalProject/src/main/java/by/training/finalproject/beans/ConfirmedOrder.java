package by.training.finalproject.beans;

import by.training.finalproject.beans.infoEnum.ObtainingMethod;

public class ConfirmedOrder extends Entity {
    private int orderID;
    private State state;
    private double finalPrice;
    private int amount;
    private String address;
    private int localAddressID;
    private String date;
    private ObtainingMethod obtainingMethod;

    public ConfirmedOrder() {}

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public double getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(double finalPrice) {
        this.finalPrice = finalPrice;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ObtainingMethod getObtainingMethod() {
        return obtainingMethod;
    }

    public void setObtainingMethod(ObtainingMethod obtainingMethod) {
        this.obtainingMethod = obtainingMethod;
    }

    public int getLocalAddressID() {
        return localAddressID;
    }

    public void setLocalAddressID(int localAddressID) {
        this.localAddressID = localAddressID;
    }

    @Override
    public String toString() {
        return "ConfirmedOrder{" +
                "orderID=" + orderID +
                ", state=" + state +
                ", finalPrice=" + finalPrice +
                ", amount=" + amount +
                ", address='" + address + '\'' +
                ", date='" + date + '\'' +
                ", obtainingMethod=" + obtainingMethod +
                '}';
    }

    public enum State {
        IN_PRODUCTION,
        MADE,
        DELIVERED
    }
}
