package hw15.task15_3_3;

public class VolumeDownCommand implements Command {
    private Device device;

    public VolumeDownCommand(Device device) {
        this.device = device;
    }

    public void execute() {
        device.volumeDown();
    }
}