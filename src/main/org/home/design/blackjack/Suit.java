package org.home.design.blackjack;

public enum Suit {
    CLUB(0), SPADE(1), DIAMOND(2), HEARTS(3);
    private int value;

    Suit(int x) {
        value = x;
    }

    public int getValue() {
        return value;
    }

    /**
     * Return the Suit for the given value.
     *
     * @param val
     * @return {@link Suit} for the value {@code val}. Return null if invalid value passed
     */
    public static Suit getSuitFromValue(int val) {
        Suit suit = null;
        switch (val) {
            case 0:
                suit = CLUB;
                break;
            case 1:
                suit = SPADE;
                break;
            case 2:
                suit = DIAMOND;
                break;
            case 3:
                suit = HEARTS;
                break;
        }

        return suit;
    }
}
