package com.geekbing;

import org.junit.jupiter.api.Test;

/**
 * todo
 *
 * @author bing
 */
public class LeetCode16 {
    public int threeSumClosest(int[] nums, int target) {
        return 0;
    }

    @Test
    public void testCase1() {
        LeetCode16 leetCode16 = new LeetCode16();
        assert leetCode16.threeSumClosest(new int[]{-1, 2, 1, -4}, 1) == 2;
    }

    @Test
    public void testCase2() {
        LeetCode16 leetCode16 = new LeetCode16();
        assert leetCode16.threeSumClosest(new int[]{0, 0, 0}, 1) == 0;
    }
}
