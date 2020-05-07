package by.training.finalproject.beans;

public class LocalAddress implements Entity {
    private Integer id;
    private String address;

    public LocalAddress() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
