package com.geekbing;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode1984 {
    public int minimumDifference(int[] nums, int k) {
        return 0;
    }

    @Test
    public void testCase1() {
        LeetCode1984 leetCode1984 = new LeetCode1984();
        assert leetCode1984.minimumDifference(new int[]{90}, 1) == 0;
    }

    @Test
    public void testCase2() {
        LeetCode1984 leetCode1984 = new LeetCode1984();
        assert leetCode1984.minimumDifference(new int[]{9, 4, 1, 7}, 2) == 2;
    }
}
