package com.geekbing.middle;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode1482 {
    public int minDays(int[] bloomDay, int m, int k) {
        if (m * k > bloomDay.length) {
            return -1;
        }
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int num : bloomDay) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        return binarySearch(bloomDay, m, k, min, max);
    }

    private int binarySearch(int[] bloomDay, int m, int k, int low, int high) {
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (valid(bloomDay, m, k, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private boolean valid(int[] bloomDay, int m, int k, int minDay) {
        int count = 0, curCnt = 0;
        for (int day : bloomDay) {
            if (day > minDay) {
                curCnt = 0;
            } else {
                curCnt++;
                if (curCnt == k) {
                    curCnt = 0;
                    count++;
                }
            }
        }
        return count >= m;
    }

    @Test
    public void testCase1() {
        LeetCode1482 leetCode1482 = new LeetCode1482();
        assert leetCode1482.minDays(new int[]{1, 10, 3, 10, 2}, 3, 1) == 3;
    }

    @Test
    public void testCase2() {
        LeetCode1482 leetCode1482 = new LeetCode1482();
        assert leetCode1482.minDays(new int[]{1, 10, 3, 10, 2}, 3, 2) == -1;
    }

    @Test
    public void testCase3() {
        LeetCode1482 leetCode1482 = new LeetCode1482();
        assert leetCode1482.minDays(new int[]{7, 7, 7, 7, 12, 7, 7}, 2, 3) == 12;
    }

    @Test
    public void testCase4() {
        LeetCode1482 leetCode1482 = new LeetCode1482();
        assert leetCode1482.minDays(new int[]{1000000000, 1000000000}, 1, 1) == 1000000000;
    }

    @Test
    public void testCase5() {
        LeetCode1482 leetCode1482 = new LeetCode1482();
        assert leetCode1482.minDays(new int[]{1, 10, 2, 9, 3, 8, 4, 7, 5, 6}, 4, 2) == 9;
    }
}
