package CLASSWORK32LAB;

import java.util.List;

public class Vendor {
    private int value;
    private int total;
    private List<Product> products;
    private boolean receiver;

    public Vendor(int total, List<Product> products, boolean receiver) {
        this.value = 20;
        this.total = total;
        this.products = products;
        this.receiver = receiver;
    }

    public boolean isReceiver() {
        return receiver;
    }

    public void setReceiver(boolean receiver) {
        this.receiver = receiver;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
