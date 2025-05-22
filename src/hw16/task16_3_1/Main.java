package hw16.task16_3_1;

public class Main {

    public static void main(String[] args) {

        Employee zak = new Employee("Zak");
        Employee sarah = new Employee("Sarah");
        Employee anna = new Employee("Anna");

        StaffList staffList = new StaffList();
        staffList.addEmployee(zak);
        staffList.addEmployee(sarah);
        staffList.addEmployee(anna);

        for (Employee employee : staffList){
          System.out.println(employee);
        }

    }

}