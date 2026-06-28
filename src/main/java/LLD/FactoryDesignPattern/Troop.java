package LLD.FactoryDesignPattern;

public abstract class Troop {
    protected int health;
    protected int damage;

    public Troop(int health, int damage) {
        this.health = health;
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    public abstract void attack();
    public abstract void move();
}
