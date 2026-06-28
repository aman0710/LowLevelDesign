package LLD.FactoryDesignPattern;

public class Archer extends Troop{
    private final int range;
    public Archer() {
        super(100, 40);
        this.range = 5;
    }

    @Override
    public void attack() {
        System.out.println("Archer shoots an arrow from " + range + " units away causing " + damage + " damage");
    }

    @Override
    public void move() {
        System.out.println("Archer moves stealthily into shooting position");
    }
}
