package org.home.ds.array;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class NextSmallestPalindromeTest {

    @Test
    public void findNextPalindrome() {
        int[] input = {9,8,9};
        int[] expected = {9,9,9};
        NextSmallestPalindrome palindromeFinder = new NextSmallestPalindrome();
        int[] actual = palindromeFinder.findNextPalindrome(input);
        Arrays.stream(actual).forEach(e-> System.out.print(e));
        assertArrayEquals(expected,actual);

    }

    @Test
    public void findNextPalindromeTwo() {
        int[] input = {7, 8, 3, 3, 2, 2};
        int[] expected ={7, 8, 3, 3, 8, 7};
        NextSmallestPalindrome palindromeFinder = new NextSmallestPalindrome();
        int[] actual = palindromeFinder.findNextPalindrome(input);
        Arrays.stream(actual).forEach(e-> System.out.print(e));
        assertArrayEquals(expected,actual);

    }

    @Test
    public void findNextPalindromeThree() {
        int[] input = {9,9,9};
        int[] expected ={1,0,0,1};
        NextSmallestPalindrome palindromeFineder = new NextSmallestPalindrome();
        int[] actual = palindromeFineder.findNextPalindrome(input);
        Arrays.stream(actual).forEach(e-> System.out.print(e));
        assertArrayEquals(expected,actual);

    }

    @Test
    public void findNextPalindromeFour() {
        int[] input = {9, 4, 1, 8, 7, 9, 7, 8,3, 2, 2};
        int[] expected ={9,4,1,8, 8, 0, 8, 8,1,4,9};
        NextSmallestPalindrome palindromeFinder = new NextSmallestPalindrome();
        int[] actual = palindromeFinder.findNextPalindrome(input);
        Arrays.stream(actual).forEach(e-> System.out.print(e));
        assertArrayEquals(expected,actual);

    }

    @Test
    public void findNextPalindromeFive() {
        int[] input = {9,9,9};
        int[] expected ={1,0,0,1};
        NextSmallestPalindrome palindromeFinder = new NextSmallestPalindrome();
        int[] actual = palindromeFinder.findNextPalindrome(input);
        Arrays.stream(actual).forEach(e-> System.out.print(e));
        assertArrayEquals(expected,actual);

    }
}