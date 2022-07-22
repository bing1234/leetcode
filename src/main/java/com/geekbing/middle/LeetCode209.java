package com.geekbing.middle;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode209 {
    public int minSubArrayLen(int s, int[] nums) {
        int sum = 0, i = 0, j = 0, ans = Integer.MAX_VALUE;
        while (j < nums.length) {
            sum += nums[j];
            j++;
            while (sum >= s) {
                ans = Math.min(ans, j - i);
                sum -= nums[i];
                i++;
            }
        }
        if (ans > nums.length) {
            return 0;
        }
        return ans;
    }

    @Test
    public void testCase1() {
        LeetCode209 leetCode209 = new LeetCode209();
        assert leetCode209.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}) == 2;
    }

    @Test
    public void testCase2() {
        LeetCode209 leetCode209 = new LeetCode209();
        assert leetCode209.minSubArrayLen(4, new int[]{1, 4, 4}) == 1;
    }

    @Test
    public void testCase3() {
        LeetCode209 leetCode209 = new LeetCode209();
        assert leetCode209.minSubArrayLen(11, new int[]{1, 1, 1, 1, 1, 1, 1, 1}) == 0;
    }
}
