package InventoryManagmentLLD;

import java.util.List;

public class WarehouseController {
    List<Warehouse> warehouseList;
    WarehouseSelectionStrategy warehouseSelectionStrategy;

    public WarehouseController(List<Warehouse> warehouseList, WarehouseSelectionStrategy warehouseSelectionStrategy) {
        this.warehouseList = warehouseList;
        this.warehouseSelectionStrategy = warehouseSelectionStrategy;
    }

    public void addNewWarehouse(Warehouse warehouse) {
        this.warehouseList.add(warehouse);
    }

    public void removeWarehouse(Warehouse warehouse) {
        this.warehouseList.remove(warehouse);
    }

    public Warehouse selectWarehouse(WarehouseSelectionStrategy strategy) {
        this.warehouseSelectionStrategy = strategy;
        return warehouseSelectionStrategy.selectWarehouse(warehouseList);
    }
}
