package by.training.finalproject.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ProductList implements Entity {
    private Purchase purchase;
    private Product product;
    private double finalPrice;
    private int amount;
}
