package hw8.task8_3_2;

public class UserSize implements Size {
    private int customSize;

    public UserSize(int customSize) {
        this.customSize = customSize;
    }

    @Override
    public void applySize() {
        System.out.println("Setting custom size to " + customSize + " units...");
    }
}