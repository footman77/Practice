package java8;

/**
 * @author footman77
 * @create 2018-10-26 15:01
 */
public class FilterEmployeeForSalary implements MyPredicate<Employee> {

    @Override
    public boolean test(Employee employee) {
        return employee.getSalary() >= 5000;
    }
}
