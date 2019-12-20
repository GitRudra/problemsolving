package org.home.design.blackjack;

import java.util.ArrayList;

public class Deck <T extends Card> {
    private ArrayList<T> cards;
    private int dealtIndex;
    public void setDeckOfCards(ArrayList<T> deckOfCards){

    }
    public void shuffle(){

    }
    public int remainingCards(){
        return (cards.size()-dealtIndex);
    }

    public T[] dealHand(int number) {
        return null;
    }

    public T dealCard() {
        return null;
    }

}
