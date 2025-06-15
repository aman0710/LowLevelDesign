package LLDofATM;

import NullObjectDesignPattern.Car;

public class Main {
    public static void main(String[] args) {
        ATMRoom atmRoom = ATMRoom.intialize(3000, "112233", 3500, 1, 2, 5);
        ATM atm = atmRoom.getAtm();
        Card card = atmRoom.getUser().getCard();
        try {
            atm.displayATM();
            atm.getAtmState().insertCard(atm);
            atm.getAtmState().authenticatePin(atm, card, "112233");
            atm.getAtmState().selectOperation(atm, card, TransactionType.CASH_WITHDRAWAL);
            atm.getAtmState().withdrawCash(atm, card, 2700);
            atm.displayATM();
            card.displayBalance();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
