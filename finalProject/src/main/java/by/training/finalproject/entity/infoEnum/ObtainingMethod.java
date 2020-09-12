package by.training.finalproject.entity.infoEnum;

public enum ObtainingMethod {
    DELIVERY("доставка"),
    PICKUP("самовывоз");

    private String name;

    ObtainingMethod(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Integer getIdentity() {
        return ordinal();
    }

    public static ObtainingMethod getByIdentity(Integer identity) {
        return ObtainingMethod.values()[identity];
    }

    public static ObtainingMethod getByName(String name) {
        for (ObtainingMethod method : ObtainingMethod.values()) {
            if (method.getName().equals(name)) {
                return method;
            }
        }
        return null;
    }
}