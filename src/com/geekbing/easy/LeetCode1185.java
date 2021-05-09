package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode1185 {
    private static final String[] WEEKS = new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

    public String dayOfTheWeek(int day, int month, int year) {
        // 蔡勒(Zeller)公式
        int c, y, m, d;
        if (month == 1 || month == 2) {
            c = (year - 1) / 100;
            y = (year - 1) % 100;
            m = 12 + month;
            d = day;
        } else {
            c = year / 100;
            y = year % 100;
            m = month;
            d = day;
        }
        int D = c / 4 - 2 * c + y + y / 4 + 13 * (m + 1) / 5 + d - 1;
        return WEEKS[(D + 7000) % 7];
    }

    public static void main(String[] args) {
        LeetCode1185 leetCode1185 = new LeetCode1185();
        System.out.println(leetCode1185.dayOfTheWeek(31, 8, 2019));
        System.out.println(leetCode1185.dayOfTheWeek(18, 7, 1999));
        System.out.println(leetCode1185.dayOfTheWeek(15, 8, 1993));
        System.out.println(leetCode1185.dayOfTheWeek(7, 3, 2003));
    }
}
