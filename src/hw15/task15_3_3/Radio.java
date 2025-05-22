package hw15.task15_3_3;

public class Radio implements Device {
    private int volume;
    private int chanel;
    private boolean isOn;

    public Radio() {
        this.isOn = false;
        this.volume = 50;
        this.chanel = 1;
    }

    public void on() {
        if (isOn) {
            return;
        }
        System.out.println("Radio is on");
        isOn = true;
    }

    public void off() {
        if (!isOn) {
            return;
        }
        System.out.println("Radio is off");
        isOn = false;
    }

    public void volumeUp() {
        if (!isOn) {
            return;
        }
        volume++;
        System.out.println("Radio Volume = " + volume);
    }

    public void volumeDown() {
        if (!isOn) {
            return;
        }
        volume--;
        System.out.println("Radio Volume = " + volume);
    }

    public void nextChanel() {
        if (!isOn) {
            return;
        }
        chanel++;
        System.out.println("Radio Chanel = " + chanel);
    }

    public void prevChanel() {
        if (!isOn) {
            return;
        }
        chanel--;
        System.out.println("Radio Chanel = " + chanel);
    }
}