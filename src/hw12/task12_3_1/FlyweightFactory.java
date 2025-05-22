package hw12.task12_3_1;
public class FlyweightFactory {
    private static final java.util.HashMap<String, Engine> engineCache = new java.util.HashMap<>();
    private static final java.util.HashMap<String, Wheel> wheelCache = new java.util.HashMap<>();

    public static Engine getEngine(int power, Engine.Fuel fuel) {
        String key = power + "_" + fuel;
        return engineCache.computeIfAbsent(key, k -> new Engine(power, fuel));
    }

    public static Wheel getWheel(int diameter) {
        String key = String.valueOf(diameter);
        return wheelCache.computeIfAbsent(key, k -> new Wheel(diameter));
    }
}