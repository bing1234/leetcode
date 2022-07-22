package com.geekbing.easy;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode908 {
    public int smallestRangeI(int[] A, int K) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int num : A) {
            if (num > max) {
                max = num;
            }
            if (num < min) {
                min = num;
            }
        }
        return Math.max(max - min - 2 * K, 0);
    }

    @Test
    public void testCase1() {
        LeetCode908 leetCode908 = new LeetCode908();
        assert leetCode908.smallestRangeI(new int[]{1}, 0) == 0;
    }

    @Test
    public void testCase2() {
        LeetCode908 leetCode908 = new LeetCode908();
        assert leetCode908.smallestRangeI(new int[]{0, 10}, 2) == 6;
    }

    @Test
    public void testCase3() {
        LeetCode908 leetCode908 = new LeetCode908();
        assert leetCode908.smallestRangeI(new int[]{1, 3, 6}, 3) == 0;
    }
}
