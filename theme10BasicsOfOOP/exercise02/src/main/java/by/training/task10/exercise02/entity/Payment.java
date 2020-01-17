package by.training.task10.exercise02.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Payment {
    private ArrayList<Payment.Product> products;
    private ArrayList<Product> selectedProducts;

    public Payment(List<Payment.Product> products, List<Payment.Product> selectedProducts) {
        this.products = new ArrayList<>(products);
        this.selectedProducts = new ArrayList<>(selectedProducts);
    }

    public Payment() {
        products = new ArrayList<>();
        selectedProducts = new ArrayList<>();
    }

    public void addProductToSelectedProducts(Product product, double amount) {
        Product newProduct = new Product(product);
        newProduct.setAmount(amount);
        selectedProducts.add(newProduct);

    }

    public List<Product> getSelectedProducts() {
        return selectedProducts;
    }

    public void setProductsList(List<Payment.Product> products) {
        this.products = new ArrayList<>(products);
    }

    public void addProductToProductsList(Payment.Product product) {
        products.add(product);
    }

    public void addProductToProductsList(String name, double price, double amount, String measure) {
        products.add(new Product(name, price, amount, measure));
    }

    public void addProductToProductsList(List<String> params) throws NullPointerException, NumberFormatException {
        products.add(new Product(params));
    }

    public List<Payment.Product> getProductsList() {
        return products;
    }

    public class Product {
        String name;
        double price;
        double amount;
        String measure;

        public Product(String name, double price, double amount, String measure) {
            this.name = name;
            this.price = price;
            this.amount = amount;
            this.measure = measure;
        }

        public Product(List<String> params) {
            name = params.get(0);
            price = Double.parseDouble(params.get(1));
            amount = Double.parseDouble(params.get(2));
            measure = params.get(3);
        }

        public Product() {
            name = "none";
            price = 0.0;
            amount = 0.0;
            measure = "none";
        }

        public Product(Product product) {
            name = product.getName();
            price = product.getPrice();
            amount = product.getAmount();
            measure = product.getMeasure();
        }

        public void addPrice(double increase) {
            price += increase;
        }

        public void reducePrice(double reduction) {
            price -= reduction;
        }

        public void increaseAmount(double increase) {
            amount += increase;
        }

        public void reduceAmount(double reduction) {
            amount -= reduction;
        }

        public void changeName(String newName) {
            name = newName;
        }

        public void add(List<String> params) throws NumberFormatException, NullPointerException{
            name = params.get(0);
            price = Double.parseDouble(params.get(1));
            amount = Double.parseDouble(params.get(2));
            measure = params.get(3);
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }

        public double getAmount() {
            return amount;
        }

        public String getMeasure() {
            return measure;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Product)) return false;
            Product product = (Product) o;
            return Double.compare(product.getPrice(), getPrice()) == 0 &&
                    Double.compare(product.getAmount(), getAmount()) == 0 &&
                    getName().equals(product.getName()) &&
                    getMeasure().equals(product.getMeasure());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getName(), getPrice(), getAmount(), getMeasure());
        }

        @Override
        public String toString() {
            return "Product{" +
                    "name='" + name + '\'' +
                    ", price=" + price +
                    ", amount=" + amount +
                    ", measure='" + measure + '\'' +
                    '}';
        }
    }
}
