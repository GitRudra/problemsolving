package org.home.algo.string;

import org.junit.Test;

import static org.junit.Assert.*;

public class FirstNonRepeatingCharacterInStreamTest {

    @Test
    public void testForScenarioOne() {
        FirstNonRepeatingCharacterInStream fNRCS = new FirstNonRepeatingCharacterInStream();
        String stream = "geeksforgeeks";
        System.out.println(stream);
        for(int i = 0;i<stream.length();i++){
            fNRCS.addCharacter(stream.charAt(i));
            System.out.print(fNRCS.getFirstNonRepeatingCharacter()+", ");
        }
        System.out.println("");
    }

    @Test
    public void testForScenarioTwo() {
        FirstNonRepeatingCharacterInStream fNRCS = new FirstNonRepeatingCharacterInStream();
        String stream = "geeksforgeeksandgeeksquizfor";
        System.out.println(stream);
        for(int i = 0;i<stream.length();i++){
            fNRCS.addCharacter(stream.charAt(i));
            System.out.print(fNRCS.getFirstNonRepeatingCharacter()+", ");
        }
        System.out.println("");
    }
}