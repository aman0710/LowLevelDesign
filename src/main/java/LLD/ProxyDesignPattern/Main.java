package LLD.ProxyDesignPattern;

public class Main {
    public static void main(String[] args) {
        User caller = new User("Alice", Role.USER);
        User admin = new User("John", Role.ADMIN);
        User target = new User("Bob", Role.USER);

        IUserService service = new UserServiceImpl();
        UserServiceProxy proxy = new UserServiceProxy(service);
        proxy.getUser(caller, target);
        proxy.deleteUser(caller, target);

        proxy.getUser(admin, target);
        proxy.deleteUser(admin, target);
    }
}
