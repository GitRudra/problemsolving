package org.home.algo.string;

public class SmallestWidowContaingAllCharactersOfPattern {

    public String findSmmallestWindow(String inputStr, String pat){
        if(isEmpty(inputStr) || isEmpty(pat)){
            return "";
        }

        int len1 = inputStr.length();
        int len2 = pat.length();
        if(len2>len1){
            return "";
        }

        int[] patFrequency = new int[256];
        int[] inputStrFrequency = new int[256];

        for(int i=0;i<len2;i++){
            patFrequency[pat.charAt(i)]++;
        }
        int start = 0, start_index = -1, min_length = Integer.MAX_VALUE;
        char ch;
        int count = 0;
        for(int j = 0; j<len1;j++){
            ch = inputStr.charAt(j);
            inputStrFrequency[ch]++;
            if(patFrequency[ch] != 0 &&
               inputStrFrequency[ch] <= patFrequency[ch]){
                count++;
            }
            if(count == len2){
                char c = inputStr.charAt(start);
                while((inputStrFrequency[c] > patFrequency[c]) || patFrequency[c] == 0 ){
                    if((inputStrFrequency[c] > patFrequency[c]) || patFrequency[c] == 0){
                        inputStrFrequency[start]--;
                        start++;
                    }
                }

                int min_len = (j-start+1);
                if(min_len < min_length){
                    min_length = min_len;
                    start_index = start;
                }

            }
        }

        if(start_index == -1){
            return "NO STRING";
        }else{
            return inputStr.substring(start_index,start_index+min_length);
        }


    }

    private boolean isEmpty(String s){
        return (s == null) || (s.length() == 0);
    }
}
