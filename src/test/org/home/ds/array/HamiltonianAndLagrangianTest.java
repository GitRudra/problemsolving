package org.home.ds.array;

import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class HamiltonianAndLagrangianTest {

    @Test
    void findNumbersOne() {
        HamiltonianAndLagrangian solver = new HamiltonianAndLagrangian();
        int[]input= {16, 17, 4, 3, 5, 2};
        int[] expectedoutput = {17,5,2};
        int[] actual = solver.findNumbers(input);
        assertArrayEquals(expectedoutput,actual);
    }

    @Test
    void findNumbersTwo() {
        HamiltonianAndLagrangian solver = new HamiltonianAndLagrangian();
        int[]input= {16, 17, 4, 3, 5, 2};
        //int[] expectedoutput = {17,5,2};
        solver.findNumbers2(input);
    }

    int[] readFromFile(String fileName) throws IOException {
        BufferedReader br  = new BufferedReader(new FileReader(fileName));
        int inputSize = Integer.parseInt(br.readLine());
        int[] input = new int[inputSize];
        for(int i=0;i<inputSize;i++){
            input[i] = br.read();
        }
        br.close();
        return input;
    }
}