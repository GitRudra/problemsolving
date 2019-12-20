package org.home.java;

public class ConvertNumberToString {

    private static final String[] specialSignatures = {
            "",
            " thousand",
            " million",
            " billion",
            " trillion",
            " quadrillion",
            " quintillion"
    };

    private String tensSignature(int num) {
        String tenSttr = "";
        switch (num) {
            case 0:
                tenSttr = "";
                break;
            case 10:
                tenSttr = "ten";
                break;
            case 20:
                tenSttr = "twenty";
                break;
            case 30:
                tenSttr = "thirty";
                break;
            case 40:
                tenSttr = "fourty";
                break;
            case 50:
                tenSttr = "fifty";
                break;
            case 60:
                tenSttr = "sixty";
                break;
            case 70:
                tenSttr = "seventy";
                break;
            case 80:
                tenSttr = "eighty";
                break;
            case 90:
                tenSttr = "ninety";
                break;

        }
        return tenSttr;
    }

    private String numNames(int num) {
        String numStr = "";
        switch (num) {
            case 0:
                numStr = "";
                break;
            case 1:
                numStr = " one";
                break;
            case 2:
                numStr = " two";
                break;
            case 3:
                numStr = " three";
                break;
            case 4:
                numStr = "four";
                break;
            case 5:
                numStr = "five";
                break;
            case 6:
                numStr = "six";
                break;
            case 7:
                numStr = "seven";
                break;
            case 8:
                numStr = "eight";
                break;
            case 9:
                numStr = "nine";
                break;
            case 10:
                numStr = "ten";
                break;
            case 11:
                numStr = "eleven";
                break;
            case 12:
                numStr = "twelve";
                break;
            case 13:
                numStr = "thirteen";
                break;
            case 14:
                numStr = "fourteen";
                break;
            case 15:
                numStr = "fifteen";
                break;
            case 16:
                numStr = "sixteen";
                break;
            case 17:
                numStr = "seventeen";
                break;
            case 18:
                numStr = "eighteen";
                break;
            case 19:
                numStr = "nineteen";
                break;
        }

        return numStr;

    }

    private String convertLessThanOneThousand(int number) {
        String current;

        if (number % 100 < 20) {
            current = numNames(number % 100);
            number /= 100;
        } else {
            current = numNames(number % 10);
            number /= 10;

            current = tensSignature(number % 10) + current;
            number /= 10;
        }
        if (number == 0) return current;
        return numNames(number) + " hundred" + current;
    }

    public String convert(int number) {

        if (number == 0) {
            return "zero";
        }

        String prefix = "";

        if (number < 0) {
            number = -number;
            prefix = "negative";
        }

        String current = "";
        int place = 0;

        do {
            int n = number % 1000;
            if (n != 0) {
                String s = convertLessThanOneThousand(n);
                current = s + specialSignatures[place] + current;
            }
            place++;
            number /= 1000;
        } while (number > 0);

        return (prefix + current).trim();
    }

    /*public static void main(String[] args) {
        NumberToWord obj = new NumberToWord();
        System.out.println("*** " + obj.convert(123456789));
        System.out.println("*** " + obj.convert(-55));
    }*/
}
