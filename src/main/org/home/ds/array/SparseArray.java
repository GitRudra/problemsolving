package org.home.ds.array;

import java.util.HashMap;

public class SparseArray {
    static int[] matchingStrings(String[] strings, String[] queries) {
      int[] occurances = new int[queries.length];
      HashMap<String,Integer> inputFrequency = createInputMap(strings);
      for(int i=0;i<queries.length;i++){
          if(inputFrequency.containsKey(queries[i])){
              occurances[i] = inputFrequency.get(queries[i]).intValue();
          }else{
              occurances[i] = 0;
          }
      }
      return occurances;
    }

    public static HashMap<String,Integer> createInputMap(String[] strings){
        HashMap<String,Integer> inputFrequency = new HashMap<>();
        for(int i=0;i<strings.length;i++){
            if(inputFrequency.containsKey(strings[i])){
                inputFrequency.put(strings[i],inputFrequency.get(strings[i])+1);
            }else{
                inputFrequency.put(strings[i],1);
            }
        }
        return inputFrequency;
    }
}
