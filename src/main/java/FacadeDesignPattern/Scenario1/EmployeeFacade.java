package FacadeDesignPattern.Scenario1;

public class EmployeeFacade {
    EmployeeDao employeeDao;

    public EmployeeFacade() {
        this.employeeDao = new EmployeeDao();
    }

    public Employee getEmployeeByEmpId(int empId) {
        return employeeDao.getEmployeeByEmpId(empId);
    }

    public boolean insert() {
        return employeeDao.insert();
    }
}
