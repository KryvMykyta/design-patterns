package hw17.task17_3_1;

public class ControlTower implements AirTrafficControl {
    private Runway runway;
    private PlanesInFlight planesInFlight;
    private PlanesOnGround planesOnGround;

    public ControlTower(Runway runway, PlanesInFlight planesInFlight, PlanesOnGround planesOnGround) {
        this.runway = runway;
        this.planesInFlight = planesInFlight;
        this.planesOnGround = planesOnGround;
    }

    @Override
    public void requestTakeOff(Plane plane) {
        if (!plane.getIsInTheAir() && runway.getIsAvailable()) {
            System.out.println("Plane " + plane.getId() + " is taking off...");
            planesOnGround.removePlane(plane);
            planesInFlight.addPlane(plane);
            plane.setIsInTheAir(true);
            runway.setIsAvailable(false);
        } else {
            System.out.println("Plane " + plane.getId() + " cannot take off: runway unavailable or plane already in air.");
        }
    }

    @Override
    public void requestLanding(Plane plane) {
        if (plane.getIsInTheAir() && runway.getIsAvailable()) {
            System.out.println("Plane " + plane.getId() + " is landing...");
            planesInFlight.removePlane(plane);
            planesOnGround.addPlane(plane);
            plane.setIsInTheAir(false);
            runway.setIsAvailable(false);
        } else {
            System.out.println("Plane " + plane.getId() + " cannot land: runway unavailable or plane not in air.");
        }
    }

    @Override
    public void notifyRunwayStatus(boolean isAvailable) {
        runway.setIsAvailable(isAvailable);
        System.out.println("Runway status updated: " + (isAvailable ? "available" : "unavailable"));
    }
}
