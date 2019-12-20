package org.home.java;

import java.util.HashMap;

public class ReadWriteExecute {


    public static int symbolicToOctal(String permString) {
        HashMap<Character,Integer> mapping = new HashMap<>();
        mapping.put('r',4);
        mapping.put('w',2);
        mapping.put('x',1);
        mapping.put('-',0);
        if(permString == null || permString.length()==0 || permString.length()>9){
            return -1;
        }
        int sum = 0;
        for(int i=0;i<3;i++){
            int blockSum = 0;
            for(int j=i*3;j<3*(i+1);j++){
                //Character ch = new Character(permString.indexOf(j));
                if(mapping.containsKey(permString.charAt(j))){
                    blockSum+=mapping.get(permString.charAt(j));
                }else{
                    return -1;
                }
            }
            sum+=blockSum*((int)Math.pow(10,(2-i)));

        }
        return sum;

    }

    public static void main(String[] args) {
        // Should write 752

        System.out.println(ReadWriteExecute.symbolicToOctal("rwxr-x-w-"));
        System.out.println(ReadWriteExecute.symbolicToOctal("rwxrwxrwx"));
    }
}
