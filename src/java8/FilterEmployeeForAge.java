package java8;

/**
 * @author footman77
 * @create 2018-10-26 15:00
 */
public class FilterEmployeeForAge implements MyPredicate<Employee> {
    @Override
    public boolean test(Employee employee) {
        return employee.getAge() <= 35;
    }
}
