package by.training.finalproject.beans;

public class Order extends Entity {
    private String name;
    private String wishes;
    private int userID;

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

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    @Override
    public String toString() {
        return "Order{" +
                "name='" + name + '\'' +
                ", wishes='" + wishes + '\'' +
                ", userID=" + userID +
                '}';
    }
}
