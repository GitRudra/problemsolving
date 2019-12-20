package org.home.design.genericcard;

import java.util.ArrayList;

public class Deck<T extends Card> {
    ArrayList<T> cards;
    private int dealtlndex = 0; // marks first undealt card

    public void setDeckOfCards(ArrayList<T> deckOfCards) {
        cards = deckOfCards;
    }

    public void shuffle() {
        //TODO Logic need to be implemented
    }

    public int remainingCards() {
        return cards.size() - dealtlndex;
    }

    public T[] dealHand(int number) {
        //TODO Logic need to be implemented
        return  null;
    }

    public T dealCard() {
        //TODO Logic need to be implemented
        return null;
    }

}
