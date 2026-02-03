package FacadeDesignPattern.Scenario1;

public class EmployeeDao {
    public boolean insert() {
        // functionality
        return true;
    }

    public boolean updateEmployeeByEmpId(int empId) {
        // functionality
        return true;
    }

    public Employee getEmployeeByEmpId(int empId) {
        return new Employee();
    }

    public Employee getEmployeeByEmailId(String emailId) {
        return new Employee();
    }
}
