package org.home.design.grocery;

public class Item {
    private String name;
    private Integer price;
    private int quantity;
    private boolean outOfStock;

    public Item(String name, Integer price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        if(quantity==0){
            this.outOfStock = true;
        }else{
            this.outOfStock = false;
        }
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isOutOfStock() {
        return outOfStock;
    }

    public void setOutOfStock(boolean outOfStock) {
        this.outOfStock = outOfStock;
    }

    public void updateQuantity(int quantity, boolean restock){
        if(restock){
            this.quantity += quantity;
            if(quantity>0){
                outOfStock = false;
            }
        }else{
            this.quantity -= quantity;
            if(quantity<=0){
                outOfStock = true;
            }
        }
    }
}
