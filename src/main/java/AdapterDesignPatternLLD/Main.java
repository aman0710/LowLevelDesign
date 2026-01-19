package AdapterDesignPatternLLD;

import AdapterDesignPatternLLD.Adaptee.WeightMachineForBabies;
import AdapterDesignPatternLLD.Adapter.WeightMachineAdapter;
import AdapterDesignPatternLLD.Adapter.WeightMachineAdapterImpl;

public class Main {
    public static void main(String[] args) {
        WeightMachineAdapter weightMachineAdapter = new WeightMachineAdapterImpl(new WeightMachineForBabies());
        System.out.println(weightMachineAdapter.getWeightInKg());
    }
}
