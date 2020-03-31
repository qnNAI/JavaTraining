package by.training.finalproject.beans;

import by.training.finalproject.beans.infoEnum.ObtainingMethod;

import java.util.Date;

public class ConfirmedOrder extends Entity {
    private Order order;
    private State state;
    private double finalPrice;
    private int amount;
    private String address;
    private LocalAddress localAddress;
    private Date date;
    private ObtainingMethod obtainingMethod;

    public ConfirmedOrder() {}

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
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

    public LocalAddress getLocalAddress() {
        return localAddress;
    }

    public void setLocalAddress(LocalAddress localAddress) {
        this.localAddress = localAddress;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public ObtainingMethod getObtainingMethod() {
        return obtainingMethod;
    }

    public void setObtainingMethod(ObtainingMethod obtainingMethod) {
        this.obtainingMethod = obtainingMethod;
    }

    @Override
    public String toString() {
        return "ConfirmedOrder{" +
                "order=" + order +
                ", state=" + state +
                ", finalPrice=" + finalPrice +
                ", amount=" + amount +
                ", address='" + address + '\'' +
                ", localAddress=" + localAddress +
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
