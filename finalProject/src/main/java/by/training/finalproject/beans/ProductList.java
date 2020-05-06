package by.training.finalproject.beans;

public class ProductList implements Entity {
    private int purchaseID;
    private int productID;
    private double finalPrice;
    private int amount;

    public ProductList() {
    }

    public int getPurchaseID() {
        return purchaseID;
    }

    public void setPurchaseID(int purchaseID) {
        this.purchaseID = purchaseID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
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
                "purchaseID=" + purchaseID +
                ", productID=" + productID +
                ", finalPrice=" + finalPrice +
                ", amount=" + amount +
                '}';
    }
}
