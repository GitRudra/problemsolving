package org.home.algo.string;

import org.junit.Test;

import static org.junit.Assert.*;

public class KMPPatternMtcherTest {

    @Test
    public void match() {
        String txt = "ABABDABACDABABCABAB";
        String pat = "ABABCABAB";
        KMPPatternMtcher matcher  =  new KMPPatternMtcher();
        int index = matcher.match(txt,pat);
        System.out.println(index);
    }

    @Test
    public void createLPSArray() {
    }
}