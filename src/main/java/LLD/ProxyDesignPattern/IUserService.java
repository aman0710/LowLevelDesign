package LLD.ProxyDesignPattern;

public interface IUserService {
    void getUser(User caller, User target);
    void deleteUser(User caller, User target);
}
