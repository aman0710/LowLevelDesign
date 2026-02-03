package FacadeDesignPattern.Scenario1;

public class Employer {
    public static void main(String[] args) {
        EmployeeFacade employeeFacade = new EmployeeFacade();
        Employee employee = employeeFacade.getEmployeeByEmpId(1221);
    }
}
