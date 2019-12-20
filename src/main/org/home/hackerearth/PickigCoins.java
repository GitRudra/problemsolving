package org.home.hackerearth;

import java.util.Scanner;

public class PickigCoins {


    public static String getWinner(int totalCoin, int eachMove){
        if(totalCoin==0 || eachMove==0){
            return "";
        }
        String[] players = {"Alice","Bob"};
        int remainingCoin = totalCoin;
        int iterationCount = 0;
        int playerIndex = 0;
        boolean exitFlag = true;
        int reqCoin = 0;
        while(exitFlag){
            if(playerIndex%2==0){
                iterationCount++;
            }
            reqCoin = (int)Math.pow(eachMove,iterationCount);
            if(remainingCoin>reqCoin){
                playerIndex++;
                remainingCoin -= reqCoin;
            }else{
                exitFlag = false;
            }
            //remainingCoin = (t)

        }
        return players[(playerIndex+1)%2];
    }

    public static void main(String args[] ) throws Exception {
        /* Sample code to perform I/O:
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

*/
        //Scanner
        Scanner s = new Scanner(System.in);
        int totalTestCase = s.nextInt();                 // Reading input from STDIN
        int N;
        int k;
        String[] result = new String[totalTestCase];
        for(int i=0;i<totalTestCase;i++){
            N = s.nextInt();
            k = s.nextInt();
            result[i] = getWinner(N,k);
        }

        for(int i=0;i<totalTestCase;i++){
            System.out.println(result[i]);
        }
        //System.out.println("Hi, " + name + ".");    // Writing output to STDOUT



        // Write your code here

    }
}
