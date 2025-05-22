package hw23.task23_3_2;

public class Saboteur extends Spy {
    @Override
    public void visit(GeneralStaff generalStaff) {
        generalStaff.setSecretPaper(0);
        generalStaff.setGenerals(Math.max(0, generalStaff.getGenerals() - 2));
    }

    @Override
    public void visit(MilitaryBase militaryBase) {
        militaryBase.setOfficers(Math.max(0, militaryBase.getOfficers() - 5));
        militaryBase.setSoldiers(Math.max(0, militaryBase.getSoldiers() - 50));
        militaryBase.setJeeps(Math.max(0, militaryBase.getJeeps() - 10));
        militaryBase.setTanks(Math.max(0, militaryBase.getTanks() - 2));
    }
}