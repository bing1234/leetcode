package com.geekbing.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @author bing
 */
public class LeetCode6273 {
    public int distinctAverages(int[] nums) {
        Arrays.sort(nums);
        return (int) IntStream.range(0, nums.length / 2).map(i -> nums[i] + nums[nums.length - i - 1]).distinct().count();
    }

    @Test
    public void testCase1() {
        LeetCode6273 leetCode6273 = new LeetCode6273();
        int ans = leetCode6273.distinctAverages(new int[]{4, 1, 4, 0, 3, 5});
        assert ans == 2;
    }

    @Test
    public void testCase2() {
        LeetCode6273 leetCode6273 = new LeetCode6273();
        int ans = leetCode6273.distinctAverages(new int[]{1, 100});
        assert ans == 1;
    }

    @Test
    public void testCase3() {
        LeetCode6273 leetCode6273 = new LeetCode6273();
        int ans = leetCode6273.distinctAverages(new int[]{9, 5, 7, 8, 7, 9, 8, 2, 0, 7});
        assert ans == 5;
    }

}
