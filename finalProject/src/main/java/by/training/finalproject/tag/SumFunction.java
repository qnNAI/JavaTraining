package by.training.finalproject.tag;

import by.training.finalproject.beans.ProductList;

import java.util.List;

public class SumFunction {
    public static double sum(List<ProductList> list) {
        double sum = 0;
        for (ProductList productList : list) {
            sum += productList.getFinalPrice();
        }
        return sum;
    }
}
