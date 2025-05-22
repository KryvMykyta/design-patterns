package hw2.task2_3_1;

import java.util.ArrayList;
import java.util.List;

abstract class Beverage {
    protected String name;
    protected double costPrice;
    protected double salePrice;

    public Beverage(String name, double costPrice, double salePrice) {
        this.name = name;
        this.costPrice = costPrice;
        this.salePrice = salePrice;
    }

    public String getName() {
        return name;
    }

    public double getCostPrice() {
        return costPrice;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public double getProfit() {
        return salePrice - costPrice;
    }

    public void prepare() {
        System.out.println("Preparing " + name + ": grinding coffee, brewing, and pouring into a cup.");
    }
}

class Espresso extends Beverage {
    public Espresso() {
        super("Espresso", 1.0, 2.5);
    }
}

class Americano extends Beverage {
    public Americano() {
        super("Americano", 1.2, 3.0);
    }
}

class Cappuccino extends Beverage {
    public Cappuccino() {
        super("Cappuccino", 1.5, 3.5);
    }
}

class Latte extends Beverage {
    public Latte() {
        super("Latte", 1.7, 4.0);
    }
}

class Raf extends Beverage {
    public Raf() {
        super("Raf", 1.8, 4.2);
    }
}

class Mocha extends Beverage {
    public Mocha() {
        super("Mocha", 2.0, 4.5);
    }
}

enum BeverageType {
    ESPRESSO, AMERICANO, CAPPUCCINO, LATTE, RAF, MOCHA
}

abstract class BeverageFactory {
    public abstract Beverage createBeverage(BeverageType type);

    public Beverage orderBeverage(BeverageType type) {
        Beverage beverage = createBeverage(type);
        beverage.prepare();
        System.out.println("Here's your " + beverage.getName() + "! Price: $" + beverage.getSalePrice());
        return beverage;
    }
}

class CoffeeShopBeverageFactory extends BeverageFactory {
    @Override
    public Beverage createBeverage(BeverageType type) {
        switch (type) {
            case ESPRESSO:
                return new Espresso();
            case AMERICANO:
                return new Americano();
            case CAPPUCCINO:
                return new Cappuccino();
            case LATTE:
                return new Latte();
            case RAF:
                return new Raf();
            case MOCHA:
                return new Mocha();
        }
        return null;
    }
}

class CoffeeShop {
    private final BeverageFactory beverageFactory;
    private final List<Beverage> orders;

    public CoffeeShop(BeverageFactory beverageFactory) {
        this.beverageFactory = beverageFactory;
        this.orders = new ArrayList<>();
    }

    public void placeOrder(BeverageType type) {
        Beverage beverage = beverageFactory.orderBeverage(type);
        orders.add(beverage);
    }

    public double calculateTotalProfit() {
        double totalProfit = 0.0;
        for (Beverage beverage : orders) {
            totalProfit += beverage.getProfit();
        }
        return totalProfit;
    }

    public void printOrderSummary() {
        System.out.println("\nOrder Summary:");
        for (Beverage beverage : orders) {
            System.out.printf("%s: Cost Price: $%.2f, Sale Price: $%.2f, Profit: $%.2f%n",
                    beverage.getName(), beverage.getCostPrice(), beverage.getSalePrice(), beverage.getProfit());
        }
        System.out.printf("Total Profit: $%.2f%n", calculateTotalProfit());
    }
}

class MechMatMallCoffeeShop {
    public static void main(String[] args) {
        BeverageFactory factory = new CoffeeShopBeverageFactory();
        CoffeeShop coffeeShop = new CoffeeShop(factory);

        coffeeShop.placeOrder(BeverageType.ESPRESSO);
        coffeeShop.placeOrder(BeverageType.AMERICANO);
        coffeeShop.placeOrder(BeverageType.CAPPUCCINO);
        coffeeShop.placeOrder(BeverageType.LATTE);
        coffeeShop.placeOrder(BeverageType.RAF);
        coffeeShop.placeOrder(BeverageType.MOCHA);

        coffeeShop.printOrderSummary();
    }
}