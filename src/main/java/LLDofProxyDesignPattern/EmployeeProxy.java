package LLDofProxyDesignPattern;

import java.util.Objects;

public class EmployeeProxy implements EmployeeDao{

    String clientRole;
    EmployeeDao employeeDao;

    public EmployeeProxy(String clientRole) {
        this.employeeDao = new EmployeeDaoImpl();
        this.clientRole = clientRole;
    }

    @Override
    public void getEmployeeInfo() {
        if(this.clientRole.equalsIgnoreCase("USER") || this.clientRole.equalsIgnoreCase("ADMIN")) {
            employeeDao.getEmployeeInfo();
        } else {
            throw new RuntimeException("Access Denied");
        }
    }

    @Override
    public void createEmployee() {
        if(this.clientRole.equalsIgnoreCase("ADMIN")) {
            employeeDao.createEmployee();
        } else {
            throw new RuntimeException("Access Denied");
        }
    }
}
