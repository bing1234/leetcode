package com.geekbing.easy;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode2148 {
    public int countElements(int[] nums) {
        int min = Integer.MAX_VALUE, minCnt = 0;
        int max = Integer.MIN_VALUE, maxCnt = 0;
        for (int num : nums) {
            if (num < min) {
                min = num;
                minCnt = 1;
            } else if (num == min) {
                minCnt++;
            }
            if (num > max) {
                max = num;
                maxCnt = 1;
            } else if (num == max) {
                maxCnt++;
            }
        }
        return Math.max(0, nums.length - minCnt - maxCnt);
    }

    @Test
    public void testCase1() {
        LeetCode2148 leetCode2148 = new LeetCode2148();
        int ans = leetCode2148.countElements(new int[]{11, 7, 2, 15});
        assert ans == 2;
    }

    @Test
    public void testCase2() {
        LeetCode2148 leetCode2148 = new LeetCode2148();
        int ans = leetCode2148.countElements(new int[]{-3, 3, 3, 90});
        assert ans == 2;
    }
}
