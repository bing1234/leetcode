package com.geekbing.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author bing
 */
public class LeetCode1708 {
    public int[] largestSubarray(int[] nums, int k) {
        return new int[]{};
    }

    @Test
    public void testCase1() {
        LeetCode1708 leetCode1708 = new LeetCode1708();
        int[] ans = leetCode1708.largestSubarray(new int[]{1, 4, 5, 2, 3}, 3);
        int[] expert = new int[]{5, 2, 3};
        assert Arrays.equals(expert, ans);
    }

    @Test
    public void testCase2() {
        LeetCode1708 leetCode1708 = new LeetCode1708();
        int[] ans = leetCode1708.largestSubarray(new int[]{1, 4, 5, 2, 3}, 4);
        int[] expert = new int[]{4, 5, 2, 3};
        assert Arrays.equals(expert, ans);
    }

    @Test
    public void testCase3() {
        LeetCode1708 leetCode1708 = new LeetCode1708();
        int[] ans = leetCode1708.largestSubarray(new int[]{1, 4, 5, 2, 3}, 1);
        int[] expert = new int[]{5};
        assert Arrays.equals(expert, ans);
    }
}
