package hw20.task20_3_3;

public class LowState implements FanState {
    @Override
    public void turnUp(Fan fan) {
        fan.setState(new MediumState());
        System.out.println("Fan is on medium");
    }

    @Override
    public void turnDown(Fan fan) {
        // No action, already at lowest state
    }
}