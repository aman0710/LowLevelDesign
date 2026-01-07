package LLDofProxyDesignPattern;

public class Main {
    public static void main(String[] args) {
        EmployeeDao employee = new EmployeeProxy("USER");
        employee.getEmployeeInfo();
        employee.createEmployee();
    }
}
