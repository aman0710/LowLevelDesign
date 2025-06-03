package ProxyDesignPattern;

public class EmployeeDaoImpl implements EmployeeDao{

    @Override
    public void create(String client, EmployeeDo employeeObject) throws Exception {
        System.out.println("Employee created in DB");
    }

    @Override
    public void delete(String client, int employeeId) throws Exception {
        System.out.println("Employee deleted from DB with Employee ID : " + employeeId);
    }

    @Override
    public EmployeeDo get(String client, int employeeId) throws Exception {
        System.out.println("Fetched employee from DB for Employee ID : " + employeeId);
        return new EmployeeDo();
    }
}
