package org.home.ds.list;

import org.junit.Test;

import static org.junit.Assert.*;

public class RunningOrderEncodingOfListTest {

    @Test
    public void getRunningOrderEncoding() {
        String[] inputArgs = {"a","a","a","b"};
        RunningOrderEncodingOfList encoder = new RunningOrderEncodingOfList();
        RunningOrderEncodingOfList.LNode returnNode = encoder.getRunningOrderEncoding(encoder.createList(inputArgs));
        encoder.printList(returnNode);
    }

    @Test
    public void getRunningOrderEncodingTwo() {
        String[] inputArgs = {"a","a","a","b","c","d","d","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","f"};
        RunningOrderEncodingOfList encoder = new RunningOrderEncodingOfList();
        RunningOrderEncodingOfList.LNode returnNode = encoder.getRunningOrderEncoding(encoder.createList(inputArgs));
        encoder.printList(returnNode);
    }

    @Test
    public void getRunningOrderEncodingThree() {
        String[] inputArgs = {"a","a","a","b","c","d","d","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","f"};
        RunningOrderEncodingOfList encoder = new RunningOrderEncodingOfList();
        RunningOrderEncodingOfList.LNode returnNode = encoder.getRunningOrderEncoding(encoder.createList(inputArgs));
        encoder.printList(returnNode);
    }

    @Test
    public void getRunningOrderEncodingFour() {
        String[] inputArgs = {"a","a","a","b","c","d","d","e","e","e","e","e","e","e","e","e","e","f"};
        RunningOrderEncodingOfList encoder = new RunningOrderEncodingOfList();
        RunningOrderEncodingOfList.LNode returnNode = encoder.getRunningOrderEncoding(encoder.createList(inputArgs));
        encoder.printList(returnNode);
    }


}