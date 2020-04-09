package by.training.finalproject.beans.infoEnum;

public enum Role {
    ADMINISTRATOR("администратор"),
    USER("пользователь");

    private String name;

    Role(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Integer getIdentity() {
        return ordinal();
    }

    public static Role getByIdentity(Integer identity) {
        return Role.values()[identity];
    }
}
