package hw1.task1_3_1;

class CarSimulator {
    private CarBuilder carBuilder;

    public CarSimulator() {
        this.carBuilder = new CarBuilder();
    }
}

class CarBuilder {
    private Car car;

    public CarBuilder() {
        this.car = new Car();
    }
}

class Car {
    private Engine engine;
    private Wheel wheel;

    public Car() {
        this.engine = new Engine();
        this.wheel = new Wheel();
    }
}

class Engine {
    public Engine() {}
}

class Wheel {
    public Wheel() {}
}