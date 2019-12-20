package org.home.cmp.ms.problems;

public class SuperStringReducer {
    private static boolean REDUCEDANY = false;

    // Complete the superReducedString function below.
    static String superReducedString(String s) {
        String reducedString = "";
        if(s==null || s.length()==0){
            return reducedString;
        }
        int preLength = s.length();
        reducedString = s;
        while(true){
            reducedString = SuperStringReducer.superReducedString2(reducedString);
            if(preLength == reducedString.length()){
                break;
            }else{
                preLength = reducedString.length();
            }
        }
        return reducedString==""?"Empty String":reducedString;

    }

    static String superReducedString2(String s) {
        String reducedString = "";
        if(s==null || s.length()==0){
            return reducedString;
        }
        StringBuilder sb = new StringBuilder();
        char ch = s.charAt(0);
        int charCount = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==ch){
                charCount++;
            }else{
                if(charCount%2 != 0){
                    sb.append(ch);
                }

                charCount = 1;
                ch = s.charAt(i);
            }
        }
        if(charCount%2 ==1){
            sb.append(ch);
        }

        return sb.toString();

    }

    static String reduceString(String s){
        REDUCEDANY = false;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<=s.length()-2;i++){
            if(s.charAt(i)!=s.charAt(i+1)){
                sb.append(s.charAt(i));
            }else{
                i++;
                REDUCEDANY = true;
            }
        }
        System.out.println("Reduced String : "+sb.toString());
        return sb.toString();
    }
}
