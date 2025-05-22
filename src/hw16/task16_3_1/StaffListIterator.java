package hw16.task16_3_1;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

public class StaffListIterator implements Iterator<Employee> {

    private final List<Employee> sortedEmployees;
    private int currentIndex = 0;

    public StaffListIterator(List<Employee> employees) {
        this.sortedEmployees = new ArrayList<>(employees);
        this.sortedEmployees.sort(Comparator.comparing(Employee::getName));
    }

    @Override
    public boolean hasNext() {
        return currentIndex < sortedEmployees.size();
    }

    @Override
    public Employee next() {
        if (!hasNext()) {
            throw new IllegalStateException("No more elements to iterate");
        }
        return sortedEmployees.get(currentIndex++);
    }
}