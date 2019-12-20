package org.home;

public class NumberBaseConverter {

    private String[] values = {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};

    public String getHexRepresentation(int number, int base){
       StringBuilder sb = new StringBuilder();
       while(number != 0){
           sb.append(values[number%base]);
           number = number/base;
       }
       return  sb.reverse().toString();
    }
}
