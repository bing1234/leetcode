package com.geekbing.todo;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode1085 {
    public int sumOfDigits(int[] nums) {
        return 0;
    }

    @Test
    public void testCase1() {
        LeetCode1085 leetCode1085 = new LeetCode1085();
        int ans = leetCode1085.sumOfDigits(new int[]{34, 23, 1, 24, 75, 33, 54, 8});
        assert ans == 0;
    }

    @Test
    public void testCase2() {
        LeetCode1085 leetCode1085 = new LeetCode1085();
        int ans = leetCode1085.sumOfDigits(new int[]{99, 77, 33, 66, 55});
        assert ans == 1;
    }
}
