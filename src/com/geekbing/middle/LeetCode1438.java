package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.TreeMap;

/**
 * @author bing
 */
public class  LeetCode1438 {
    public int longestSubarray(int[] nums, int limit) {
        int left = 0, ans = 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int right = 0; right < nums.length; right++) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            while (map.lastKey() - map.firstKey() > limit) {
                map.put(nums[left], map.get(nums[left]) - 1);
                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }

    @Test
    public void testCase1() {
        LeetCode1438 leetCode1438 = new LeetCode1438();
        assert leetCode1438.longestSubarray(new int[]{8, 2, 4, 7}, 4) == 2;
    }

    @Test
    public void testCase2() {
        LeetCode1438 leetCode1438 = new LeetCode1438();
        assert leetCode1438.longestSubarray(new int[]{10, 1, 2, 4, 7, 2}, 5) == 4;
    }

    @Test
    public void testCase3() {
        LeetCode1438 leetCode1438 = new LeetCode1438();
        assert leetCode1438.longestSubarray(new int[]{4, 2, 2, 2, 4, 4, 2, 2}, 0) == 3;
    }

    @Test
    public void testCase4() {
        LeetCode1438 leetCode1438 = new LeetCode1438();
        assert leetCode1438.longestSubarray(new int[]{8}, 10) == 1;
    }
}
