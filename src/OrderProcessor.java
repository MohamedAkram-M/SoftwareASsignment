import java.util.*;

// ==================== TEMPLATE METHOD PATTERN ====================
// Abstract class defining the order processing workflow
abstract class OrderProcessor {
    protected Scanner scanner;

    public OrderProcessor(Scanner scanner) {
        this.scanner = scanner;
    }

    // Template method - defines the skeleton of the algorithm
    public final void processOrder(Order order, PaymentStrategy paymentStrategy, DiscountStrategy discountStrategy) {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("   PROCESSING ORDER");
        System.out.println("=".repeat(60));

        // Step 1: Verify order
        verifyOrder(order);

        // Step 2: Apply specific order type logic
        handleOrderSpecifics(order);

        // Step 3: Calculate pricing
        calculatePricing(order, discountStrategy);

        // Step 4: Process payment
        processPayment(order, paymentStrategy, discountStrategy);

        // Step 5: Notify observers
        order.notifyObservers();

        // Step 6: Finalize order
        finalizeOrder(order);
    }

    // Common steps
    private void verifyOrder(Order order) {
        System.out.println("\n[VERIFICATION] Verifying order items...");
        if (order.getItems().isEmpty()) {
            System.out.println("ERROR: Order has no items!");
            return;
        }
        System.out.println("Order verified: " + order.getItems().size() + " items found.");
    }

    private void calculatePricing(Order order, DiscountStrategy discountStrategy) {
        System.out.println("\n[PRICING] Calculating order total...");
        System.out.println("Order ID: " + order.getOrderId());
        System.out.println("Customer: " + order.getCustomerName());
        System.out.println("\nItems:");
        System.out.println("-".repeat(60));

        for (MenuItem item : order.getItems()) {
            System.out.printf("%-40s $%.2f%n", item.getDescription(), item.getPrice());
        }

        System.out.println("-".repeat(60));
        double subtotal = order.calculateSubtotal();
        double discount = order.calculateDiscount(discountStrategy);
        double total = order.calculateTotal(discountStrategy);

        System.out.printf("Subtotal: $%.2f%n", subtotal);
        System.out.printf("Discount (%s): -$%.2f%n", discountStrategy.getDiscountName(), discount);
        System.out.printf("Total: $%.2f%n", total);
    }

    private void processPayment(Order order, PaymentStrategy paymentStrategy, DiscountStrategy discountStrategy) {
        System.out.println("\n[PAYMENT] Processing payment...");
        double total = order.calculateTotal(discountStrategy);
        paymentStrategy.pay(total);
        System.out.println("Payment completed successfully!");
    }

    private void finalizeOrder(Order order) {
        System.out.println("\n[FINALIZATION] Order finalized!");
        System.out.println("Order ID: " + order.getOrderId());
    }

    // Abstract methods - to be implemented by subclasses
    protected abstract void handleOrderSpecifics(Order order);
}

// ==================== CONCRETE ORDER PROCESSORS ====================
class DineInOrderProcessor extends OrderProcessor {
    public DineInOrderProcessor(Scanner scanner) {
        super(scanner);
    }

    @Override
    protected void handleOrderSpecifics(Order order) {
        System.out.println("\n[DINE-IN] Processing dine-in order...");
        System.out.print("Enter table number: ");
        String tableNumber = scanner.nextLine();
        System.out.println("Order will be served at Table " + tableNumber);
    }
}

class DeliveryOrderProcessor extends OrderProcessor {
    public DeliveryOrderProcessor(Scanner scanner) {
        super(scanner);
    }

    @Override
    protected void handleOrderSpecifics(Order order) {
        System.out.println("\n[DELIVERY] Processing delivery order...");
        System.out.print("Enter delivery address: ");
        String address = scanner.nextLine();
        System.out.println("Order will be delivered to: " + address);
        System.out.println("Estimated delivery time: 30-45 minutes");
        System.out.println("Delivery fee: $5.00 (included in total)");
    }
}

class TakeawayOrderProcessor extends OrderProcessor {
    public TakeawayOrderProcessor(Scanner scanner) {
        super(scanner);
    }

    @Override
    protected void handleOrderSpecifics(Order order) {
        System.out.println("\n[TAKEAWAY] Processing takeaway order...");
        System.out.print("Enter pickup time (e.g., 6:30 PM): ");
        String pickupTime = scanner.nextLine();
        System.out.println("Order will be ready for pickup at: " + pickupTime);
        System.out.println("Please collect from the counter.");
    }
}