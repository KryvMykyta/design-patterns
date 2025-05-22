package hw4.task4_3_1;
interface CarBuilder {
    void reset();
    void setBodyType(String bodyType);
    void setEngine(Engine engine);
    void setTransmission(Transmission transmission);
    void setWheels(Wheels wheels);
    void setColor(String color);
    Car getResult();
}

class Engine {
    int power;
    double displacement;
    int torque;
    String fuelType;

    public Engine(int power, double displacement, int torque, String fuelType) {
        this.power = power;
        this.displacement = displacement;
        this.torque = torque;
        this.fuelType = fuelType;
    }
}

interface EngineBuilder {
    void reset();
    void setPower(int power);
    void setDisplacement(double displacement);
    void setTorque(int torque);
    void setFuelType(String fuelType);
    Engine getResult();
}

class EngineBuilderImpl implements EngineBuilder {
    private Engine engine;

    public void reset() {
        engine = new Engine(0, 0.0, 0, "");
    }

    public void setPower(int power) {
        engine = new Engine(power, engine.displacement, engine.torque, engine.fuelType);
    }

    public void setDisplacement(double displacement) {
        engine = new Engine(engine.power, displacement, engine.torque, engine.fuelType);
    }

    public void setTorque(int torque) {
        engine = new Engine(engine.power, engine.displacement, torque, engine.fuelType);
    }

    public void setFuelType(String fuelType) {
        engine = new Engine(engine.power, engine.displacement, engine.torque, fuelType);
    }

    public Engine getResult() {
        return engine;
    }
}

class Transmission {
    String type;
    int gears;

    public Transmission(String type, int gears) {
        this.type = type;
        this.gears = gears;
    }
}

interface TransmissionBuilder {
    void reset();
    void setType(String type);
    void setGears(int gears);
    Transmission getResult();
}

class TransmissionBuilderImpl implements TransmissionBuilder {
    private Transmission transmission;

    public void reset() {
        transmission = new Transmission("", 0);
    }

    public void setType(String type) {
        transmission = new Transmission(type, transmission.gears);
    }

    public void setGears(int gears) {
        transmission = new Transmission(transmission.type, gears);
    }

    public Transmission getResult() {
        return transmission;
    }
}

class Wheels {
    String material;
    int diameter;

    public Wheels(String material, int diameter) {
        this.material = material;
        this.diameter = diameter;
    }
}

interface WheelsBuilder {
    void reset();
    void setMaterial(String material);
    void setDiameter(int diameter);
    Wheels getResult();
}

class WheelsBuilderImpl implements WheelsBuilder {
    private Wheels wheels;

    public void reset() {
        wheels = new Wheels("", 0);
    }

    public void setMaterial(String material) {
        wheels = new Wheels(material, wheels.diameter);
    }

    public void setDiameter(int diameter) {
        wheels = new Wheels(wheels.material, diameter);
    }

    public Wheels getResult() {
        return wheels;
    }
}

class Car {
    private String bodyType;
    private Engine engine;
    private Transmission transmission;
    private Wheels wheels;
    private String color;

    @Override
    public String toString() {
        return "Car{" +
                "bodyType='" + bodyType + '\'' +
                ", engine=" + engine +
                ", transmission=" + transmission +
                ", wheels=" + wheels +
                ", color='" + color + '\'' +
                '}';
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    public void setWheels(Wheels wheels) {
        this.wheels = wheels;
    }

    public void setColor(String color) {
        this.color = color;
    }
}

class CarBuilderImpl implements CarBuilder {
    private Car car;

    public CarBuilderImpl() {
        reset();
    }

    public void reset() {
        car = new Car();
    }

    public void setBodyType(String bodyType) {
        car.setBodyType(bodyType);
    }

    public void setEngine(Engine engine) {
        car.setEngine(engine);
    }

    public void setTransmission(Transmission transmission) {
        car.setTransmission(transmission);
    }

    public void setWheels(Wheels wheels) {
        car.setWheels(wheels);
    }

    public void setColor(String color) {
        car.setColor(color);
    }

    public Car getResult() {
        return car;
    }
}

class Director {
    private CarBuilder carBuilder;
    private EngineBuilder engineBuilder;
    private TransmissionBuilder transmissionBuilder;
    private WheelsBuilder wheelsBuilder;

    public Director(CarBuilder carBuilder, EngineBuilder engineBuilder,
                    TransmissionBuilder transmissionBuilder, WheelsBuilder wheelsBuilder) {
        this.carBuilder = carBuilder;
        this.engineBuilder = engineBuilder;
        this.transmissionBuilder = transmissionBuilder;
        this.wheelsBuilder = wheelsBuilder;
    }

    public Car buildSportsCar() {
        carBuilder.reset();
        engineBuilder.reset();
        transmissionBuilder.reset();
        wheelsBuilder.reset();

        carBuilder.setBodyType("Coupe");
        engineBuilder.setPower(400);
        engineBuilder.setDisplacement(3.0);
        engineBuilder.setTorque(450);
        engineBuilder.setFuelType("Petrol");
        carBuilder.setEngine(engineBuilder.getResult());
        transmissionBuilder.setType("Automatic");
        transmissionBuilder.setGears(8);
        carBuilder.setTransmission(transmissionBuilder.getResult());
        wheelsBuilder.setMaterial("Alloy");
        wheelsBuilder.setDiameter(19);
        carBuilder.setWheels(wheelsBuilder.getResult());
        carBuilder.setColor("Red");

        return carBuilder.getResult();
    }

    public Car buildSUV() {
        carBuilder.reset();
        engineBuilder.reset();
        transmissionBuilder.reset();
        wheelsBuilder.reset();

        carBuilder.setBodyType("SUV");
        engineBuilder.setPower(250);
        engineBuilder.setDisplacement(2.5);
        engineBuilder.setTorque(350);
        engineBuilder.setFuelType("Diesel");
        carBuilder.setEngine(engineBuilder.getResult());
        transmissionBuilder.setType("Automatic");
        transmissionBuilder.setGears(7);
        carBuilder.setTransmission(transmissionBuilder.getResult());
        wheelsBuilder.setMaterial("Alloy");
        wheelsBuilder.setDiameter(18);
        carBuilder.setWheels(wheelsBuilder.getResult());
        carBuilder.setColor("Black");

        return carBuilder.getResult();
    }

    public Car buildEconomyCar() {
        carBuilder.reset();
        engineBuilder.reset();
        transmissionBuilder.reset();
        wheelsBuilder.reset();

        carBuilder.setBodyType("Hatchback");
        engineBuilder.setPower(100);
        engineBuilder.setDisplacement(1.6);
        engineBuilder.setTorque(150);
        engineBuilder.setFuelType("Petrol");
        carBuilder.setEngine(engineBuilder.getResult());
        transmissionBuilder.setType("Manual");
        transmissionBuilder.setGears(5);
        carBuilder.setTransmission(transmissionBuilder.getResult());
        wheelsBuilder.setMaterial("Steel");
        wheelsBuilder.setDiameter(15);
        carBuilder.setWheels(wheelsBuilder.getResult());
        carBuilder.setColor("Silver");

        return carBuilder.getResult();
    }
}

class Main {
    public static void main(String[] args) {
        CarBuilder carBuilder = new CarBuilderImpl();
        EngineBuilder engineBuilder = new EngineBuilderImpl();
        TransmissionBuilder transmissionBuilder = new TransmissionBuilderImpl();
        WheelsBuilder wheelsBuilder = new WheelsBuilderImpl();

        Director director = new Director(carBuilder, engineBuilder, transmissionBuilder, wheelsBuilder);

        Car sportsCar = director.buildSportsCar();
        Car suv = director.buildSUV();
        Car economyCar = director.buildEconomyCar();

        System.out.println(sportsCar);
        System.out.println(suv);
        System.out.println(economyCar);

    }
}