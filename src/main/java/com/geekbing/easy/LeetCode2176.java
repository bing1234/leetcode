package com.geekbing.easy;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author bing
 */
public class LeetCode2176 {
    public int countPairs(int[] nums, int k) {
        int ans = 0;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Set<Integer> set = map.getOrDefault(nums[i], new HashSet<>());
            for (Integer idx : set) {
                if ((i * idx) % k == 0) {
                    ans++;
                }
            }
            set.add(i);
            map.put(nums[i], set);
        }
        return ans;
    }

    @Test
    public void testCase1() {
        LeetCode2176 leetCode2176 = new LeetCode2176();
        assert leetCode2176.countPairs(new int[]{3, 1, 2, 2, 2, 1, 3}, 2) == 4;
    }

    @Test
    public void testCase2() {
        LeetCode2176 leetCode2176 = new LeetCode2176();
        assert leetCode2176.countPairs(new int[]{1, 2, 3, 4}, 1) == 0;
    }
}
