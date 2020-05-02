package by.training.finalproject.beans;

import by.training.finalproject.beans.infoEnum.ObtainingMethod;

import java.time.LocalDate;

public class ConfirmedOrder implements Entity {
    private int id;
    private Order order;
    private State state;
    private double finalPrice;
    private int amount;
    private String address;
    private LocalAddress localAddress;
    private LocalDate date;
    private ObtainingMethod obtainingMethod;

    public ConfirmedOrder() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
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
                "id=" + id +
                ", order=" + order +
                ", state=" + state +
                ", finalPrice=" + finalPrice +
                ", amount=" + amount +
                ", address='" + address + '\'' +
                ", localAddress=" + localAddress +
                ", date=" + date +
                ", obtainingMethod=" + obtainingMethod +
                '}';
    }

    public enum State {
        IN_PRODUCTION("изготавливается"),
        MADE("готов"),
        DELIVERED("доставлен");

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

        public static State getByIdentity(Integer identity) {
            return State.values()[identity];
        }

        public static State getByName(String name) {
            for (State s : State.values()) {
                if (s.getName().equals(name)) {
                    return s;
                }
            }
            return null;
        }
    }
}
