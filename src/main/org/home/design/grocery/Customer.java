package org.home.design.grocery;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Customer {
    private Map<Item,Integer> purchasedItemList;
    private String name;
    private String mobileNo;

    public Customer(String name, String mobileNo) {
        this.name = name;
        this.mobileNo = mobileNo;
        purchasedItemList = new HashMap<>();
    }

    public void addItemToPurchaseList(Item e, int quantity){
        purchasedItemList.put(e,quantity);
    }

    public Map<Item, Integer> getPurchasedItemList() {
        return purchasedItemList;
    }

    public void resetPurchaseList(){
        purchasedItemList = null;
    }

    public void addBucket(){
        purchasedItemList = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public String getMobileNo() {
        return mobileNo;
    }
}
