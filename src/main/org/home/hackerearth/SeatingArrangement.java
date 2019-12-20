package org.home.hackerearth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class SeatingArrangement {
    private int seat_start_index = 1;
    private int seat_end_index = 108;

    private String getSeatPosition(int pos){
        String posStr = "";
        switch (pos){
            case 0:
            case 5:
                posStr="WS";
                break;
            case 1:
            case 4:
                posStr = "MS";
                break;
            case 2:
            case 3:
                posStr = "AS";
                break;
        }

        return posStr;
    }

    public int getFacingSeatNo(int sNo){
        int row = (sNo-1)/6;
        int seatIndex = (sNo-1)%6;
        int facingSeatNo = (row%2 == 0) ? 6*(row+1)+(6-seatIndex): 6*(row-1)+(6-seatIndex);
        return facingSeatNo;
    }

    public String getFacingSeatWithSeatPosition(int sNo){
        int row = (sNo-1)/6;
        int seatIndex = (sNo-1)%6;
        int facingSeatNo = (row%2 == 0) ? 6*(row+1)+(6-seatIndex): 6*(row-1)+(6-seatIndex);
        String position = getSeatPosition(seatIndex);
        return facingSeatNo+" "+position;
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        SeatingArrangement arrangement = new SeatingArrangement();
        Integer noOfTest = sc.nextInt();
        System.out.println("No of test "+noOfTest);
        ArrayList<String> resultList = new ArrayList<>();
        for(int i=0;i<noOfTest;i++){
            resultList.add(arrangement.getFacingSeatWithSeatPosition(sc.nextInt()));
        }

        resultList.forEach(e-> System.out.println(e));
        sc.close();
    }
}
