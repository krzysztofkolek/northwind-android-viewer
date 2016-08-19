package kolek.krzysztof.pum.Tools;

import java.util.Comparator;

import kolek.krzysztof.pum.models.Employee;


public class EmployeeComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getFirstName().compareTo(o2.getFirstName());
    }
}
