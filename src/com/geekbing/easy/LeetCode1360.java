package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode1360 {
    private static final int[] LEAP_MONTH_DAYS = new int[]{0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static final int[] NO_LEAP_MONTH_DAYS = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public int daysBetweenDates(String date1, String date2) {
        return Math.abs(getDays(date1) - getDays(date2));
    }

    private int getDays(String date) {
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5, 7));
        int day = Integer.parseInt(date.substring(8, 10));

        int days = 0;
        for (int i = 1971; i < year; i++) {
            days += isLeapYear(i) ? 366 : 365;
        }
        boolean leapYear = isLeapYear(year);
        for (int i = 1; i < month; i++) {
            days += leapYear ? LEAP_MONTH_DAYS[i] : NO_LEAP_MONTH_DAYS[i];
        }
        days += day;
        return days;
    }

    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static void main(String[] args) {
        LeetCode1360 leetCode1360 = new LeetCode1360();
        System.out.println(leetCode1360.daysBetweenDates("2019-06-29", "2019-06-30"));
        System.out.println(leetCode1360.daysBetweenDates("2020-01-15", "2019-12-31"));
        System.out.println(leetCode1360.daysBetweenDates("1971-06-29", "2010-09-23"));
    }
}
