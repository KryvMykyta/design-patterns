package hw23.task23_3_1;

public interface EmployeeVisitor {
    void visit(SalesPerson salesPerson);
    void visit(Manager manager);
    void visit(ITSupport itSupport);
}