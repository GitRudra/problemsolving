package org.home.cmp.ms.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SMSSplitterTest {

    @Test
    void splitSms1() {
        String smsText = "";
        int splitLength = 300;
        int expectedValue = -1;
        SMSSplitter splitter = new SMSSplitter();
        int actual = splitter.splitSms(smsText,splitLength);
        assertEquals(expectedValue,actual);
    }

    @Test
    void splitSms2() {
        String smsText = "ILoveMyIndia";
        int splitLength = 3;
        int expectedValue = -1;
        SMSSplitter splitter = new SMSSplitter();
        int actual = splitter.splitSms(smsText,splitLength);
        assertEquals(expectedValue,actual);
    }

    @Test
    void splitSms3() {
        String smsText = "I Love My India";
        int splitLength = 5;
        int expectedValue = 4;
        SMSSplitter splitter = new SMSSplitter();
        int actual = splitter.splitSms(smsText,splitLength);
        assertEquals(expectedValue,actual);
    }

    @Test
    void splitSms4() {
        String smsText = "I Love My India Proud To Be Indian";
        int splitLength = 6;
        int expectedValue = 7;
        SMSSplitter splitter = new SMSSplitter();
        int actual = splitter.splitSms(smsText,splitLength);
        assertEquals(expectedValue,actual);
    }

}