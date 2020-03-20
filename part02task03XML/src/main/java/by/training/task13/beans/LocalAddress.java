package by.training.task13.beans;

public class LocalAddress {
    private int id;

    private String address = "";

    public LocalAddress() {}

    public LocalAddress(int id, String address) {
        this.id = id;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "LocalAddress{" +
                "id=" + id +
                ", address='" + address + '\'' +
                '}';
    }
}
