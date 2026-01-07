package LLDofProxyDesignPattern;

public class EmployeeDaoImpl implements EmployeeDao{

    @Override
    public void getEmployeeInfo() {
        System.out.println("The employee details are: {Name}, {Age}, {Department}");
    }

    @Override
    public void createEmployee() {
        System.out.println("Employee created successfully!");
    }
}
