package by.training.task13.beans;

import java.util.HashSet;
import java.util.Set;

public class Purchase {
    private int id;

    private Set<Product> products = new HashSet<Product>();
    private String address = "";
    private double finalPrice;
    private String date;
    private int amount;
    private State state;
    private Obtaining_method obtaining_method;

    public Purchase() {}

    public Purchase(int id, Set<Product> products, String address,
                    double finalPrice, String date, int amount, State state, Obtaining_method obtaining_method) {
        this.id = id;
        this.products = products;
        this.address = address;
        this.finalPrice = finalPrice;
        this.date = date;
        this.amount = amount;
        this.state = state;
        this.obtaining_method = obtaining_method;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(double finalPrice) {
        this.finalPrice = finalPrice;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Obtaining_method getObtaining_method() {
        return obtaining_method;
    }

    public void setObtaining_method(Obtaining_method obtaining_method) {
        this.obtaining_method = obtaining_method;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "id=" + id +
                ", products=" + products +
                ", address='" + address + '\'' +
                ", finalPrice=" + finalPrice +
                ", date=" + date +
                ", amount=" + amount +
                ", state=" + state +
                ", obtaining_method=" + obtaining_method +
                '}';
    }

    public enum State {
        IN_PRODUCTION,
        MADE
    }
    public enum Obtaining_method {
        DELIVERY,
        PICKUP
    }

}
