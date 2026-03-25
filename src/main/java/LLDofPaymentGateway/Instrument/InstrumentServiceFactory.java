package LLDofPaymentGateway.Instrument;

public class InstrumentServiceFactory {
    public InstrumentService getInstrumentService(InstrumentType instrumentType) {
        if(instrumentType == InstrumentType.CARD)
            return new CardService();
        else if(instrumentType == InstrumentType.BANK)
            return new BankService();
        return null;
    }
}
