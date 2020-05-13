package by.training.finalproject.beans;

public class ProductList implements Entity {
    private Purchase purchase;
    private Product product;
    private double finalPrice;
    private int amount;

    public ProductList() {
    }

    public Purchase getPurchase() {
        return purchase;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(double finalPrice) {
        this.finalPrice = finalPrice;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "ProductList{" +
                "purchase=" + purchase +
                ", product=" + product +
                ", finalPrice=" + finalPrice +
                ", amount=" + amount +
                '}';
    }
}
