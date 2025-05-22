package hw17.task17_3_1;

public interface AirTrafficControl {
    void requestTakeOff(Plane plane);
    void requestLanding(Plane plane);
    void notifyRunwayStatus(boolean isAvailable);
}