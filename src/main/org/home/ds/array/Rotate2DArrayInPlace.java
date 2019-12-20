package org.home.ds.array;

public class Rotate2DArrayInPlace {

    public static void rotateArray(int[][] arr){
        int N = arr.length;
        int temp;
//        System.out.println("\nBefore rotation ---");
//        printArray(arr);
        for(int x = 0; x<N/2;x++){
            for(int y = x; y<N-x-1;y++ ){
                temp = arr[x][y];
                arr[x][y] = arr[N-y-1][x];
                arr[N-y-1][x] = arr[N-x-1][N-y-1];
                arr[N-x-1][N-y-1] = arr[y][N-x-1];
                arr[y][N-x-1] = temp;
            }
//            System.out.println("\nIteration : "+x);
//            printArray(arr);
        }
        System.out.println("\nAfter rotation ---");
        printArray(arr);
    }

    private static void printArray(int[][] arr){
        for(int i=0;i<arr.length;i++){
            System.out.println("");
            for(int j = 0;j <arr[0].length;j++ ){
                System.out.print(arr[i][j]+" ");
            }
        }

    }
}
