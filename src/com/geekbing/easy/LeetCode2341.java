package com.geekbing.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author bing
 */
public class LeetCode2341 {
    public int[] numberOfPairs(int[] nums) {
        Map<Integer, Integer> cntMap = new HashMap<>();
        for (int num : nums) {
            cntMap.put(num, cntMap.getOrDefault(num, 0) + 1);
        }
        int pair = 0;
        for (int cnt : cntMap.values()) {
            pair += cnt / 2;
        }
        return new int[]{pair, nums.length - pair * 2};
    }

    @Test
    public void testCase1() {
        LeetCode2341 leetCode2341 = new LeetCode2341();
        int[] ans = leetCode2341.numberOfPairs(new int[]{1, 3, 2, 1, 3, 2, 2});
        int[] expert = new int[]{3, 1};
        assert Arrays.equals(expert, ans);
    }

    @Test
    public void testCase2() {
        LeetCode2341 leetCode2341 = new LeetCode2341();
        int[] ans = leetCode2341.numberOfPairs(new int[]{1, 1});
        int[] expert = new int[]{1, 0};
        assert Arrays.equals(expert, ans);
    }

    @Test
    public void testCase3() {
        LeetCode2341 leetCode2341 = new LeetCode2341();
        int[] ans = leetCode2341.numberOfPairs(new int[]{0});
        int[] expert = new int[]{0, 1};
        assert Arrays.equals(expert, ans);
    }
}
