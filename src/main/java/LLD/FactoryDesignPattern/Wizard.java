package LLD.FactoryDesignPattern;

public class Wizard extends Troop{
    public Wizard() {
        super(120, 70);
    }

    @Override
    public void attack() {
        System.out.println("Wizard casts a fireball causing " + damage + " magical damage");
    }

    @Override
    public void move() {
        System.out.println("Wizard teleports short distance");
    }
}
