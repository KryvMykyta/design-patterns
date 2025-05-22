package hw3.task3_3_1;

import java.text.DecimalFormat;

abstract class Beverage {
    protected String name;
    protected double costPrice;
    protected double salePrice;

    public Beverage(String name, double costPrice, double salePrice) {
        this.name = name;
        this.costPrice = costPrice;
        this.salePrice = salePrice;
    }

    public double getProfit() {
        return salePrice - costPrice;
    }
}

enum BeverageType {
    ESPRESSO, AMERICANO, CAPPUCCINO, LATTE, RAF, MOCHA
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

interface CoffeeMachineFactory {
    Beverage createBeverage(BeverageType type);
    double getMachineCost();
    double getDailyMaintenanceCost();
}

class DeLonghiFactory implements CoffeeMachineFactory {
    public Beverage createBeverage(BeverageType type) {
        switch (type) {
            case ESPRESSO: return new Espresso();
            case AMERICANO: return new Americano();
            case CAPPUCCINO: return new Cappuccino();
            case LATTE: return new Latte();
            case RAF: return new Raf();
            case MOCHA: return new Mocha();
        }
        return null;
    }

    public double getMachineCost() { return 5000.0; }
    public double getDailyMaintenanceCost() { return 10.0; }
}

class NespressoFactory implements CoffeeMachineFactory {
    public Beverage createBeverage(BeverageType type) {
        switch (type) {
            case ESPRESSO: return new Espresso();
            case AMERICANO: return new Americano();
            case CAPPUCCINO: return new Cappuccino();
            case LATTE: return new Latte();
            case RAF: return new Raf();
            case MOCHA: return new Mocha();
        }
        return null;
    }

    public double getMachineCost() { return 4000.0; }
    public double getDailyMaintenanceCost() { return 12.0; }
}

class PhilipsFactory implements CoffeeMachineFactory {
    public Beverage createBeverage(BeverageType type) {
        switch (type) {
            case ESPRESSO: return new Espresso();
            case AMERICANO: return new Americano();
            case CAPPUCCINO: return new Cappuccino();
            case LATTE: return new Latte();
            case RAF: return new Raf();
            case MOCHA: return new Mocha();
        }
        return null;
    }

    public double getMachineCost() { return 4500.0; }
    public double getDailyMaintenanceCost() { return 8.0; }
}

class CoffeeMachineProfitCalculator {
    static class ProfitResult {
        String manufacturer;
        double netProfit;

        ProfitResult(String manufacturer, double netProfit) {
            this.manufacturer = manufacturer;
            this.netProfit = netProfit;
        }
    }

    public static double calculateNetProfit(CoffeeMachineFactory factory, int N, int dailySalesPerBeverage) {
        BeverageType[] types = BeverageType.values();
        double totalBeverageProfit = 0.0;

        for (BeverageType type : types) {
            Beverage beverage = factory.createBeverage(type);
            totalBeverageProfit += beverage.getProfit() * dailySalesPerBeverage * N;
        }

        double totalCost = factory.getMachineCost() + factory.getDailyMaintenanceCost() * N;
        return totalBeverageProfit - totalCost;
    }

    public static void main(String[] args) {
        int N = 30;
        int dailySalesPerBeverage = 10;

        CoffeeMachineFactory[] factories = { new DeLonghiFactory(), new NespressoFactory(), new PhilipsFactory() };
        String[] manufacturers = { "DeLonghi", "Nespresso", "Philips" };
        ProfitResult[] results = new ProfitResult[factories.length];

        for (int i = 0; i < factories.length; i++) {
            double netProfit = calculateNetProfit(factories[i], N, dailySalesPerBeverage);
            results[i] = new ProfitResult(manufacturers[i], netProfit);
        }

        ProfitResult maxProfit = results[0];
        for (ProfitResult result : results) {
            if (result.netProfit > maxProfit.netProfit) {
                maxProfit = result;
            }
        }

        DecimalFormat df = new DecimalFormat("#,##0.00");
        System.out.println("Profit Analysis for Coffee Shop");
        System.out.println("Days: " + N + ", Daily Sales per Beverage: " + dailySalesPerBeverage);
        System.out.println("----------------------------------------");
        for (ProfitResult result : results) {
            System.out.println(result.manufacturer + " Net Profit: $" + df.format(result.netProfit));
        }
        System.out.println("----------------------------------------");
        System.out.println("Recommended Manufacturer: " + maxProfit.manufacturer);
        System.out.println("Net Profit: $" + df.format(maxProfit.netProfit));
    }
}