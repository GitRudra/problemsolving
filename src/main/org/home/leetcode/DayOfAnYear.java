package org.home.leetcode;

import java.time.LocalDate;

public class DayOfAnYear {
    public static int dayOfYear(String date){
        if(date == null || date.length() == 0){
            return -1;
        }
        LocalDate lDate = LocalDate.parse(date);
        return lDate.getDayOfYear();
    }
}
