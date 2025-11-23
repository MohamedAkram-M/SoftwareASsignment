import java.util.*;

// ==================== FACADE PATTERN ====================
// Provides a unified interface for the complex restaurant system
class RestaurantFacade {
    private Scanner scanner;
    private KitchenSystem kitchen;
    private WaiterSystem waiter;

    public RestaurantFacade() {
        this.scanner = new Scanner(System.in);
        this.kitchen = new KitchenSystem();
        this.waiter = new WaiterSystem();
    }

    public void startOrderingProcess() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("   WELCOME TO THE RESTAURANT ORDERING & BILLING SYSTEM");
        System.out.println("=".repeat(60));

        // Get customer information
        System.out.print("\nEnter customer name: ");
        String customerName = scanner.nextLine();

        // Choose order type
        System.out.println("\nSelect Order Type:");
        System.out.println("1. Dine-In");
        System.out.println("2. Delivery");
        System.out.println("3. Takeaway");
        System.out.print("Enter choice (1-3): ");
        int orderTypeChoice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        String orderType = "";
        OrderProcessor processor = null;

        switch (orderTypeChoice) {
            case 1:
                orderType = "Dine-In";
                processor = new DineInOrderProcessor(scanner);
                break;
            case 2:
                orderType = "Delivery";
                processor = new DeliveryOrderProcessor(scanner);
                break;
            case 3:
                orderType = "Takeaway";
                processor = new TakeawayOrderProcessor(scanner);
                break;
            default:
                orderType = "Dine-In";
                processor = new DineInOrderProcessor(scanner);
        }

        // Create order
        Order order = new Order(customerName, orderType);
        order.attach(kitchen);
        order.attach(waiter);

        // Select menu type (Abstract Factory)
        System.out.println("\nSelect Menu Type:");
        System.out.println("1. Vegetarian Menu");
        System.out.println("2. Non-Vegetarian Menu");
        System.out.println("3. Kids Menu");
        System.out.print("Enter choice (1-3): ");
        int menuChoice = scanner.nextInt();
        scanner.nextLine();

        MenuFactory menuFactory = null;
        switch (menuChoice) {
            case 1:
                menuFactory = new VegetarianMenuFactory();
                break;
            case 2:
                menuFactory = new NonVegetarianMenuFactory();
                break;
            case 3:
                menuFactory = new KidsMenuFactory();
                break;
            default:
                menuFactory = new VegetarianMenuFactory();
        }

        // Display menu options
        System.out.println("\n=== MENU OPTIONS ===");
        System.out.println("1. Main Dish");
        System.out.println("2. Side Dish");
        System.out.println("3. Drink");
        System.out.println("4. Custom Pizza (Factory Method)");
        System.out.println("5. Custom Burger (Factory Method)");

        // Add items to order
        boolean addingItems = true;
        while (addingItems) {
            System.out.print("\nSelect item to add (1-5, or 0 to finish): ");
            int itemChoice = scanner.nextInt();
            scanner.nextLine();

            if (itemChoice == 0) {
                addingItems = false;
                continue;
            }

            MenuItem item = null;

            switch (itemChoice) {
                case 1:
                    item = menuFactory.createMainDish();
                    break;
                case 2:
                    item = menuFactory.createSideDish();
                    break;
                case 3:
                    item = menuFactory.createDrink();
                    break;
                case 4:
                    System.out.println("Select Pizza variant:");
                    System.out.println("1. Italian");
                    System.out.println("2. Eastern");
                    System.out.println("3. Classic");
                    System.out.print("Enter choice: ");
                    int pizzaChoice = scanner.nextInt();
                    scanner.nextLine();

                    PizzaCreator pizzaCreator = new PizzaCreator();
                    String pizzaVariant = "";
                    switch (pizzaChoice) {
                        case 1: pizzaVariant = "italian"; break;
                        case 2: pizzaVariant = "eastern"; break;
                        case 3: pizzaVariant = "classic"; break;
                        default: pizzaVariant = "regular";
                    }
                    item = pizzaCreator.createMenuItem(pizzaVariant);
                    break;
                case 5:
                    System.out.println("Select Burger variant:");
                    System.out.println("1. Classic");
                    System.out.println("2. Deluxe");
                    System.out.println("3. Veggie");
                    System.out.print("Enter choice: ");
                    int burgerChoice = scanner.nextInt();
                    scanner.nextLine();

                    BurgerCreator burgerCreator = new BurgerCreator();
                    String burgerVariant = "";
                    switch (burgerChoice) {
                        case 1: burgerVariant = "classic"; break;
                        case 2: burgerVariant = "deluxe"; break;
                        case 3: burgerVariant = "veggie"; break;
                        default: burgerVariant = "regular";
                    }
                    item = burgerCreator.createMenuItem(burgerVariant);
                    break;
            }

            if (item != null) {
                // Ask for add-ons (Decorator Pattern)
                System.out.println("\nAdd customizations?");
                System.out.println("1. Extra Cheese (+$2.00)");
                System.out.println("2. Special Sauce (+$1.50)");
                System.out.println("3. Extra Toppings (+$3.00)");
                System.out.println("4. No customization");
                System.out.print("Enter choice (1-4): ");
                int addonChoice = scanner.nextInt();
                scanner.nextLine();

                switch (addonChoice) {
                    case 1:
                        item = new ExtraCheeseDecorator(item);
                        break;
                    case 2:
                        item = new SpecialSauceDecorator(item);
                        break;
                    case 3:
                        item = new ExtraToppingsDecorator(item);
                        break;
                }

                order.addItem(item);
                System.out.println("Added: " + item.getName() + " - $" +
                        String.format("%.2f", item.getPrice()));
            }
        }

        if (order.getItems().isEmpty()) {
            System.out.println("\nNo items added. Order cancelled.");
            return;
        }

        // Select discount strategy
        System.out.println("\nSelect Discount Option:");
        System.out.println("1. Pizza Discount (15% off pizza items)");
        System.out.println("2. Chicken Discount (20% off chicken items)");
        System.out.println("3. Meat Discount (10% off meat items)");
        System.out.println("4. No Discount");
        System.out.print("Enter choice (1-4): ");
        int discountChoice = scanner.nextInt();
        scanner.nextLine();

        DiscountStrategy discountStrategy = null;
        switch (discountChoice) {
            case 1:
                discountStrategy = new PizzaDiscountStrategy();
                break;
            case 2:
                discountStrategy = new ChickenDiscountStrategy();
                break;
            case 3:
                discountStrategy = new MeatDiscountStrategy();
                break;
            default:
                discountStrategy = new NoDiscountStrategy();
        }

        // Select payment method
        System.out.println("\nSelect Payment Method:");
        System.out.println("1. Cash");
        System.out.println("2. Credit Card");
        System.out.println("3. Mobile Wallet");
        System.out.print("Enter choice (1-3): ");
        int paymentChoice = scanner.nextInt();
        scanner.nextLine();

        PaymentStrategy paymentStrategy = null;
        switch (paymentChoice) {
            case 1:
                paymentStrategy = new CashPayment();
                break;
            case 2:
                System.out.print("Enter card number: ");
                String cardNumber = scanner.nextLine();
                paymentStrategy = new CreditCardPayment(cardNumber);
                break;
            case 3:
                System.out.print("Enter wallet ID: ");
                String walletId = scanner.nextLine();
                paymentStrategy = new MobileWalletPayment(walletId);
                break;
            default:
                paymentStrategy = new CashPayment();
        }

        // Process order using Template Method
        processor.processOrder(order, paymentStrategy, discountStrategy);

        System.out.println("\nThank you for your order!");
    }

    public void close() {
        scanner.close();
    }
}

// ==================== MAIN APPLICATION ====================
class RestaurantOrderingSystem {
    public static void main(String[] args) {
        // Demonstration of all design patterns
        System.out.println("=== RESTAURANT ORDERING & BILLING SYSTEM ===");
        System.out.println("This system demonstrates the following design patterns:");
        System.out.println("1. Singleton Pattern - (Can be added to RestaurantFacade)");
        System.out.println("2. Factory Method Pattern - Pizza/Burger creators");
        System.out.println("3. Abstract Factory Pattern - Menu factories");
        System.out.println("4. Decorator Pattern - Add-ons for menu items");
        System.out.println("5. Observer Pattern - Kitchen and Waiter notifications");
        System.out.println("6. Strategy Pattern - Payment and Discount strategies");
        System.out.println("7. Template Method Pattern - Order processing workflow");
        System.out.println("8. Facade Pattern - Unified restaurant interface");
        System.out.println("\nSOLID Principles Applied:");
        System.out.println("- Single Responsibility: Each class has one reason to change");
        System.out.println("- Open/Closed: Open for extension, closed for modification");
        System.out.println("- Liskov Substitution: Subtypes are substitutable");
        System.out.println("- Interface Segregation: Specific interfaces for clients");
        System.out.println("- Dependency Inversion: Depend on abstractions");

        // Start the ordering process
        RestaurantFacade restaurant = new RestaurantFacade();
        restaurant.startOrderingProcess();
        restaurant.close();
    }
}