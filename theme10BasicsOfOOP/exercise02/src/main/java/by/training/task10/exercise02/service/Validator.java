package by.training.task10.exercise02.service;

import by.training.task10.exercise02.entity.Payment;

import java.util.ArrayList;

public class Validator {
    public boolean checkIsProductExists(String name, Payment payment) {
        ArrayList<Payment.Product> products = new ArrayList<>(payment.getProductsList()); // список товаров

        for (int i = 0; i < products.size(); ++i) {
            if (products.get(i).getName().equals(name)) {       // если имя товаров совпадает - ошибка
                return false;
            }
        }
        return true;
    }

    public boolean checkIsAmountEnough(Payment.Product productAvailable, double amountToBuy) {
        return productAvailable.getAmount() >= amountToBuy; // имеется ли достаточное количество товара
    }
}
