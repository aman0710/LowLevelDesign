package LLD.ProxyDesignPattern;

public class UserServiceImpl implements IUserService{

    @Override
    public void getUser(User caller, User target) {
        System.out.println(caller.getName() + " got the details of user: " + target.getName());
    }

    @Override
    public void deleteUser(User caller, User target) {
        System.out.println(caller.getName() + " deleted the user: " + target.getName());
    }
}
