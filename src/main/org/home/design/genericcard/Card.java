package org.home.design.genericcard;

public abstract class Card {
    private boolean available = true;
    protected int faceValue;
    private Suit belongsTo;

    public Card(int faceValue,Suit suit){
        this.faceValue = faceValue;
        this.belongsTo = suit;
    }

    public abstract int value();

    public void markAvailable(){
        available = true;
    }

    public void markUnAvailable(){
        available = false;
    }

}
