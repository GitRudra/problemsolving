package org.home.algo.misc;

public class NumberFormatUtil {

    public static boolean isValidHexadecimal(String numberStr) throws Exception {
        if(numberStr == null || numberStr.length()==0 || numberStr.charAt(0)=='-'){
            throw new Exception("Invalid Argument");
        }

        for(int i=0;i<numberStr.length();i++){
            if(Character.digit(numberStr.charAt(i),16)==-1){
                return false;
            }
        }
        return true;
    }
}
