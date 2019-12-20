package org.home.algo.misc;

import java.io.IOException;
import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

/**
 * Problem : https://www.hackerrank.com/challenges/queens-attack-2/problem
 *
 */
public class AtackingQueen2 {
    /**
     * The class store the obstacles position. Created the class to store the positions into a set.
     * equals and hashCode method overrided to distinguish between position [4,3] and [3,4] if we
     * calculate hashCode on the basis row+column.
     *
     * Creating a two dimentional array and place the queen and obstacles into that array will cause OutOfMemoryError
     * for large value of input like n=100000.
     *
     * Using the HashSet approach will be memory efficient.
     */
    static class Obstacle{
        int row;
        int column;

        public Obstacle(int row, int column) {
            this.row = row;
            this.column = column;
        }

        public Obstacle() {
            this.row = -1;
            this.column = -1;
        }

        public int getRow() {
            return row;
        }

        public void setRow(int row) {
            this.row = row;
        }

        public int getColumn() {
            return column;
        }

        public void setColumn(int column) {
            this.column = column;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Obstacle obstacle = (Obstacle) o;
            return row == obstacle.row &&
                    column == obstacle.column;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, column);
        }
    }

    static int queensAttack(int n, int k, int rq, int cq, int[][] obstacles) {
        Set<Obstacle> obstacleSet = new HashSet<>();
        //row index = n-obstacles[i][0] & column index = obstacles[i][1]-1
        // will map the problem in 0,0 indexed matrix ie traditional matrix.
        //it will help in implementing logic as mentioned in the problem
        for(int i=0;i<k;i++){
            obstacleSet.add(new Obstacle(n-obstacles[i][0],obstacles[i][1]-1));

        }
        return getRightWardCount(obstacleSet,n-rq,cq-1,n)
                +getLeftWardCount(obstacleSet,n-rq,cq-1,n)
                +getDownWardCount(obstacleSet,n-rq,cq-1,n)
                +getUpWardCount(obstacleSet,n-rq,cq-1,n)
                +getCrossDiagonallyDownward(obstacleSet,n-rq,cq-1,n)
                +getCrossDiagonallyUpward(obstacleSet,n-rq,cq-1,n)
                +getDiagonallyDownward(obstacleSet,n-rq,cq-1,n)
                +getDiagonallyUpward(obstacleSet,n-rq,cq-1,n);
    }

    private static int getRightWardCount(Set<Obstacle> obstacleSet, int rq, int cq, int n){
        int obstaclesCount  = 0;
        Obstacle obs = new Obstacle();
        obs.setRow(rq);
        for(int i=cq+1;i<n;i++){
            obs.setColumn(i);
            if(!obstacleSet.contains(obs)){
                obstaclesCount++;
            }else{
                break;
            }
        }
        //System.out.println(" Right Ward Count " + obstaclesCount);
        return obstaclesCount;
    }

    private static int getLeftWardCount(Set<Obstacle> obstacleSet, int rq, int cq, int n){
        int obstaclesCount  = 0;
        Obstacle obs = new Obstacle();
        obs.setRow(rq);
        for(int i=cq-1;i>=0;i--){
            obs.setColumn(i);
            if(!obstacleSet.contains(obs)){
                obstaclesCount++;
            }else{
                break;
            }
        }
        //System.out.println(" Left Ward Count " + obstaclesCount);
        return obstaclesCount;
    }

    private static int getDownWardCount(Set<Obstacle> obstacleSet, int rq, int cq, int n){
        int obstaclesCount  = 0;
        Obstacle obs = new Obstacle();
        obs.setColumn(cq);
        for(int i=rq+1;i<n;i++){
            obs.setRow(i);
            if(!obstacleSet.contains(obs)){
                obstaclesCount++;
            }else{
                break;
            }
        }
        //System.out.println(" Down Ward Count " + obstaclesCount);
        return obstaclesCount;
    }

    private static int getUpWardCount(Set<Obstacle> obstacleSet, int rq, int cq, int n){
        int obstaclesCount  = 0;
        Obstacle obs = new Obstacle();
        obs.setColumn(cq);
        for(int i=rq-1;i>=0;i--){
            obs.setRow(i);
            if(!obstacleSet.contains(obs)){
                obstaclesCount++;
            }else{
                break;
            }
        }
        //System.out.println(" Up Ward Count " + obstaclesCount);
        return obstaclesCount;
    }

    private static int getDiagonallyUpward(Set<Obstacle> obstacleSet, int rq, int cq, int n){
        int obstaclesCount  = 0;
        Obstacle obs = new Obstacle();
        for(int i=rq-1 , j= cq+1;i>=0 && j<n;i--,j++){
            obs.setColumn(j);
            obs.setRow(i);
            if(!obstacleSet.contains(obs)){
                obstaclesCount++;
            }else{
                break;
            }
        }
        //System.out.println(" Diagonally Up Ward Count " + obstaclesCount);
        return obstaclesCount;
    }

    private static int getDiagonallyDownward(Set<Obstacle> obstacleSet, int rq, int cq, int n){
        int obstaclesCount  = 0;
        Obstacle obs = new Obstacle();
        for(int i=rq+1 , j= cq+1;i<n && j<n;i++,j++){
            obs.setColumn(j);
            obs.setRow(i);
            if(!obstacleSet.contains(obs)){
                obstaclesCount++;
            }else{
                break;
            }
        }
        //System.out.println(" Diagonally Down Ward Count " + obstaclesCount);
        return obstaclesCount;
    }

    private static int getCrossDiagonallyUpward(Set<Obstacle> obstacleSet, int rq, int cq, int n){
        int obstaclesCount  = 0;
        Obstacle obs = new Obstacle();
        for(int i=rq-1 , j= cq-1;i>=0 && j>=0;i--,j--){
            obs.setColumn(j);
            obs.setRow(i);
            if(!obstacleSet.contains(obs)){
                obstaclesCount++;
            }else{
                break;
            }
        }
        //System.out.println(" Cross Diagonally Up Ward Count " + obstaclesCount);
        return obstaclesCount;
    }

    private static int getCrossDiagonallyDownward(Set<Obstacle> obstacleSet, int rq, int cq, int n){
        int obstaclesCount  = 0;
        Obstacle obs = new Obstacle();
        for(int i=rq+1 , j= cq-1;i<n && j>=0;i++,j--){
            obs.setColumn(j);
            obs.setRow(i);
            if(!obstacleSet.contains(obs)){
                obstaclesCount++;
            }else{
                break;
            }
        }
        // System.out.println(" Cross Diagonally Down Ward Count " + obstaclesCount);
        return obstaclesCount;
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
