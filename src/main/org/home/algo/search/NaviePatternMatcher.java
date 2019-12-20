package org.home.algo.search;

public class NaviePatternMatcher {
    public Integer findFirstIndexOf(String inputString, String matchString) {
        boolean isMatched = true;
        if (inputString == null || inputString.length() == 0) {
            return -1;
        }
        if (matchString == null || matchString.length() == 0) {
            return -1;
        }

        if (inputString.length() < matchString.length()) {
            return -1;
        }

        int inputStrLen = inputString.length();
        int matchStrLen = matchString.length();
        int i;
        for (i = 0; i <= inputStrLen - matchStrLen; i++) {
            for (int j = 0; j < matchStrLen; j++) {
                if (inputString.charAt(i + j) != matchString.charAt(j)) {
                    isMatched = false;
                    break;
                }else{
                    isMatched = true;
                }
            }
            if (isMatched) {
                break;
            }
        }

        if (isMatched) {
            return i;
        } else {
            return -1;
        }


    }
}
