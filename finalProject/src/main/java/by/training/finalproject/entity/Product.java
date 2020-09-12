package by.training.finalproject.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@NoArgsConstructor
public class Product implements Entity {
    @Getter @Setter private Integer id;
    @Getter @Setter private User user;
    @Getter @Setter private String name;
    @Getter @Setter private double price;
    @Getter @Setter private String description;
    @Getter @Setter private String imagePath;
    private boolean isInBasket;

    public boolean getIsInBasket() {
        return isInBasket;
    }

    public void setInBasket(boolean inBasket) {
        isInBasket = inBasket;
    }
}
