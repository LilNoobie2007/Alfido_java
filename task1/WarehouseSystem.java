import java.util.*;

// Abstraction: Base class cannot be instantiated directly
abstract class Product {
    // Encapsulation: Private fields protect data integrity
    private String productID;
    private int stockLevel;

    public Product(String productID, int stockLevel) {
        this.productID = productID;
        this.stockLevel = stockLevel;
    }

    // Getters for controlled access
    public String getProductID() { return productID; }
    public int getStockLevel() { return stockLevel; }

    // Protected method for internal updates
    protected void updateStock(int amount) {
        this.stockLevel += amount;
    }

    // Polymorphism: Abstract method for specific behaviors
    public abstract void processOrder(int quantity);
}

// Inheritance: Electronics implements specific logic
class Electronics extends Product {
    public Electronics(String productID, int stockLevel) {
        super(productID, stockLevel);
    }

    @Override
    public void processOrder(int quantity) {
        if (quantity <= getStockLevel()) {
            updateStock(-quantity);
            System.out.println("Order processed: " + quantity + " units of Electronics.");
        } else {
            System.out.println("Alert: Stock insufficient for Electronics " + getProductID());
        }
    }
}

// Inheritance: Perishables implements specific logic
class Perishables extends Product {
    public Perishables(String productID, int stockLevel) {
        super(productID, stockLevel);
    }

    @Override
    public void processOrder(int quantity) {
        // Polymorphism: Perishables might allow priority shipping even if stock is low
        if (quantity <= getStockLevel()) {
            updateStock(-quantity);
            System.out.println("Order processed: " + quantity + " units of Perishables.");
        } else {
            System.out.println("Alert: Perishables stock critical for " + getProductID());
        }
    }
}

public class WarehouseSystem {
    public static void main(String[] args) {
        // Polymorphism: Using base type references for different objects
        Product p1 = new Electronics("E-404", 50);
        Product p2 = new Perishables("P-909", 20);

        p1.processOrder(10);
        p2.processOrder(25); // Exceeds stock to show logic

        System.out.println("Final Stock E-404: " + p1.getStockLevel());
        System.out.println("Final Stock P-909: " + p2.getStockLevel());
    }
}
