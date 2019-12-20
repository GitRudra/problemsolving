package org.home.java;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

public class JavaDateTime {

    public static void main(String[] args) {

        //--------------------------------------------------------------
        //Basic ISO Date
        //--------------------------------------------------------------
        String dateInString = "19590709";
        LocalDate date = LocalDate.parse(dateInString, DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println(date.getDayOfYear());
        System.out.println(date.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH));

        //--------------------------------------------------------------
        //EEE, MMM d yyyy
        //--------------------------------------------------------------

        System.out.println("EEE, MMM d yyyy");
        dateInString = "Mon, 05 May 1980";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE, dd MMM yyyy", Locale.ENGLISH);
        LocalDate date1 = LocalDate.parse(dateInString,formatter);

        System.out.println(date1.getDayOfYear());
        System.out.println(date1.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH));


        //Relationship between a date and other date

        boolean flag = LocalDate.parse("2017-08-22").isAfter(LocalDate.parse("2018-08-22"));
        System.out.println(flag);

        System.out.println(LocalDateTime.now());
        System.out.println(LocalDateTime.of(2015,04,05,10,20));
        System.out.println(LocalDateTime.parse("2015-05-04T10:20"));

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime weeksAgo = now.minusWeeks(2);
        System.out.println(now);
        System.out.println(weeksAgo);

        //ZoneId.getAvailableZoneIds().stream().forEach(System.out::println);


    }
}
