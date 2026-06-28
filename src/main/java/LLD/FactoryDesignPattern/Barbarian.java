package LLD.FactoryDesignPattern;

public class Barbarian extends Troop{
    public Barbarian() {
        super(150, 50);
    }

    @Override
    public void attack() {
        System.out.println("Barbarian swings sword causing " + damage + " damage");
    }

    @Override
    public void move() {
        System.out.println("Barbarian charges quickly towards the enemy");
    }
}
