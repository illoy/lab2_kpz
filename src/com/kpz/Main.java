package com.kpz;

import java.util.Calendar;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {
        var andrii = new Student("Andrii", 19, getDate(8, 6, 2001));
        var oleh = new Student("Oleh", 20, getDate(20, 9, 2000));
        var illya = new Student("Illya", 18, getDate(11, 5, 2002));

        System.out.println(andrii + "\n" + oleh + "\n" + illya);

        var copy = (Student)oleh.clone();

        System.out.println("\nOriginal " + oleh);
        System.out.println("Copy " + copy);

        System.out.printf("\nReferences are equal: %s%n", copy == oleh);
        System.out.printf("Contents are equal: %s%n", copy.equals(oleh));

        var date = oleh.getDateOfBirth();
        date.setYear(2010);
        System.out.println("\nOriginal after date change to 2010 \n" + oleh);
    }

    private static Date getDate(int date, int month, int year) {
        Calendar calendar = Calendar.getInstance();

        calendar.set(Calendar.DATE, date);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.YEAR, year);

        return calendar.getTime();
    }
}
