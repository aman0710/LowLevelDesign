package LLDofPaymentGateway.Instrument;

import java.util.ArrayList;
import java.util.List;

public class InstrumentController {
    InstrumentServiceFactory instrumentServiceFactory;

    public InstrumentController() {
        instrumentServiceFactory = new InstrumentServiceFactory();
    }

    public InstrumentDO addInstrument(InstrumentDO instrumentDO) {
        InstrumentService instrumentService = instrumentServiceFactory.getInstrumentService(instrumentDO.getInstrumentType());
        return instrumentService.addInstrument(instrumentDO);
    }

    public InstrumentDO getInstrumentById(int userId, int instrumentId) {
        List<InstrumentDO> instrumentDOList = getAllInstruments(userId);
        for(InstrumentDO instrumentDO: instrumentDOList) {
            if(instrumentDO.getInstrumentID() == instrumentId) {
                return instrumentDO;
            }
        }
        return null;
    }

    public List<InstrumentDO> getAllInstruments(int userId) {
        InstrumentService bankService = instrumentServiceFactory.getInstrumentService(InstrumentType.BANK);
        InstrumentService cardService = instrumentServiceFactory.getInstrumentService(InstrumentType.CARD);
        List<InstrumentDO> instrumentDOList = new ArrayList<>();
        instrumentDOList.addAll(bankService.getInstrumentsByUserId(userId));
        instrumentDOList.addAll(cardService.getInstrumentsByUserId(userId));
        return instrumentDOList;
    }
}
