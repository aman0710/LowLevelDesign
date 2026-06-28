package LLD.ProxyDesignPattern;

public class UserServiceProxy implements IUserService{

    protected final IUserService service;

    public UserServiceProxy(IUserService service) {
        this.service = service;
    }

    @Override
    public void getUser(User caller, User target) {
        service.getUser(caller, target);
    }

    @Override
    public void deleteUser(User caller, User target) {
        if(caller.getRole().equals(Role.ADMIN) || caller.getName().equals(target.getName())) {
            service.deleteUser(caller, target);
        } else {
            System.out.println(caller.getName() + " is not authorized to delete user: " + target.getName());
        }
    }
}
