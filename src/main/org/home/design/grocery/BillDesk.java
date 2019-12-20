package org.home.design.grocery;

import java.util.Iterator;
import java.util.Map;

public class BillDesk {

    private Inventory inventory;
    public BillDesk(Inventory inventory) {
        this.inventory = inventory;
    }

    public Integer generateBill(Customer c){
        Integer sum = 0;
        if(c.getPurchasedItemList().size()!=0){
            for (Map.Entry<Item, Integer> entry : c.getPurchasedItemList().entrySet()) {
                Item key = entry.getKey();
                Integer value = entry.getValue();
                sum += key.getPrice() * value;
                inventory.updateInventoryForItem(key,value,false);
            }
        }
        return sum;
    }
}
