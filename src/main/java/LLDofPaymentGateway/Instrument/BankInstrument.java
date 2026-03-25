package LLDofPaymentGateway.Instrument;

public class BankInstrument extends Instrument{
    String bankAccNo;
    String ifscCode;

    public BankInstrument() {}

    public BankInstrument(int instrumentID, int userID, InstrumentType instrumentType, String bankAccNo, String ifscCode) {
        super(instrumentID, userID, instrumentType);
        this.bankAccNo = bankAccNo;
        this.ifscCode = ifscCode;
    }

    public String getBankAccNo() {
        return bankAccNo;
    }

    public void setBankAccNo(String bankAccNo) {
        this.bankAccNo = bankAccNo;
    }

    public String getIfscCode() {
        return ifscCode;
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }
}
