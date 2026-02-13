package InventoryManagmentLLD;

import java.util.List;

public class NearestWarehouseSelectionStrategy extends WarehouseSelectionStrategy{

    @Override
    public Warehouse selectWarehouse(List<Warehouse> warehouseList) {
        // implement a method to return the nearest warehouse
        return warehouseList.get(0);
    }
}
