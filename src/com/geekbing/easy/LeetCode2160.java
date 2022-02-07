package com.geekbing.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author bing
 */
public class LeetCode2160 {
    public int minimumSum(int num) {
        int[] nums = new int[]{num % 10, num % 100 / 10, num % 1000 / 100, num / 1000};
        Arrays.sort(nums);
        return nums[0] * 10 + nums[1] * 10 + nums[2] + nums[3];
    }

    @Test
    public void testCase1() {
        LeetCode2160 leetCode2160 = new LeetCode2160();
        assert leetCode2160.minimumSum(2932) == 52;
    }

    @Test
    public void testCase2() {
        LeetCode2160 leetCode2160 = new LeetCode2160();
        assert leetCode2160.minimumSum(4009) == 13;
    }
}
