package com.geekbing.easy;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author bing
 */
public class LeetCode1133 {
    public int largestUniqueNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int ans = -1;
        for (int num : map.keySet()) {
            if (map.get(num) == 1) {
                ans = Math.max(ans, num);
            }
        }
        return ans;
    }

    @Test
    public void testCase1() {
        LeetCode1133 leetCode1133 = new LeetCode1133();
        assert leetCode1133.largestUniqueNumber(new int[]{5, 7, 3, 9, 4, 9, 8, 3, 1}) == 8;
    }

    @Test
    public void testCase2() {
        LeetCode1133 leetCode1133 = new LeetCode1133();
        assert leetCode1133.largestUniqueNumber(new int[]{9, 9, 8, 8}) == -1;
    }
}
