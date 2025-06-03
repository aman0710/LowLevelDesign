package ProxyDesignPattern;

public class EmployeeDaoProxy implements EmployeeDao{

    EmployeeDao employeeDao;
    EmployeeDaoProxy() {
        this.employeeDao = new EmployeeDaoImpl();
    }

    @Override
    public void create(String client, EmployeeDo employeeObject) throws Exception {
        if(client.equalsIgnoreCase("ADMIN")) {
            employeeDao.create(client, employeeObject);
            return;
        }
        throw new Exception("Access Denied!");
    }

    @Override
    public void delete(String client, int employeeId) throws Exception {
        if(client.equalsIgnoreCase("ADMIN")) {
            employeeDao.delete(client, employeeId);
            return;
        }
        throw new Exception("Access Denied!");
    }

    @Override
    public EmployeeDo get(String client, int employeeId) throws Exception {
        if(client.equalsIgnoreCase("USER") || client.equalsIgnoreCase("ADMIN")) {
            return employeeDao.get(client, employeeId);
        }
        throw new Exception("Access Denied");
    }
}
