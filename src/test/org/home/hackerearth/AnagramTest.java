package org.home.hackerearth;

import org.junit.Test;

import static org.junit.Assert.*;

public class AnagramTest {

    @Test
    public void findNumberOfDeletionOne() {
        String input1 = "abc";
        String input2 = "cde";
        int expected = 4;
        int actual = Anagram.findNumberOfDeletion(input1,input2);
        assertEquals(expected,actual);
    }

    @Test
    public void findNumberOfDeletionTwo() {
        String input1 = "sduifiusdgfiulsdgfigsdilfuseteygyewrfwurw";
        String input2 = "lwuigrywfdlfsdfisegfsdgfs";
        int expected = 4;
        int actual = Anagram.findNumberOfDeletion(input1,input2);
        assertEquals(expected,actual);
    }
}