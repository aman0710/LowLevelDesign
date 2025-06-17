package AdapterDesignPattern.Client;

import AdapterDesignPattern.Adaptee.WeighingMachineForBabies;
import AdapterDesignPattern.Adapter.WeighingMachineAdapter;
import AdapterDesignPattern.Adapter.WeighingMachineAdapterImpl;

public class Main {
    public static void main(String[] args) {
        WeighingMachineAdapter weighingMachineAdapter = new WeighingMachineAdapterImpl(new WeighingMachineForBabies());
        System.out.println("The weight of the baby in KG is : " + weighingMachineAdapter.getWeightInKg());
    }
}
