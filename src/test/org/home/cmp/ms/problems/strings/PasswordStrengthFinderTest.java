package org.home.cmp.ms.problems.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordStrengthFinderTest {

    @Test
    void isStrongOne() {
        PasswordStrengthFinder finder = new PasswordStrengthFinder();
        String input="";
        int minLength = 6;
        int expected = 6;
        int actual = finder.isStrong(minLength,input);
        assertEquals(expected,actual);
    }

    @Test
    void isStrongTwo() {
        PasswordStrengthFinder finder = new PasswordStrengthFinder();
        String input=null;
        int minLength = 6;
        int expected = 6;
        int actual = finder.isStrong(minLength,input);
        assertEquals(expected,actual);
    }
    @Test
    void isStrongThree() {
        PasswordStrengthFinder finder = new PasswordStrengthFinder();
        String input="aAb@123";
        int minLength = 6;
        int expected = 0;
        int actual = finder.isStrong(minLength,input);
        assertEquals(expected,actual);
    }

    @Test
    void isStrongFour() {
        PasswordStrengthFinder finder = new PasswordStrengthFinder();
        String input="#HackerRank";
        int minLength = 6;
        int expected = 1;
        int actual = finder.isStrong(minLength,input);
        assertEquals(expected,actual);
    }

    @Test
    void isStrongFive() {
        PasswordStrengthFinder finder = new PasswordStrengthFinder();
        String input="Ab1";
        int minLength = 3;
        int expected = 3;
        int actual = finder.isStrong(minLength,input);
        assertEquals(expected,actual);
    }

    @Test
    void isStrongSix() {
        PasswordStrengthFinder finder = new PasswordStrengthFinder();
        String input="4700";
        int minLength = 4;
        int expected = 3;
        int actual = finder.isStrong(minLength,input);
        assertEquals(expected,actual);
    }
}