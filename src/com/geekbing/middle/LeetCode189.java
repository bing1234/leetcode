package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author bing
 */
public class LeetCode189 {
    public void rotate(int[] nums, int k) {

    }

    @Test
    public void testCase1() {
        LeetCode189 leetCode189 = new LeetCode189();
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        leetCode189.rotate(nums, 3);
        int[] expert = new int[]{5, 6, 7, 1, 2, 3, 4};
        assert Arrays.equals(expert, nums);
    }

    @Test
    public void testCase2() {
        LeetCode189 leetCode189 = new LeetCode189();
        int[] nums = new int[]{-1, -100, 3, 99};
        leetCode189.rotate(nums, 2);
        int[] expert = new int[]{3, 99, -1, -100};
        assert Arrays.equals(expert, nums);
    }
}
