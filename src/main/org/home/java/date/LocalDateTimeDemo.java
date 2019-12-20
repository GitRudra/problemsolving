package org.home.java.date;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;

public class LocalDateTimeDemo {
    public static void main(String[] args) {
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);
        LocalDateTime ldt2 = LocalDateTime.parse("2019-10-27T16:51:04.284");
        Instant instant = ldt.toInstant(ZoneOffset.UTC);
        System.out.println(instant);
        instant = ldt.atZone(ZoneId.systemDefault()).toInstant();
        System.out.println(instant);
    }
}
