package ProxyDesignPattern;

public interface EmployeeDao {
    public void create(String client, EmployeeDo employeeObject) throws Exception;

    public void delete(String client, int employeeId) throws Exception;

    public EmployeeDo get(String client, int employeeId) throws Exception;
}
