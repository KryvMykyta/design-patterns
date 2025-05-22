package hw20.task20_3_3;

public class MediumState implements FanState {
    @Override
    public void turnUp(Fan fan) {
        fan.setState(new HighState());
        System.out.println("Fan is on high");
    }

    @Override
    public void turnDown(Fan fan) {
        fan.setState(new LowState());
        System.out.println("Fan is on low");
    }
}