package org.home.docs;

import java.util.Stack;

public class DecompressString {

    public static String decompressString(String compressed){
        if(compressed == null || compressed.length() == 0){
            return "";
        }
        Stack<String> tokenStack = new Stack();
        String token = "";
        for(int i=0;i<compressed.length();i++){
            char ch = compressed.charAt(i);
            if(ch == '['){
                tokenStack.push(token);
                token = "";
            }else if(ch == ']'){
                tokenStack.push(token);
                token = "";
                String tempToken = tokenStack.pop();
                String tempRepeatCount=tokenStack.pop();
                tokenStack.push(generateRepeatingString(tempToken,
                        tempRepeatCount));
            }else{
                token += ch;
            }
        }

        tokenStack.push(token);
        String concatedString = tokenStack.pop();
        while(!tokenStack.isEmpty()){
            concatedString  = generateRepeatingString(concatedString,tokenStack.pop());
        }
        return concatedString;
    }

    private static String generateRepeatingString(String s, String count){
        StringBuilder sb  =  new StringBuilder();
        if(Character.isDigit(count.charAt(0))){
            int c = Integer.parseInt(count);
            for(int i = 0; i< c;i++){
                sb.append(s);
            }
        }else{
            sb.append(count).append(s);
        }
        return sb.toString();
    }

}
