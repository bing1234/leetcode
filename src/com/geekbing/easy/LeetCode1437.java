package com.geekbing.easy;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode1437 {
    public boolean kLengthApart(int[] nums, int k) {
        if (k == 0) {
            return true;
        }
        int lastIdx = -k - 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                continue;
            }
            if (i - lastIdx <= k) {
                return false;
            }
            lastIdx = i;
        }
        return true;
    }

    @Test
    public void testCase1() {
        LeetCode1437 leetCode1437 = new LeetCode1437();
        assert leetCode1437.kLengthApart(new int[]{1, 0, 0, 0, 1, 0, 0, 1}, 2);
    }

    @Test
    public void testCase2() {
        LeetCode1437 leetCode1437 = new LeetCode1437();
        assert !leetCode1437.kLengthApart(new int[]{1, 0, 0, 1, 0, 1}, 2);
    }

    @Test
    public void testCase3() {
        LeetCode1437 leetCode1437 = new LeetCode1437();
        assert leetCode1437.kLengthApart(new int[]{1, 1, 1, 1, 1}, 0);
    }

    @Test
    public void testCase4() {
        LeetCode1437 leetCode1437 = new LeetCode1437();
        assert leetCode1437.kLengthApart(new int[]{0, 1, 0, 1}, 1);
    }
}
