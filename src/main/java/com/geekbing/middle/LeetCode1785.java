package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author bing
 */
public class LeetCode1785 {
    public int minElements(int[] nums, int limit, int goal) {
        long diff = Math.abs(goal - Arrays.stream(nums).mapToLong(num -> num).sum());
        return (int) Math.ceil((double) diff / limit);
    }

    @Test
    public void testCase1() {
        LeetCode1785 leetCode1785 = new LeetCode1785();
        assert leetCode1785.minElements(new int[]{1, -1, 1}, 3, -4) == 2;
    }

    @Test
    public void testCase2() {
        LeetCode1785 leetCode1785 = new LeetCode1785();
        assert leetCode1785.minElements(new int[]{1, -10, 9, 1}, 100, 0) == 1;
    }
}
