package com.project;

import com.fasterxml.jackson.databind.ser.std.CalendarSerializer;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Calendar;

public class MainClass {
    public static void main(String[] args) {
        Calendar calender = Calendar.getInstance();
        LocalDate localDate = LocalDate.now();
        System.out.println(calender.getTime().getDay());
        System.out.println(Timestamp.valueOf(localDate.atStartOfDay()));
    }
}
