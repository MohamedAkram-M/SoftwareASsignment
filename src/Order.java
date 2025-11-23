import java.util.*;

// ==================== ORDER CLASS ====================
// Subject for Observer Pattern
class Order {
    private static int orderCounter = 0;
    private String orderId;
    private String customerName;
    private String orderType;
    private List<MenuItem> items;
    private List<OrderObserver> observers;

    public Order(String customerName, String orderType) {
        this.orderId = "ORD-" + (++orderCounter);
        this.customerName = customerName;
        this.orderType = orderType;
        this.items = new ArrayList<>();
        this.observers = new ArrayList<>();
    }

    // Observer pattern methods
    public void attach(OrderObserver observer) {
        observers.add(observer);
    }

    public void detach(OrderObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (OrderObserver observer : observers) {
            observer.update(this);
        }
    }

    // Order management methods
    public void addItem(MenuItem item) {
        items.add(item);
    }

    public void removeItem(MenuItem item) {
        items.remove(item);
    }

    public List<MenuItem> getItems() {
        return new ArrayList<>(items);
    }

    public double calculateSubtotal() {
        double subtotal = 0;
        for (MenuItem item : items) {
            subtotal += item.getPrice();
        }
        return subtotal;
    }

    public double calculateDiscount(DiscountStrategy discountStrategy) {
        double totalDiscount = 0;
        for (MenuItem item : items) {
            totalDiscount += discountStrategy.applyDiscount(item.getPrice(), item.getCategory());
        }
        return totalDiscount;
    }

    public double calculateTotal(DiscountStrategy discountStrategy) {
        return calculateSubtotal() - calculateDiscount(discountStrategy);
    }

    // Getters
    public String getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getOrderType() {
        return orderType;
    }
}