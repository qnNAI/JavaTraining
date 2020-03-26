package by.training.finalproject.beans;

public class LocalAddress extends Entity {
    private String address;

    public LocalAddress() {}

    @Override
    public String toString() {
        return "LocalAddress{" +
                "address='" + address + '\'' +
                '}';
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
