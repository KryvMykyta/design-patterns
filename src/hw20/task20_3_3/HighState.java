package hw20.task20_3_3;

public class HighState implements FanState {
    @Override
    public void turnUp(Fan fan) {
        // No action, already at highest state
    }

    @Override
    public void turnDown(Fan fan) {
        fan.setState(new MediumState());
        System.out.println("Fan is on medium");
    }
}
