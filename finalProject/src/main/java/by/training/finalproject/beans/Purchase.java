package by.training.finalproject.beans;

import by.training.finalproject.beans.infoEnum.ObtainingMethod;

import java.time.LocalDate;

public class Purchase extends Entity {
    private Product product;
    private User user;
    private double finalPrice;
    private String address;
    private LocalAddress localAddress;
    private LocalDate date;
    private State state;
    private ObtainingMethod obtainingMethod;

    public Purchase() {}

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public LocalAddress getLocalAddress() {
        return localAddress;
    }

    public void setLocalAddress(LocalAddress localAddress) {
        this.localAddress = localAddress;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
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
                "product=" + product +
                ", user=" + user +
                ", finalPrice=" + finalPrice +
                ", address='" + address + '\'' +
                ", localAddress=" + localAddress +
                ", date=" + date +
                ", state=" + state +
                ", obtainingMethod=" + obtainingMethod +
                '}';
    }

    public enum State {
        ADDED("добавлена"),
        ORDERED("заказана"),
        DELIVERED("доставлена");

        private String name;

        State(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public Integer getIdentity() {
            return ordinal();
        }

        public static ConfirmedOrder.State getByIdentity(Integer identity) {
            return ConfirmedOrder.State.values()[identity];
        }

        public static ConfirmedOrder.State getByName(String name) {
            for (ConfirmedOrder.State s : ConfirmedOrder.State.values()) {
                if (s.getName().equals(name)) {
                    return s;
                }
            }
            return null;
        }
    }
}
