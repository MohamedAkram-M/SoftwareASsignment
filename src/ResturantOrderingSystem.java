// ==================== MENU ITEM INTERFACE ====================
// Component for Decorator Pattern
interface MenuItem {
    String getName();
    String getDescription();
    double getPrice();
    String getCategory();
}

// ==================== BASE MENU ITEMS ====================
// Concrete Components
class Pizza implements MenuItem {
    private String name;
    private String description;
    private double price;

    public Pizza(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    @Override
    public String getName() { return name; }

    @Override
    public String getDescription() { return description; }

    @Override
    public double getPrice() { return price; }

    @Override
    public String getCategory() { return "Pizza"; }
}

class Burger implements MenuItem {
    private String name;
    private String description;
    private double price;

    public Burger(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    @Override
    public String getName() { return name; }

    @Override
    public String getDescription() { return description; }

    @Override
    public double getPrice() { return price; }

    @Override
    public String getCategory() { return "Burger"; }
}

class ChickenDish implements MenuItem {
    private String name;
    private String description;
    private double price;

    public ChickenDish(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    @Override
    public String getName() { return name; }

    @Override
    public String getDescription() { return description; }

    @Override
    public double getPrice() { return price; }

    @Override
    public String getCategory() { return "Chicken"; }
}

class MeatDish implements MenuItem {
    private String name;
    private String description;
    private double price;

    public MeatDish(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    @Override
    public String getName() { return name; }

    @Override
    public String getDescription() { return description; }

    @Override
    public double getPrice() { return price; }

    @Override
    public String getCategory() { return "Meat"; }
}

// ==================== DECORATOR PATTERN - ADD-ONS ====================
// Decorator Base Class
abstract class MenuItemDecorator implements MenuItem {
    protected MenuItem menuItem;

    public MenuItemDecorator(MenuItem menuItem) {
        this.menuItem = menuItem;
    }

    @Override
    public String getName() { return menuItem.getName(); }

    @Override
    public String getDescription() { return menuItem.getDescription(); }

    @Override
    public double getPrice() { return menuItem.getPrice(); }

    @Override
    public String getCategory() { return menuItem.getCategory(); }
}

// Concrete Decorators
class ExtraCheeseDecorator extends MenuItemDecorator {
    public ExtraCheeseDecorator(MenuItem menuItem) {
        super(menuItem);
    }

    @Override
    public String getDescription() {
        return menuItem.getDescription() + ", Extra Cheese";
    }

    @Override
    public double getPrice() {
        return menuItem.getPrice() + 2.0;
    }
}

class SpecialSauceDecorator extends MenuItemDecorator {
    public SpecialSauceDecorator(MenuItem menuItem) {
        super(menuItem);
    }

    @Override
    public String getDescription() {
        return menuItem.getDescription() + ", Special Sauce";
    }

    @Override
    public double getPrice() {
        return menuItem.getPrice() + 1.5;
    }
}

class ExtraToppingsDecorator extends MenuItemDecorator {
    public ExtraToppingsDecorator(MenuItem menuItem) {
        super(menuItem);
    }

    @Override
    public String getDescription() {
        return menuItem.getDescription() + ", Extra Toppings";
    }

    @Override
    public double getPrice() {
        return menuItem.getPrice() + 3.0;
    }
}

// ==================== ABSTRACT FACTORY PATTERN ====================
// Abstract Factory
interface MenuFactory {
    MenuItem createMainDish();
    MenuItem createSideDish();
    MenuItem createDrink();
}

// Concrete Factory - Vegetarian Menu
class VegetarianMenuFactory implements MenuFactory {
    @Override
    public MenuItem createMainDish() {
        return new Pizza("Veggie Pizza", "Delicious vegetarian pizza", 12.99);
    }

    @Override
    public MenuItem createSideDish() {
        return new Pizza("Garlic Bread", "Fresh garlic bread", 4.99);
    }

    @Override
    public MenuItem createDrink() {
        return new ChickenDish("Fresh Juice", "Organic fruit juice", 3.99);
    }
}

// Concrete Factory - Non-Vegetarian Menu
class NonVegetarianMenuFactory implements MenuFactory {
    @Override
    public MenuItem createMainDish() {
        return new ChickenDish("Grilled Chicken", "Tender grilled chicken", 15.99);
    }

    @Override
    public MenuItem createSideDish() {
        return new MeatDish("Beef Ribs", "Smoky beef ribs", 8.99);
    }

    @Override
    public MenuItem createDrink() {
        return new ChickenDish("Cola", "Refreshing cola", 2.99);
    }
}

// Concrete Factory - Kids Menu
class KidsMenuFactory implements MenuFactory {
    @Override
    public MenuItem createMainDish() {
        return new Burger("Kids Burger", "Small burger with cheese", 6.99);
    }

    @Override
    public MenuItem createSideDish() {
        return new Pizza("Mini Pizza", "Small cheese pizza", 5.99);
    }

    @Override
    public MenuItem createDrink() {
        return new ChickenDish("Apple Juice", "Fresh apple juice", 2.49);
    }
}

// ==================== FACTORY METHOD PATTERN ====================
// Creator
abstract class MenuItemCreator {
    public abstract MenuItem createMenuItem(String variant);

    public MenuItem orderMenuItem(String variant) {
        MenuItem item = createMenuItem(variant);
        System.out.println("Created: " + item.getName());
        return item;
    }
}

// Concrete Creators
class PizzaCreator extends MenuItemCreator {
    @Override
    public MenuItem createMenuItem(String variant) {
        switch (variant.toLowerCase()) {
            case "italian":
                return new Pizza("Italian Pizza", "Authentic Italian style", 14.99);
            case "eastern":
                return new Pizza("Eastern Pizza", "Spicy eastern flavor", 13.99);
            case "classic":
                return new Pizza("Classic Pizza", "Traditional cheese pizza", 11.99);
            default:
                return new Pizza("Regular Pizza", "Standard pizza", 10.99);
        }
    }
}

class BurgerCreator extends MenuItemCreator {
    @Override
    public MenuItem createMenuItem(String variant) {
        switch (variant.toLowerCase()) {
            case "classic":
                return new Burger("Classic Burger", "Traditional beef burger", 8.99);
            case "deluxe":
                return new Burger("Deluxe Burger", "Premium burger with extras", 12.99);
            case "veggie":
                return new Burger("Veggie Burger", "Vegetarian burger", 9.99);
            default:
                return new Burger("Regular Burger", "Standard burger", 7.99);
        }
    }
}

// ==================== OBSERVER PATTERN ====================
// Observer Interface
interface OrderObserver {
    void update(Order order);
}

// Concrete Observers
class KitchenSystem implements OrderObserver {
    @Override
    public void update(Order order) {
        System.out.println("\n[KITCHEN] New order received!");
        System.out.println("Order ID: " + order.getOrderId());
        System.out.println("Items to prepare:");
        for (MenuItem item : order.getItems()) {
            System.out.println("  - " + item.getName());
        }
    }
}

class WaiterSystem implements OrderObserver {
    @Override
    public void update(Order order) {
        System.out.println("\n[WAITER] New order notification!");
        System.out.println("Order ID: " + order.getOrderId());
        System.out.println("Table/Customer: " + order.getCustomerName());
        System.out.println("Order Type: " + order.getOrderType());
    }
}

// ==================== STRATEGY PATTERN - PAYMENT ====================
// Strategy Interface
interface PaymentStrategy {
    void pay(double amount);
    String getPaymentMethod();
}

// Concrete Strategies
class CashPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + String.format("%.2f", amount) + " in Cash");
    }

    @Override
    public String getPaymentMethod() {
        return "Cash";
    }
}

class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;

    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + String.format("%.2f", amount) +
                " using Credit Card ending in " +
                cardNumber.substring(cardNumber.length() - 4));
    }

    @Override
    public String getPaymentMethod() {
        return "Credit Card";
    }
}

class MobileWalletPayment implements PaymentStrategy {
    private String walletId;

    public MobileWalletPayment(String walletId) {
        this.walletId = walletId;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + String.format("%.2f", amount) +
                " using Mobile Wallet: " + walletId);
    }

    @Override
    public String getPaymentMethod() {
        return "Mobile Wallet";
    }
}

// ==================== STRATEGY PATTERN - DISCOUNT ====================
// Discount Strategy Interface
interface DiscountStrategy {
    double applyDiscount(double price, String category);
    String getDiscountName();
}

// Concrete Discount Strategies
class PizzaDiscountStrategy implements DiscountStrategy {
    @Override
    public double applyDiscount(double price, String category) {
        if (category.equalsIgnoreCase("Pizza")) {
            return price * 0.15; // 15% off
        }
        return 0;
    }

    @Override
    public String getDiscountName() {
        return "Pizza Special (15% off)";
    }
}

class ChickenDiscountStrategy implements DiscountStrategy {
    @Override
    public double applyDiscount(double price, String category) {
        if (category.equalsIgnoreCase("Chicken")) {
            return price * 0.20; // 20% off
        }
        return 0;
    }

    @Override
    public String getDiscountName() {
        return "Chicken Special (20% off)";
    }
}

class MeatDiscountStrategy implements DiscountStrategy {
    @Override
    public double applyDiscount(double price, String category) {
        if (category.equalsIgnoreCase("Meat")) {
            return price * 0.10; // 10% off
        }
        return 0;
    }

    @Override
    public String getDiscountName() {
        return "Meat Special (10% off)";
    }
}

class NoDiscountStrategy implements DiscountStrategy {
    @Override
    public double applyDiscount(double price, String category) {
        return 0;
    }

    @Override
    public String getDiscountName() {
        return "No Discount";
    }
}