package org.home.design.grocery;

import java.util.List;

public class GroceryWorkFlow {

    public void workFlowOne(){
        GroceryStore store = new GroceryStore();
        Customer c = store.sayHello("9433382482");
        List<Item> availableProduct = store.getAvailableItems();
        store.pickItem(c,availableProduct.get(0),1);
        store.pickItem(c,availableProduct.get(1),2);
        store.pickItem(c,availableProduct.get(2),3);
        Integer amount = store.generateBill(c);
        System.out.println("Total Amount "+amount);
        System.out.println(store.sayGoodBye(c));

    }

    public static void main(String[] args) {
        GroceryWorkFlow workFlow = new GroceryWorkFlow();
        workFlow.workFlowOne();
    }
}
