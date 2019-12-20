package org.home.cmp.ms.problems.strings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PasswordStrengthFinder {

    public int isStrong(int minLength, String password){
        int requiredCharacter = -1;
        if(password==null || password.length()==0){
            return 6;
        }
        requiredCharacter = makePasswordStrong(password);
        return (requiredCharacter>(6-password.length()))? requiredCharacter : (6-password.length());
    }

    private boolean isEnoughLong(String input){
        return input.length() < 6 ? false : true;
    }

    private int makePasswordStrong(String s){
        int requiredCharactersType = 4;
        Set<Character> specialCharcterSet = new HashSet<>(Arrays.asList('!','@','#','$','%','^','&','*','(',')','-','+'));
        boolean uppercaseFound = false;
        boolean lowercaseFound = false;
        boolean numberFound = false;
        boolean specialCharacterFound = false;
        for(int i=0;i<s.length() && requiredCharactersType!=0 ;i++){
            if(Character.isUpperCase(s.charAt(i)) && !uppercaseFound){
                uppercaseFound = true;
                requiredCharactersType--;
            } else if(Character.isLowerCase(s.charAt(i)) && !lowercaseFound){
                lowercaseFound = true;
                requiredCharactersType--;
            }else if(Character.isDigit(s.charAt(i)) && !numberFound){
                numberFound = true;
                requiredCharactersType--;
            }else if(specialCharcterSet.contains(s.charAt(i)) && !specialCharacterFound){
                specialCharacterFound = true;
                requiredCharactersType--;
            }

        }
        return requiredCharactersType;
    }
}
