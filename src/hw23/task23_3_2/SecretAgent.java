package hw23.task23_3_2;

public class SecretAgent extends Spy {
    private int stolenPapers;

    public SecretAgent() {
        this.stolenPapers = 0;
    }

    @Override
    public void visit(GeneralStaff generalStaff) {
        stolenPapers += Math.min(10, generalStaff.getSecretPaper());
        generalStaff.setSecretPaper(Math.max(0, generalStaff.getSecretPaper() - 10));
    }

    @Override
    public void visit(MilitaryBase militaryBase) {
    }

    public int getStolenPapers() {
        return stolenPapers;
    }
}