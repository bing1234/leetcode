package com.geekbing.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author bing
 */
public class LeetCode1929 {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] ans = new int[2 * n];
        for (int i = 0; i < n; i++) {
            ans[i] = nums[i];
            ans[i + n] = nums[i];
        }
        return ans;
    }

    @Test
    public void testCase1() {
        LeetCode1929 leetCode1929 = new LeetCode1929();

        int[] ans = leetCode1929.getConcatenation(new int[]{1, 2, 1});
        assert Arrays.equals(ans, new int[]{1, 2, 1, 1, 2, 1});
    }

    @Test
    public void testCase2() {
        LeetCode1929 leetCode1929 = new LeetCode1929();

        int[] ans = leetCode1929.getConcatenation(new int[]{1, 3, 2, 1});
        assert Arrays.equals(ans, new int[]{1, 3, 2, 1, 1, 3, 2, 1});
    }
}
