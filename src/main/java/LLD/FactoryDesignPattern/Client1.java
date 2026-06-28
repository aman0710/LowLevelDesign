package LLD.FactoryDesignPattern;

import java.util.Scanner;

public class Client1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter troop type (Barbarian, Archer, Wizard, HogRider):");
        String type = scanner.nextLine();
        Troop troop = TroopFactory.createTroop(type);

        troop.attack();
        scanner.close();
    }
}
