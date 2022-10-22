package com.geekbing.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author bing
 */
public class LeetCode2441 {
    public int findMaxK(int[] nums) {
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        int ans = -1;
        for (Integer num : set) {
            if (num > 0 && set.contains(-num) && Math.abs(num) > ans) {
                ans = Math.abs(num);
            }
        }
        return ans;
    }

    @Test
    public void testCase1() {
        LeetCode2441 leetCode2441 = new LeetCode2441();
        int ans = leetCode2441.findMaxK(new int[]{-1, 2, -3, 3});
        assert ans == 3;
    }

    @Test
    public void testCase2() {
        LeetCode2441 leetCode2441 = new LeetCode2441();
        int ans = leetCode2441.findMaxK(new int[]{-1, 10, 6, 7, -7, 1});
        assert ans == 7;
    }

    @Test
    public void testCase3() {
        LeetCode2441 leetCode2441 = new LeetCode2441();
        int ans = leetCode2441.findMaxK(new int[]{-10, 8, 6, 7, -2, -3});
        assert ans == -1;
    }
}