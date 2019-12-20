package org.home.hackerearth;

import org.junit.Test;

import static org.junit.Assert.*;

public class SeatingArrangementTest {

    @Test
    public void getFacingSeatNoOne() {
        SeatingArrangement seatArrangement = new SeatingArrangement();
        int expected = 7;
        int seatNo = 6;
        int actual = seatArrangement.getFacingSeatNo(seatNo);
        assertEquals(expected,actual);
    }

    @Test
    public void getFacingSeatNoTwo() {
        SeatingArrangement seatArrangement = new SeatingArrangement();
        int expected = 17;
        int seatNo = 20;
        int actual = seatArrangement.getFacingSeatNo(seatNo);
        assertEquals(expected,actual);
    }

    @Test
    public void getFacingSeatNoThree() {
        SeatingArrangement seatArrangement = new SeatingArrangement();
        int expected = 108;
        int seatNo = 97;
        int actual = seatArrangement.getFacingSeatNo(seatNo);
        assertEquals(expected,actual);
    }

    @Test
    public void getFacingSeatNoFour() {
        SeatingArrangement seatArrangement = new SeatingArrangement();
        int expected = 1;
        int seatNo = 12;
        int actual = seatArrangement.getFacingSeatNo(seatNo);
        assertEquals(expected,actual);
    }


    @Test
    public void testGetFacingSeatWithSeatPositionOne(){
        SeatingArrangement seatingArrangement = new SeatingArrangement();
        String expected = "12 WS";
        int seatNo = 1;
        String actual = seatingArrangement.getFacingSeatWithSeatPosition(seatNo);
        assertEquals(expected,actual);
    }

    @Test
    public void testGetFacingSeatWithSeatPositionTwo(){
        SeatingArrangement seatingArrangement = new SeatingArrangement();
        String expected = "98 MS";
        int seatNo = 107;
        String actual = seatingArrangement.getFacingSeatWithSeatPosition(seatNo);
        assertEquals(expected,actual);
    }

    @Test
    public void testGetFacingSeatWithSeatPositionThree(){
        SeatingArrangement seatingArrangement = new SeatingArrangement();
        String expected = "70 AS";
        int seatNo = 63;
        String actual = seatingArrangement.getFacingSeatWithSeatPosition(seatNo);
        assertEquals(expected,actual);
    }
}