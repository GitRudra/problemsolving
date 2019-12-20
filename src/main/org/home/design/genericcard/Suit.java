package org.home.design.genericcard;

public enum Suit {
    CLUB(0),DIAMOND(1),HEART(2),SPADE(3);
    private int value;
    private Suit(int v){
        value = v;
    }

    public int getValue(){
        return value;
    }

    public static Suit getSuitFromValue(int val){
        Suit result;
        switch(val){
            case 0:
                result = CLUB;
                break;
            case 1:
                result = DIAMOND;
                break;
            case 2:
                result = HEART;
                break;
            case 3:
                result = SPADE;
                break;
             default:
                 result = null;
        }
        return result;
    }
}
