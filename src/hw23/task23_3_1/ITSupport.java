package hw23.task23_3_1;

public class ITSupport implements Employee {
    private int salary;

    public ITSupport(int salary) {
        this.salary = salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public int getSalary() {
        return salary;
    }

    @Override
    public void accept(EmployeeVisitor visitor) {
        visitor.visit(this);
    }
}