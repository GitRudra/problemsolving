package org.home.algo.misc;

import java.io.IOException;
import java.util.Scanner;

public class AtackingQueen {
    // Complete the queensAttack function below.
    static int queensAttack(int n, int k, int rq, int cq, int[][] obstacles) {
        int[][] queenBoard = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                queenBoard[i][j]=0;
            }
        }
        queenBoard[n-rq][cq-1] = 1;
        for(int i=0;i<k;i++){
            queenBoard[n-obstacles[i][0]][obstacles[i][1]-1] = 2;
        }
        //printBoard(queenBoard,n);

        return getRightWardCount(queenBoard,n-rq,cq-1,n)
                +getLeftWardCount(queenBoard,n-rq,cq-1,n)
                +getDownWardCount(queenBoard,n-rq,cq-1,n)
                +getUpWardCount(queenBoard,n-rq,cq-1,n)
                +getCrossDiagonallyDownward(queenBoard,n-rq,cq-1,n)
                +getCrossDiagonallyUpward(queenBoard,n-rq,cq-1,n)
                +getDiagonallyDownward(queenBoard,n-rq,cq-1,n)
                +getDiagonallyUpward(queenBoard,n-rq,cq-1,n);
    }

    private static int getRightWardCount(int[][] queenBoard, int rq, int cq, int n){
        int obstaclesCount  = 0;
        for(int i=cq+1;i<n;i++){
            if(queenBoard[rq][i] != 2){
                obstaclesCount++;
            }else{
                break;
            }
        }
        //System.out.println(" Right Ward Count " + obstaclesCount);
        return obstaclesCount;
    }

    private static int getLeftWardCount(int[][] queenBoard, int rq, int cq, int n){
        int obstaclesCount  = 0;
        for(int i=cq-1;i>=0;i--){
            if(queenBoard[rq][i] != 2){
                obstaclesCount++;
            }else{
                break;
            }
        }
        //System.out.println(" Left Ward Count " + obstaclesCount);
        return obstaclesCount;
    }

    private static int getDownWardCount(int[][] queenBoard, int rq, int cq, int n){
        int obstaclesCount  = 0;
        for(int i=rq+1;i<n;i++){
            if(queenBoard[i][cq] != 2){
                obstaclesCount++;
            }else{
                break;
            }
        }
        //System.out.println(" Down Ward Count " + obstaclesCount);
        return obstaclesCount;
    }

    private static int getUpWardCount(int[][] queenBoard, int rq, int cq, int n){
        int obstaclesCount  = 0;
        for(int i=rq-1;i>=0;i--){
            if(queenBoard[i][cq] != 2){
                obstaclesCount++;
            }else{
                break;
            }
        }
        //System.out.println(" Up Ward Count " + obstaclesCount);
        return obstaclesCount;
    }

    private static int getDiagonallyUpward(int[][] queenBoard, int rq, int cq, int n){
        int obstaclesCount  = 0;
        for(int i=rq-1 , j= cq+1;i>=0 && j<n;i--,j++){
            if(queenBoard[i][j] !=2){
                obstaclesCount++;
            }else{
                break;
            }
        }
        //System.out.println(" Diagonally Up Ward Count " + obstaclesCount);
        return obstaclesCount;
    }

    private static int getDiagonallyDownward(int[][] queenBoard, int rq, int cq, int n){
        int obstaclesCount  = 0;
        for(int i=rq+1 , j= cq+1;i<n && j<n;i++,j++){
            if(queenBoard[i][j] !=2){
                obstaclesCount++;
            }else{
                break;
            }
        }
        //System.out.println(" Diagonally Down Ward Count " + obstaclesCount);
        return obstaclesCount;
    }

    private static int getCrossDiagonallyUpward(int[][] queenBoard, int rq, int cq, int n){
        int obstaclesCount  = 0;
        for(int i=rq-1 , j= cq-1;i>=0 && j>=0;i--,j--){
            if(queenBoard[i][j] !=2){
                obstaclesCount++;
            }else{
                break;
            }
        }
        //System.out.println(" Cross Diagonally Up Ward Count " + obstaclesCount);
        return obstaclesCount;
    }

    private static int getCrossDiagonallyDownward(int[][] queenBoard, int rq, int cq, int n){
        int obstaclesCount  = 0;
        for(int i=rq+1 , j= cq-1;i<n && j>=0;i++,j--){
            if(queenBoard[i][j] !=2){
                obstaclesCount++;
            }else{
                break;
            }
        }
       // System.out.println(" Cross Diagonally Down Ward Count " + obstaclesCount);
        return obstaclesCount;
    }

    private static void printBoard(int[][]board, int n){
        for(int i=0;i<n;i++){
            System.out.println();
            for(int j=0;j<n;j++){
                System.out.print(board[i][j]+" ");
            }
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        String[] r_qC_q = scanner.nextLine().split(" ");

        int r_q = Integer.parseInt(r_qC_q[0]);

        int c_q = Integer.parseInt(r_qC_q[1]);

        int[][] obstacles = new int[k][2];

        for (int i = 0; i < k; i++) {
            String[] obstaclesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int obstaclesItem = Integer.parseInt(obstaclesRowItems[j]);
                obstacles[i][j] = obstaclesItem;
            }
        }

        int result = queensAttack(n, k, r_q, c_q, obstacles);
        System.out.println("Attack Count : "+result);

       /* bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();*/

        scanner.close();
    }
}
