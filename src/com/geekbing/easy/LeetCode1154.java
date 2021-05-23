package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode1154 {
    private static final int[] MONTH_DAYS = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public int dayOfYear(String date) {
        // 得到年月日
        int year = parseYearFromDate(date);
        int month = parseMonthFromDate(date);
        int day = parseDayFromDate(date);
        int ans = 0;
        // 计算月的所有天数
        for (int i = 0; i < month - 1; i++) {
            ans += MONTH_DAYS[i];
        }
        if (month > 2) {
            // 判断是否是闰年
            if (isLeapYear(year)) {
                ans++;
            }
        }
        // 加上天数
        ans += day;
        return ans;
    }

    private int parseYearFromDate(String date) {
        return Integer.parseInt(date.substring(0, 4));
    }

    private int parseMonthFromDate(String date) {
        return date.charAt(5) == '0' ? Integer.parseInt(date.substring(6, 7)) : Integer.parseInt(date.substring(5, 7));
    }

    private int parseDayFromDate(String date) {
        return date.charAt(8) == '0' ? Integer.parseInt(date.substring(9, 10)) : Integer.parseInt(date.substring(8, 10));
    }

    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }

    public static void main(String[] args) {
        LeetCode1154 leetCode1154 = new LeetCode1154();
        System.out.println(leetCode1154.dayOfYear("2019-01-09"));
        System.out.println(leetCode1154.dayOfYear("2019-02-10"));
        System.out.println(leetCode1154.dayOfYear("2003-03-01"));
        System.out.println(leetCode1154.dayOfYear("2004-03-01"));
    }
}
