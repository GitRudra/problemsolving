package org.home.design.blackjack;

public abstract class Card {
    private boolean available;

    protected int faceValue;

    protected Suit suit;

    public Card(int faceValue, Suit suit) {
        this.faceValue = faceValue;
        this.suit = suit;
    }

    public abstract int value();

    public Suit getSuit(){
        return this.suit;
    }

    public boolean isAvailable() {
        return available;
    }

    public void markAvailable(){
        available = true;
    }

    public void markUnAvailable(){
        available = false;
    }
}
