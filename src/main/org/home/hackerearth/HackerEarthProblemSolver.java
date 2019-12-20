package org.home.hackerearth;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class HackerEarthProblemSolver {
    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(
                new FileInputStream("./test-data/Akash-GCD/TC-001.txt")));
        String arrayLengthStr = br.readLine();
        Integer arrayLength = Integer.parseInt(arrayLengthStr);
        int[] array = new int[arrayLength];
        String arrayElementsStr = br.readLine();
        String[] elements = arrayElementsStr.split("\\s");
        for (int i = 0; i < elements.length; i++) {
            array[i] = Integer.parseInt(elements[i]);
        }


        Integer numberOfQuery = Integer.parseInt(br.readLine());
        ArrayList<Integer> resultList = new ArrayList<>();

        //AkashAndGcd gcdSolver = new AkashAndGcd(array);
        GCDProblem gcdProblem = new GCDProblem(array);

        /**for (int i = 0; i < numberOfQuery; i++) {
            // String query = s.nextLine();
            String[] queryParams = br.readLine().split("\\s");
            if ("C".equals(queryParams[0])) {
                resultList.add(gcdSolver.cQuery(Integer.parseInt(queryParams[1]),
                        Integer.parseInt(queryParams[2])));
            } else {
                gcdSolver.uQuery(Integer.parseInt(queryParams[1]),
                        Integer.parseInt(queryParams[2]));
            }
        }*/

        br.close();
        resultList.forEach(e -> System.out.println(e));

        //System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

    }
}
