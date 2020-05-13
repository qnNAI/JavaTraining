package by.training.finalproject.beans;

import by.training.finalproject.beans.infoEnum.ObtainingMethod;

import java.time.LocalDate;

public class Purchase implements Entity {
    private Integer id;
    private User user;
    private State state;
    private String address;
    private LocalAddress localAddress;
    private LocalDate date;
    private ObtainingMethod obtainingMethod;

    public Purchase() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
                "id=" + id +
                ", user=" + user +
                ", state=" + state +
                ", address='" + address + '\'' +
                ", localAddress=" + localAddress +
                ", date=" + date +
                ", obtainingMethod=" + obtainingMethod +
                '}';
    }

    public enum State {
        ADDED("добавлен"),
        ORDERED("заказан"),
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
