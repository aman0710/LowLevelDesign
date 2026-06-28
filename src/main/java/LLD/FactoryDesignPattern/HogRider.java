package LLD.FactoryDesignPattern;

public class HogRider extends Troop{

    public HogRider() {
        super(200, 60);
    }

    @Override
    public void attack() {
        System.out.println("Hog rider smashes defenses causing " + damage + " damage");
    }

    @Override
    public void move() {
        System.out.println("Hog rider moves fast and jumps over walls");
    }
}
