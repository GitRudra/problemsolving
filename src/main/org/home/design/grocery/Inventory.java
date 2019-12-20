package org.home.design.grocery;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Inventory {
    private List<Item> stocks;
    private Set<Item> stockStatus;

    public Inventory() {
        stocks = new ArrayList<>();
        stockStatus = new HashSet<>();
        loadInventory();
    }

    public void addNewItem(String name, Integer price, int quantity){
        Item i = new Item(name,price,quantity);
        if(!i.isOutOfStock()){
            stockStatus.add(i);
        }
    }

    public void updateInventoryForItem(Item i,int quantity, boolean restock){
        i.updateQuantity(quantity,restock);
        if(i.isOutOfStock()){
            stockStatus.remove(i);
        }
    }

    public List<Item> getAvailableItems(){
        return new ArrayList<>(stockStatus);
    }

    private void loadInventory(){
        for(int i=1;i<=10;i++){
            Item e = new Item("Item"+i,i*10,i*2);
            stocks.add(e);
            stockStatus.add(e);
        }
    }
}
