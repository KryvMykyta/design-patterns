package hw15.task15_3_3;

public class PrevChannelCommand implements Command {
    private Device device;

    public PrevChannelCommand(Device device) {
        this.device = device;
    }

    public void execute() {
        device.prevChanel();
    }
}