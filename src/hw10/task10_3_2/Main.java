package hw10.task10_3_2;

abstract class CondimentDecorator extends Beverage {
    protected Beverage beverage;

    public CondimentDecorator(Beverage beverage) {
        this.beverage = beverage;
    }

    public abstract String description();

    public abstract float cost();
}

class Milk extends CondimentDecorator {
    public Milk(Beverage beverage) {
        super(beverage);
    }

    public String description() {
        return beverage.description() + ", Milk";
    }

    public float cost() {
        return beverage.cost() + 0.10f;
    }
}

class Sugar extends CondimentDecorator {
    public Sugar(Beverage beverage) {
        super(beverage);
    }

    public String description() {
        return beverage.description() + ", Sugar";
    }

    public float cost() {
        return beverage.cost() + 0.05f;
    }
}

class Cream extends CondimentDecorator {
    public Cream(Beverage beverage) {
        super(beverage);
    }

    public String description() {
        return beverage.description() + ", Cream";
    }

    public float cost() {
        return beverage.cost() + 0.15f;
    }
}

class WhippedCream extends CondimentDecorator {
    public WhippedCream(Beverage beverage) {
        super(beverage);
    }

    public String description() {
        return beverage.description() + ", Whipped Cream";
    }

    public float cost() {
        return beverage.cost() + 0.20f;
    }
}

public class Main {
    public static void main(String[] args) {
        Beverage espressoWithDoubleSugar = new Sugar(new Sugar(new Espresso()));
        System.out.println(espressoWithDoubleSugar);

        Beverage darkRoastWithWhippedCreamDoubleSugar = new WhippedCream(new Sugar(new Sugar(new DarkRoast())));
        System.out.println(darkRoastWithWhippedCreamDoubleSugar);

        Beverage darkRoastWithCreamSugar = new Cream(new Sugar(new DarkRoast()));
        System.out.println(darkRoastWithCreamSugar);

        Beverage decafWithMilkDoubleSugar = new Milk(new Sugar(new Sugar(new Decaf())));
        System.out.println(decafWithMilkDoubleSugar);
    }
}
