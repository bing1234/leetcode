package com.geekbing.easy;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode2409 {
    private static final int[] monthDays = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int arriveAliceDay = countDays(arriveAlice);
        int leaveAliceDay = countDays(leaveAlice);
        int arriveBobDay = countDays(arriveBob);
        int leaveBobDay = countDays(leaveBob);
        if (leaveAliceDay < arriveBobDay || leaveBobDay < arriveAliceDay) {
            return 0;
        }
        return Math.min(leaveAliceDay, leaveBobDay) - Math.max(arriveAliceDay, arriveBobDay) + 1;
    }

    private int countDays(String date) {
        int month = Integer.parseInt(date.substring(0, 2));
        int day = Integer.parseInt(date.substring(3, 5));
        int days = 0;
        for (int i = 0; i < month - 1; i++) {
            days += monthDays[i];
        }
        return days + day;
    }

    @Test
    public void testCase1() {
        LeetCode2409 leetCode2409 = new LeetCode2409();
        int ans = leetCode2409.countDaysTogether("08-15", "08-18", "08-16", "08-19");
        assert ans == 3;
    }

    @Test
    public void testCase2() {
        LeetCode2409 leetCode2409 = new LeetCode2409();
        int ans = leetCode2409.countDaysTogether("10-01", "10-31", "11-01", "12-31");
        assert ans == 0;
    }
}
