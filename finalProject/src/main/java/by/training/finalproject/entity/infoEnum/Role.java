package by.training.finalproject.entity.infoEnum;

public enum Role {
    USER("пользователь"),
    ADMINISTRATOR("администратор"),
    MASTER("мастер");

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
