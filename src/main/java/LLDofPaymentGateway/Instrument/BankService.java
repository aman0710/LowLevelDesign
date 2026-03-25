package LLDofPaymentGateway.Instrument;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BankService extends InstrumentService{
    @Override
    public InstrumentDO addInstrument(InstrumentDO instrumentDO) {
        BankInstrument bankInstrument = new BankInstrument();
        bankInstrument.setInstrumentID(new Random().nextInt(100 - 10) + 10);
        bankInstrument.setUserID(instrumentDO.getUserID());
        bankInstrument.setInstrumentType(InstrumentType.BANK);
        bankInstrument.setBankAccNo(instrumentDO.getBankAccountNumber());
        bankInstrument.setIfscCode(instrumentDO.getIfsc());
        List<Instrument> userInstruments = userVsInstruments.get(bankInstrument.getUserID());
        if(userInstruments == null) {
            userInstruments = new ArrayList<>();
            userVsInstruments.put(bankInstrument.getUserID(), userInstruments);
        }
        userInstruments.add(bankInstrument);
        return mapBankInstrumentToInstrumentDO(bankInstrument);
    }

    @Override
    public List<InstrumentDO> getInstrumentsByUserId(int userId) {
        List<Instrument> instrumentList = userVsInstruments.get(userId);
        List<InstrumentDO> instrumentDOList = new ArrayList<>();
        for(Instrument instrument: instrumentList) {
            if(instrument.getInstrumentType() == InstrumentType.BANK) {
                instrumentDOList.add(mapBankInstrumentToInstrumentDO((BankInstrument) instrument));
            }
        }
        return instrumentDOList;
    }

    private InstrumentDO mapBankInstrumentToInstrumentDO(BankInstrument bankInstrument) {
        InstrumentDO instrumentDOObj = new InstrumentDO();
        instrumentDOObj.setInstrumentType(bankInstrument.getInstrumentType());
        instrumentDOObj.setInstrumentID(bankInstrument.getInstrumentID());
        instrumentDOObj.setUserID(bankInstrument.getUserID());
        instrumentDOObj.setBankAccountNumber(instrumentDOObj.getBankAccountNumber());
        instrumentDOObj.setIfsc(instrumentDOObj.getIfsc());
        return instrumentDOObj;
    }
}
