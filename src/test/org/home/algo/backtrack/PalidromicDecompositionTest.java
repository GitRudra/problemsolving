package org.home.algo.backtrack;

import org.junit.Test;

import static org.junit.Assert.*;

public class PalidromicDecompositionTest {

    @Test
    public void decomposeStringOne() {
        String s = "aab";
        PalidromicDecomposition.decomposeString(s);
    }

    @Test
    public void decomposeStringTwo() {
        String s = "geeksfskeeg";
        PalidromicDecomposition.decomposeString(s);
    }

    @Test
    public void decomposeStringThree() {
        String s = "bcc";
        PalidromicDecomposition.decomposeString(s);
    }
}