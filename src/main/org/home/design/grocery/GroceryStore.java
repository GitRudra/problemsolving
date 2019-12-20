package org.home.design.grocery;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroceryStore {
    private Inventory inventory;
    private BillDesk billDesk;
    private Map<String, Customer> customersDB;

    public GroceryStore() {
        inventory = new Inventory();
        billDesk = new BillDesk(inventory);
        customersDB = new HashMap<>();
    }

    public Customer sayHello(String mobileNo){
        if(customersDB.containsKey(mobileNo)){
            return customersDB.get(mobileNo);
        }else{
            Customer c = createNewCustomer(mobileNo);
            return c;
        }
    }

    private Customer createNewCustomer(String mobileNo){
        return new Customer("abc",mobileNo);
    }

    public List<Item> getAvailableItems(){
         return inventory.getAvailableItems();
    }

    public void pickItem(Customer c, Item e, int quantity){
        c.addItemToPurchaseList(e,quantity);
        inventory.updateInventoryForItem(e,quantity,false);
    }

    public Integer generateBill(Customer customer){
        return billDesk.generateBill(customer);
    }

    public String sayGoodBye(Customer c){
        c.resetPurchaseList();
        return " Good Bye !!! "+c.getName();
    }



}
