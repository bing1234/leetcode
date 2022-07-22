package com.geekbing.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author bing
 */
public class LeetCode2037 {
    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        int ans = 0;
        for (int i = 0; i < seats.length; i++) {
            ans += Math.abs(seats[i] - students[i]);
        }
        return ans;
    }

    @Test
    public void testCase1() {
        LeetCode2037 leetCode2037 = new LeetCode2037();
        assert leetCode2037.minMovesToSeat(new int[]{3, 1, 5}, new int[]{2, 7, 4}) == 4;
    }

    @Test
    public void testCase2() {
        LeetCode2037 leetCode2037 = new LeetCode2037();
        assert leetCode2037.minMovesToSeat(new int[]{4, 1, 5, 9}, new int[]{1, 3, 2, 6}) == 7;
    }

    @Test
    public void testCase3() {
        LeetCode2037 leetCode2037 = new LeetCode2037();
        assert leetCode2037.minMovesToSeat(new int[]{2, 2, 6, 6}, new int[]{1, 3, 2, 6}) == 4;
    }
}
