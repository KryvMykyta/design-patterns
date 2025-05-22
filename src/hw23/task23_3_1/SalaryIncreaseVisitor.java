package hw23.task23_3_1;

public class SalaryIncreaseVisitor implements EmployeeVisitor {
    private double percentage;

    public SalaryIncreaseVisitor(double percentage) {
        this.percentage = percentage;
    }

    @Override
    public void visit(SalesPerson salesPerson) {
        int newSalary = (int)(salesPerson.getSalary() * (1 + percentage/100));
        salesPerson.setSalary(newSalary);
    }

    @Override
    public void visit(Manager manager) {
        int newSalary = (int)(manager.getSalary() * (1 + percentage/100));
        manager.setSalary(newSalary);
    }

    @Override
    public void visit(ITSupport itSupport) {
        int newSalary = (int)(itSupport.getSalary() * (1 + percentage/100));
        itSupport.setSalary(newSalary);
    }
}