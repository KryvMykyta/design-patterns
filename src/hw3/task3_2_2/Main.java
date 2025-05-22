package hw3.task3_2_2;

import java.text.DecimalFormat;

interface Transport {
    double getPurchaseCost();
    double getOperationalCostPerKm();
}

class VolvoBus implements Transport {
    public double getPurchaseCost() { return 6_000_000; }
    public double getOperationalCostPerKm() { return 20; }
}

class SkodaBus implements Transport {
    public double getPurchaseCost() { return 4_500_000; }
    public double getOperationalCostPerKm() { return 25; }
}

class HyundaiBus implements Transport {
    public double getPurchaseCost() { return 5_500_000; }
    public double getOperationalCostPerKm() { return 20; }
}

class VolvoTram implements Transport {
    public double getPurchaseCost() { return 10_000_000; }
    public double getOperationalCostPerKm() { return 7; }
}

class SkodaTram implements Transport {
    public double getPurchaseCost() { return 9_000_000; }
    public double getOperationalCostPerKm() { return 8; }
}

class HyundaiTram implements Transport {
    public double getPurchaseCost() { return 9_500_000; }
    public double getOperationalCostPerKm() { return 6; }
}

class VolvoTrolley implements Transport {
    public double getPurchaseCost() { return 7_000_000; }
    public double getOperationalCostPerKm() { return 13; }
}

class SkodaTrolley implements Transport {
    public double getPurchaseCost() { return 6_800_000; }
    public double getOperationalCostPerKm() { return 12; }
}

class HyundaiTrolley implements Transport {
    public double getPurchaseCost() { return 7_000_000; }
    public double getOperationalCostPerKm() { return 11; }
}

interface TransportFactory {
    Transport createBus();
    Transport createTram();
    Transport createTrolley();
}

class VolvoFactory implements TransportFactory {
    public Transport createBus() { return new VolvoBus(); }
    public Transport createTram() { return new VolvoTram(); }
    public Transport createTrolley() { return new VolvoTrolley(); }
}

class SkodaFactory implements TransportFactory {
    public Transport createBus() { return new SkodaBus(); }
    public Transport createTram() { return new SkodaTram(); }
    public Transport createTrolley() { return new SkodaTrolley(); }
}

class HyundaiFactory implements TransportFactory {
    public Transport createBus() { return new HyundaiBus(); }
    public Transport createTram() { return new HyundaiTram(); }
    public Transport createTrolley() { return new HyundaiTrolley(); }
}

class TransportCostCalculator {
    static class CostResult {
        String manufacturer;
        double totalCost;

        CostResult(String manufacturer, double totalCost) {
            this.manufacturer = manufacturer;
            this.totalCost = totalCost;
        }
    }

    public static double calculateTotalCost(TransportFactory factory, int A, int T, int Tr, double N) {
        Transport bus = factory.createBus();
        Transport tram = factory.createTram();
        Transport trolley = factory.createTrolley();

        double purchaseCost = A * bus.getPurchaseCost() + T * tram.getPurchaseCost() + Tr * trolley.getPurchaseCost();

        double operationalCost = N * 1000 * (A * bus.getOperationalCostPerKm() + T * tram.getOperationalCostPerKm() + Tr * trolley.getOperationalCostPerKm());

        return purchaseCost + operationalCost;
    }

    public static void main(String[] args) {
        int A = 10;
        int T = 5;
        int Tr = 8;
        double N = 100;

        TransportFactory[] factories = { new VolvoFactory(), new SkodaFactory(), new HyundaiFactory() };
        String[] manufacturers = { "Volvo", "Skoda", "Hyundai" };
        CostResult[] results = new CostResult[factories.length];

        for (int i = 0; i < factories.length; i++) {
            double totalCost = calculateTotalCost(factories[i], A, T, Tr, N);
            results[i] = new CostResult(manufacturers[i], totalCost);
        }

        CostResult minCost = results[0];
        for (CostResult result : results) {
            if (result.totalCost < minCost.totalCost) {
                minCost = result;
            }
        }

        DecimalFormat df = new DecimalFormat("#,##0.00");
        System.out.println("Cost Analysis for Municipal Transport Fleet");
        System.out.println("Buses: " + A + ", Trams: " + T + ", Trolleys: " + Tr + ", Distance: " + N + " thousand km");
        System.out.println("----------------------------------------");
        for (CostResult result : results) {
            System.out.println(result.manufacturer + " Total Cost: " + df.format(result.totalCost) + " UAH");
        }
        System.out.println("----------------------------------------");
        System.out.println("Recommended Manufacturer: " + minCost.manufacturer);
        System.out.println("Total Cost: " + df.format(minCost.totalCost) + " UAH");
    }
}
