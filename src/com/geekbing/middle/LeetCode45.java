package com.geekbing.middle;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode45 {
    public int jump(int[] nums) {
        return 0;
    }

    @Test
    public void testCase1() {
        LeetCode45 leetCode45 = new LeetCode45();
        assert leetCode45.jump(new int[]{2, 3, 1, 1, 4}) == 2;
    }

    @Test
    public void testCase2() {
        LeetCode45 leetCode45 = new LeetCode45();
        assert leetCode45.jump(new int[]{2, 3, 0, 1, 4}) == 2;
    }
}
