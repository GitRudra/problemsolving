package org.home.algo.misc;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class GeneratePalindromeNumberTest {

    @Test
    public void testGenerateNumberOne() {
        int num = 21;
        int base = 10;
        int expected = 212;
        GeneratePalindromeNumber generate = new GeneratePalindromeNumber();
        int actual = generate.generatePalindrome(num,base,true);
        assertEquals(expected,actual);
    }

    @Test
    public void testGenerateNumberTwo() {
        int num = 21;
        int base = 10;
        int expected = 2112;
        GeneratePalindromeNumber generate = new GeneratePalindromeNumber();
        int actual = generate.generatePalindrome(num,base,false);
        assertEquals(expected,actual);
    }

    @Test
    public void testGenerateNumberThree() {
        int num = 9999;
        int base = 10;
        //int expected = 2112;
        GeneratePalindromeNumber generate = new GeneratePalindromeNumber();
        List<Integer> actual = generate.generatePalindrome(num);
        actual.stream().forEach(e->{
            System.out.println(e);
        });
//        assertEquals(expected,actual);
    }
}