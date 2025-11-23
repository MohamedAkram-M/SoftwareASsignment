# Restaurant Ordering & Billing System

A comprehensive Java application demonstrating 8 design patterns and SOLID principles through a restaurant ordering system.

## 📋 Table of Contents
- [Design Patterns Implemented](#design-patterns-implemented)
- [SOLID Principles](#solid-principles)
- [Project Structure](#project-structure)
- [Prerequisites](#prerequisites)
- [Installation & Setup](#installation--setup)
- [Running the Project](#running-the-project)
- [Test Cases & Scenarios](#test-cases--scenarios)
- [Features](#features)

## 🎯 Design Patterns Implemented

1. **Singleton Pattern** - Can be added to RestaurantFacade for single instance
2. **Factory Method Pattern** - PizzaCreator and BurgerCreator for creating variants
3. **Abstract Factory Pattern** - Menu factories (Vegetarian, Non-Vegetarian, Kids)
4. **Decorator Pattern** - Add-ons for menu items (Extra Cheese, Sauce, Toppings)
5. **Observer Pattern** - Kitchen and Waiter notification systems
6. **Strategy Pattern** - Payment methods and Discount strategies
7. **Template Method Pattern** - Order processing workflow
8. **Facade Pattern** - Unified restaurant interface

## 🏗️ SOLID Principles

- **Single Responsibility** - Each class has one reason to change
- **Open/Closed** - Open for extension, closed for modification
- **Liskov Substitution** - Subtypes are substitutable for base types
- **Interface Segregation** - Specific interfaces for different clients
- **Dependency Inversion** - Depend on abstractions, not concrete implementations

## 📁 Project Structure

```
RestaurantOrderingSystem/
│
├── ResturantOrderingSystem.java  # Menu items, decorators, factories, strategies
├── Order.java                     # Order management and Observer pattern
├── OrderProcessor.java            # Template Method pattern implementations
├── Main.java                      # Facade and main application entry point
└── README.md                      # This file
```

## ✅ Prerequisites

- **Java Development Kit (JDK)** 8 or higher
- **Command Line Terminal** or **IDE** (IntelliJ IDEA, Eclipse, VS Code)

## 🚀 Installation & Setup

### Option 1: Using Command Line

1. **Create a project directory:**
```bash
mkdir RestaurantOrderingSystem
cd RestaurantOrderingSystem
```

2. **Save all four Java files in this directory:**
    - ResturantOrderingSystem.java
    - Order.java
    - OrderProcessor.java
    - Main.java

3. **Compile the project:**
```bash
javac *.java
```

4. **Run the application:**
```bash
java RestaurantOrderingSystem
```

### Option 2: Using IDE (IntelliJ IDEA / Eclipse)

1. Create a new Java project named "RestaurantOrderingSystem"
2. Add all four Java files to the src folder
3. Right-click on `Main.java` → Run 'RestaurantOrderingSystem.main()'

## 🎮 Running the Project

After starting the application, you'll be guided through the following steps:

1. **Enter Customer Name**
2. **Select Order Type** (Dine-In, Delivery, Takeaway)
3. **Select Menu Type** (Vegetarian, Non-Vegetarian, Kids)
4. **Add Menu Items** (Main Dish, Side Dish, Drink, Custom Pizza/Burger)
5. **Add Customizations** (Extra Cheese, Special Sauce, Extra Toppings)
6. **Select Discount** (Pizza, Chicken, Meat, or None)
7. **Choose Payment Method** (Cash, Credit Card, Mobile Wallet)
8. **View Receipt and Notifications**

## 🧪 Test Cases & Scenarios

### Test Case 1: Basic Vegetarian Order with Pizza Discount

**Input Sequence:**
```
Customer Name: Alice Johnson
Order Type: 1 (Dine-In)
Table Number: 5
Menu Type: 1 (Vegetarian)
Items:
  - 1 (Main Dish - Veggie Pizza $12.99)
  - 4 (No customization)
  - 2 (Side Dish - Garlic Bread $4.99)
  - 4 (No customization)
  - 0 (Finish adding items)
Discount: 1 (Pizza Discount 15%)
Payment: 1 (Cash)
```

**Expected Output:**
```
Subtotal: $17.98
Discount (Pizza Special 15% off): -$2.70
Total: $15.28
Payment: Cash $15.28
```

**Pattern Demonstration:**
- ✅ Abstract Factory (Vegetarian Menu)
- ✅ Strategy (Pizza Discount, Cash Payment)
- ✅ Template Method (Dine-In Processing)
- ✅ Observer (Kitchen & Waiter notifications)
- ✅ Facade (Unified ordering interface)

---

### Test Case 2: Non-Vegetarian Order with Decorators

**Input Sequence:**
```
Customer Name: Bob Smith
Order Type: 2 (Delivery)
Delivery Address: 123 Main Street, Apt 4B
Menu Type: 2 (Non-Vegetarian)
Items:
  - 1 (Main Dish - Grilled Chicken $15.99)
  - 1 (Extra Cheese +$2.00)
  - 2 (Side Dish - Beef Ribs $8.99)
  - 2 (Special Sauce +$1.50)
  - 0 (Finish adding items)
Discount: 2 (Chicken Discount 20%)
Payment: 2 (Credit Card)
Card Number: 1234567890123456
```

**Expected Output:**
```
Items:
  - Grilled Chicken, Extra Cheese: $17.99
  - Beef Ribs, Special Sauce: $10.49
Subtotal: $28.48
Discount (Chicken Special 20% off): -$3.60 (20% of $17.99)
Total: $24.88
Payment: Credit Card ending in 3456
```

**Pattern Demonstration:**
- ✅ Decorator (Extra Cheese, Special Sauce)
- ✅ Strategy (Chicken Discount, Credit Card Payment)
- ✅ Factory Method (N/A)
- ✅ Observer (Kitchen & Waiter notifications)

---

### Test Case 3: Kids Menu with Custom Burger

**Input Sequence:**
```
Customer Name: Emily Davis
Order Type: 3 (Takeaway)
Pickup Time: 6:30 PM
Menu Type: 3 (Kids Menu)
Items:
  - 1 (Main Dish - Kids Burger $6.99)
  - 4 (No customization)
  - 5 (Custom Burger)
    - 2 (Deluxe)
  - 3 (Extra Toppings +$3.00)
  - 3 (Drink - Apple Juice $2.49)
  - 4 (No customization)
  - 0 (Finish adding items)
Discount: 4 (No Discount)
Payment: 3 (Mobile Wallet)
Wallet ID: wallet@email.com
```

**Expected Output:**
```
Items:
  - Kids Burger: $6.99
  - Deluxe Burger, Extra Toppings: $15.99
  - Apple Juice: $2.49
Subtotal: $25.47
Discount (No Discount): -$0.00
Total: $25.47
Payment: Mobile Wallet: wallet@email.com
```

**Pattern Demonstration:**
- ✅ Factory Method (Custom Deluxe Burger)
- ✅ Decorator (Extra Toppings)
- ✅ Abstract Factory (Kids Menu)
- ✅ Strategy (No Discount, Mobile Wallet)
- ✅ Template Method (Takeaway Processing)

---

### Test Case 4: Complex Order with Multiple Decorators

**Input Sequence:**
```
Customer Name: Michael Chen
Order Type: 1 (Dine-In)
Table Number: 12
Menu Type: 2 (Non-Vegetarian)
Items:
  - 4 (Custom Pizza)
    - 1 (Italian)
  - 1 (Extra Cheese +$2.00)
  - 4 (Custom Pizza)
    - 2 (Eastern)
  - 3 (Extra Toppings +$3.00)
  - 1 (Main Dish - Grilled Chicken $15.99)
  - 2 (Special Sauce +$1.50)
  - 0 (Finish adding items)
Discount: 1 (Pizza Discount 15%)
Payment: 2 (Credit Card)
Card Number: 9876543210987654
```

**Expected Output:**
```
Items:
  - Italian Pizza, Extra Cheese: $16.99
  - Eastern Pizza, Extra Toppings: $16.99
  - Grilled Chicken, Special Sauce: $17.49
Subtotal: $51.47
Discount (Pizza Special 15% off): -$5.10 (15% of $16.99 + $16.99)
Total: $46.37
Payment: Credit Card ending in 7654
```

**Pattern Demonstration:**
- ✅ Factory Method (Italian & Eastern Pizza)
- ✅ Decorator (Multiple decorators on different items)
- ✅ Strategy (Pizza Discount on multiple pizzas)

---

### Test Case 5: Meat Discount Scenario

**Input Sequence:**
```
Customer Name: Sarah Wilson
Order Type: 2 (Delivery)
Delivery Address: 789 Oak Avenue
Menu Type: 2 (Non-Vegetarian)
Items:
  - 2 (Side Dish - Beef Ribs $8.99)
  - 4 (No customization)
  - 2 (Side Dish - Beef Ribs $8.99)
  - 4 (No customization)
  - 1 (Main Dish - Grilled Chicken $15.99)
  - 4 (No customization)
  - 0 (Finish adding items)
Discount: 3 (Meat Discount 10%)
Payment: 1 (Cash)
```

**Expected Output:**
```
Items:
  - Beef Ribs: $8.99
  - Beef Ribs: $8.99
  - Grilled Chicken: $15.99
Subtotal: $33.97
Discount (Meat Special 10% off): -$1.80 (10% of $8.99 + $8.99)
Total: $32.17
Payment: Cash $32.17
```

**Note:** Meat discount only applies to "Meat" category items (Beef Ribs), not Chicken items.

---

## 🎨 Discount Scenarios Explained

### 1. Pizza Discount (15% off)
- **Applies to:** Any item with category "Pizza"
- **Examples:** Veggie Pizza, Italian Pizza, Eastern Pizza, Classic Pizza, Mini Pizza
- **Calculation:** `discount = pizzaPrice × 0.15`

### 2. Chicken Discount (20% off)
- **Applies to:** Any item with category "Chicken"
- **Examples:** Grilled Chicken, Fresh Juice, Cola, Apple Juice
- **Calculation:** `discount = chickenPrice × 0.20`
- **Note:** Drinks in factories are incorrectly categorized as ChickenDish (design quirk)

### 3. Meat Discount (10% off)
- **Applies to:** Any item with category "Meat"
- **Examples:** Beef Ribs
- **Calculation:** `discount = meatPrice × 0.10`

### 4. No Discount
- **Applies to:** No discount applied
- **Total:** Full price of all items

### Important Notes:
- Discounts apply to the **base price** of items, not after decorators
- Multiple items of the same category stack the discount
- Decorators (Extra Cheese, Sauce, Toppings) are NOT discounted

---

## 💡 Features

### Order Types
1. **Dine-In** - Requires table number
2. **Delivery** - Requires address, includes delivery fee message
3. **Takeaway** - Requires pickup time

### Menu Categories (Abstract Factory)
1. **Vegetarian Menu**
    - Main: Veggie Pizza ($12.99)
    - Side: Garlic Bread ($4.99)
    - Drink: Fresh Juice ($3.99)

2. **Non-Vegetarian Menu**
    - Main: Grilled Chicken ($15.99)
    - Side: Beef Ribs ($8.99)
    - Drink: Cola ($2.99)

3. **Kids Menu**
    - Main: Kids Burger ($6.99)
    - Side: Mini Pizza ($5.99)
    - Drink: Apple Juice ($2.49)

### Custom Items (Factory Method)
1. **Pizza Variants**
    - Italian ($14.99)
    - Eastern ($13.99)
    - Classic ($11.99)
    - Regular ($10.99)

2. **Burger Variants**
    - Classic ($8.99)
    - Deluxe ($12.99)
    - Veggie ($9.99)
    - Regular ($7.99)

### Add-ons (Decorator Pattern)
- Extra Cheese: +$2.00
- Special Sauce: +$1.50
- Extra Toppings: +$3.00

### Payment Methods (Strategy Pattern)
- Cash
- Credit Card (requires card number)
- Mobile Wallet (requires wallet ID)

### Notifications (Observer Pattern)
- **Kitchen System** - Receives order details and items to prepare
- **Waiter System** - Receives order ID, customer name, and order type

---

## 🐛 Troubleshooting

### Compilation Errors
```bash
# If you get "class not found" errors, ensure all files are in the same directory
javac ResturantOrderingSystem.java Order.java OrderProcessor.java Main.java

# Then run
java RestaurantOrderingSystem
```

### Input Errors
- Always enter numeric choices when prompted for menu selections
- For card numbers and wallet IDs, you can enter any string value

---

## 📝 Sample Complete Run

```
=== RESTAURANT ORDERING & BILLING SYSTEM ===
[Design patterns description...]

============================================================
   WELCOME TO THE RESTAURANT ORDERING & BILLING SYSTEM
============================================================

Enter customer name: Test User

Select Order Type:
1. Dine-In
2. Delivery
3. Takeaway
Enter choice (1-3): 1

Select Menu Type:
1. Vegetarian Menu
2. Non-Vegetarian Menu
3. Kids Menu
Enter choice (1-3): 1

=== MENU OPTIONS ===
1. Main Dish
2. Side Dish
3. Drink
4. Custom Pizza (Factory Method)
5. Custom Burger (Factory Method)

Select item to add (1-5, or 0 to finish): 1

Add customizations?
1. Extra Cheese (+$2.00)
2. Special Sauce (+$1.50)
3. Extra Toppings (+$3.00)
4. No customization
Enter choice (1-4): 4
Added: Veggie Pizza - $12.99

Select item to add (1-5, or 0 to finish): 0

Select Discount Option:
1. Pizza Discount (15% off pizza items)
2. Chicken Discount (20% off chicken items)
3. Meat Discount (10% off meat items)
4. No Discount
Enter choice (1-4): 1

Select Payment Method:
1. Cash
2. Credit Card
3. Mobile Wallet
Enter choice (1-3): 1

============================================================
   PROCESSING ORDER
============================================================

[VERIFICATION] Verifying order items...
Order verified: 1 items found.

[DINE-IN] Processing dine-in order...
Enter table number: 5
Order will be served at Table 5

[PRICING] Calculating order total...
Order ID: ORD-1
Customer: Test User

Items:
------------------------------------------------------------
Delicious vegetarian pizza                $12.99
------------------------------------------------------------
Subtotal: $12.99
Discount (Pizza Special (15% off)): -$1.95
Total: $11.04

[PAYMENT] Processing payment...
Paid $11.04 in Cash
Payment completed successfully!

[KITCHEN] New order received!
Order ID: ORD-1
Items to prepare:
  - Veggie Pizza

[WAITER] New order notification!
Order ID: ORD-1
Table/Customer: Test User
Order Type: Dine-In

[FINALIZATION] Order finalized!
Order ID: ORD-1

Thank you for your order!
```

---

## 🎓 Learning Outcomes

This project demonstrates:
- Practical application of Gang of Four design patterns
- SOLID principles in action
- Clean code architecture
- Separation of concerns
- Extensibility and maintainability

## 📧 Contact & Support

For questions or issues, please review the code comments or consult Java design pattern documentation.

---

**Happy Coding! 🍕🍔🍗**
