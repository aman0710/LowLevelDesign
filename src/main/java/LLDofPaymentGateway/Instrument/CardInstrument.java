package LLDofPaymentGateway.Instrument;

public class CardInstrument extends Instrument{
    String cardNumber;
    String cvvNumber;

    public CardInstrument() {}

    public CardInstrument(int instrumentID, int userID, InstrumentType instrumentType, String cardNumber, String cvvNumber) {
        super(instrumentID, userID, instrumentType);
        this.cardNumber = cardNumber;
        this.cvvNumber = cvvNumber;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCvvNumber() {
        return cvvNumber;
    }

    public void setCvvNumber(String cvvNumber) {
        this.cvvNumber = cvvNumber;
    }
}
