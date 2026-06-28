package LLD.FactoryDesignPattern;

public class TroopFactory {
    public static Troop createTroop(String type) {
        Troop troop;
        if ("Barbarian".equalsIgnoreCase(type))
            troop = new Barbarian();
        else if ("Archer".equalsIgnoreCase(type))
            troop = new Archer();
        else if ("Wizard".equalsIgnoreCase(type))
            troop = new Wizard();
        else if ("HogRider".equalsIgnoreCase(type))
            troop = new HogRider();
        else
            throw new IllegalArgumentException("Unknown troop type: " + type);

        return troop;
    }
}
