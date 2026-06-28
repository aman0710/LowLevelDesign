package LLD.FacadeDesignPattern;

public class Main {
    public static void main(String[] args) {
        BankFacade bank = new BankFacade();
        bank.withdraw("ACCT1234", 5678, 100);
    }
}
