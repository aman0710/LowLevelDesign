package ATMLLD;

public class ATMDemo {
    public static void main(String[] args) {
        ATMRoom atmRoom = new ATMRoom();
        atmRoom.initialize();

        atmRoom.atm.printCurrentATMStatus();
        atmRoom.atm.getAtmState().insertCard(atmRoom.atm, atmRoom.user.card);
        atmRoom.atm.getAtmState().authenticatePin(atmRoom.atm, atmRoom.user.card, 112211);
        atmRoom.atm.getAtmState().selectOperation(atmRoom.atm, atmRoom.user.card, TransactionType.CASH_WITHDRAWAL);
        atmRoom.atm.getAtmState().cashWithdrawal(atmRoom.atm, atmRoom.user.card, 2700);
        atmRoom.atm.printCurrentATMStatus();
    }
}
