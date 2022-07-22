package com.geekbing.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author bing
 */
public class LeetCode1Test {
    @Test
    public void testCase1() {
        LeetCode1 leetCode1 = new LeetCode1();
        int[] ans = leetCode1.twoSum(new int[]{2, 7, 11, 15}, 9);
        int[] expert = new int[]{0, 1};
        Arrays.sort(ans);
        assert Arrays.equals(expert, ans);
    }
}
