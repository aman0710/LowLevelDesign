package LLDofPaymentGateway.Instrument;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CardService extends InstrumentService{

    public CardService() {
        super();
    }
    @Override
    public InstrumentDO addInstrument(InstrumentDO instrumentDO) {
        CardInstrument cardInstrument = new CardInstrument();
        cardInstrument.setInstrumentID(new Random().nextInt(100 - 10) + 10);
        cardInstrument.setCvvNumber(instrumentDO.getCvvNumber());
        cardInstrument.setCardNumber(instrumentDO.getCardNumber());
        cardInstrument.setInstrumentType(InstrumentType.CARD);
        cardInstrument.setUserID(instrumentDO.getUserID());
        List<Instrument> instrumentList = userVsInstruments.get(cardInstrument.getUserID());
        if(instrumentList == null) {
            instrumentList = new ArrayList<>();
            userVsInstruments.put(cardInstrument.getUserID(), instrumentList);
        }
        instrumentList.add(cardInstrument);
        return mapCardInstrumentToInstrumentDO(cardInstrument);
    }

    @Override
    public List<InstrumentDO> getInstrumentsByUserId(int userId) {
        List<Instrument> userInstruments = userVsInstruments.get(userId);
        List<InstrumentDO> userInstrumentsDO = new ArrayList<>();
        for(Instrument instrument: userInstruments) {
            if(instrument.getInstrumentType() == InstrumentType.CARD) {
                userInstrumentsDO.add(mapCardInstrumentToInstrumentDO((CardInstrument) instrument));
            }
        }
        return userInstrumentsDO;
    }

    private InstrumentDO mapCardInstrumentToInstrumentDO(CardInstrument cardInstrument) {
        InstrumentDO instrumentDOObj = new InstrumentDO();
        instrumentDOObj.setInstrumentID(cardInstrument.getInstrumentID());
        instrumentDOObj.setInstrumentType(cardInstrument.getInstrumentType());
        instrumentDOObj.setUserID(cardInstrument.getUserID());
        instrumentDOObj.setCardNumber(cardInstrument.getCardNumber());
        instrumentDOObj.setCvvNumber(cardInstrument.getCvvNumber());
        return instrumentDOObj;
    }
}
