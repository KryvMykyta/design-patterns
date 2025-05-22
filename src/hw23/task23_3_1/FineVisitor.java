package hw23.task23_3_1;

public class FineVisitor implements EmployeeVisitor {
    private int fineAmount;

    public FineVisitor(int fineAmount) {
        this.fineAmount = fineAmount;
    }

    @Override
    public void visit(SalesPerson salesPerson) {
        int newSalary = Math.max(0, salesPerson.getSalary() - fineAmount);
        salesPerson.setSalary(newSalary);
    }

    @Override
    public void visit(Manager manager) {
        int newSalary = Math.max(0, manager.getSalary() - fineAmount);
        manager.setSalary(newSalary);
    }

    @Override
    public void visit(ITSupport itSupport) {
        int newSalary = Math.max(0, itSupport.getSalary() - fineAmount);
        itSupport.setSalary(newSalary);
    }
}