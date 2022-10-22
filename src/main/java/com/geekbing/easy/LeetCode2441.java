package com.geekbing.easy;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author bing
 */
public class LeetCode2441 {
    public int findMaxK(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int ans = -1;
        for (int num : nums) {
            if (set.contains(-num) && Math.abs(num) > ans) {
                ans = Math.abs(num);
            }
            set.add(num);
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