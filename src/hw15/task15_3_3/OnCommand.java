package hw15.task15_3_3;

public class OnCommand implements Command {
    private Device device;

    public OnCommand(Device device) {
        this.device = device;
    }

    public void execute() {
        device.on();
    }
}