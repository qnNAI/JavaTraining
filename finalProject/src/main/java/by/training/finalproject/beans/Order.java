package by.training.finalproject.beans;

public class Order extends Entity {
    private String name;
    private String wishes;
    private User user;

    public Order() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWishes() {
        return wishes;
    }

    public void setWishes(String wishes) {
        this.wishes = wishes;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Order{" +
                "name='" + name + '\'' +
                ", wishes='" + wishes + '\'' +
                ", user=" + user +
                '}';
    }
}
