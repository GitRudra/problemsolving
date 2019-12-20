package org.home.ds.special;

/**
 * Given a Romal numeral, find its corresponding decimal value.
 */

public class DecimalToRomanConverter {

    private Integer getDecimalEquivalent(Character ch) {
        Integer value;
        switch (ch) {
            case 'I':
                value = 1;
                break;
            case 'V':
                value = 5;
                break;
            case 'X':
                value = 10;
                break;
            case 'L':
                value = 50;
                break;
            case 'C':
                value = 100;
                break;
            case 'D':
                value = 500;
                break;
            case 'M':
                value = 1000;
                break;
            default:
                value = 0;
                break;
        }

        return value;
    }

    /**
     *  Algorithm to convert Roman Numerals to Integer Number :
     *  <ol>
     *      <li>Split the Roman Numeral string into Roman Symbols (character).</li>
     *      <li>Convert each symbol of Roman Numerals into the value it represents.</li>
     *      <li>
     *          Take symbol one by one from starting from index 0:
     *          <ul>
     *              <li>If current value of symbol is greater than or equal to the value of next symbol,
     *              then add this value to the running total.</li>
     *              <li>else subtract this value by adding the value of next symbol to the running total.</li>
     *          </ul>
     *      </li>
     *  </ol>
     *
     * @param romanLiteral
     * @return
     */
    public Integer romanToDecimalConverter(String romanLiteral) {
        int curDecimal = 0;
        int nextDecimal = 0;
        int decimal = 0;
        for(int i=0;i<romanLiteral.length();i++){
            curDecimal = getDecimalEquivalent(romanLiteral.charAt(i));
            if(i+1<romanLiteral.length()){
                nextDecimal = getDecimalEquivalent(romanLiteral.charAt(i+1));
                if(curDecimal>=nextDecimal){
                    decimal += curDecimal;
                }else{
                    decimal = decimal - curDecimal + nextDecimal;
                    i++;
                }
            }else{
                decimal += curDecimal;
                i++;
            }
        }
        return decimal;
    }
}
