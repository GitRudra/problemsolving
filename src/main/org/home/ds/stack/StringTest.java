package org.home.ds.stack;

import java.util.Objects;

public class StringTest{
    private String str;



    private String hashString ;

    /*private String calculateHashString(){
        int[] frequencyArray = new int[26];
        for(int i=0;i<str.length();i++){

        }
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof StringTest){
            StringTest obj = (StringTest)o;
            return
        }
    }*/

    @Override
    public int hashCode() {

        return Objects.hash(str);
    }
}
