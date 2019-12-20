package org.home.design.blackjack;

import org.home.design.genericcard.Card;
import org.home.design.genericcard.Suit;

public class BlackJackCard extends Card {

    public BlackJackCard(int c, Suit s){
        super(c,s);
    }

    @Override
    public int value() {
        return 0;
    }
}
