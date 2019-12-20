package org.home;

public class RivalStudentsOrganizer {

    public static int getMaximumDistance(int totalStudents, int maxSwap, int student1, int student2){
        //Validate input
        int finalDistance = 0;
        int currentDistance = Math.abs(student2-student1);
        if(maxSwap==0 || currentDistance == totalStudents-1){
            finalDistance =  currentDistance;
        }else{
            int diff = Math.min(totalStudents-1-currentDistance,maxSwap);
            finalDistance = currentDistance+diff;
        }
        return finalDistance;
    }

}
