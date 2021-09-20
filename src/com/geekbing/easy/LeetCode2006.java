package com.geekbing.easy;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author bing
 */
public class LeetCode2006 {
    public int countKDifference(int[] nums, int k) {
        // 数字-数量
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int ans = 0;
        Set<Integer> visited = new HashSet<>();
        for (int num : nums) {
            if (visited.contains(num)) {
                continue;
            }
            if (map.containsKey(num + k) && !visited.contains(num + k)) {
                ans += map.get(num) * map.getOrDefault(num + k, 0);
            }
            if (num > k && map.containsKey(num - k) && !visited.contains(num - k)) {
                ans += map.get(num) * map.getOrDefault(num - k, 0);
            }
            visited.add(num);
        }
        return ans;
    }

    @Test
    public void testCase1() {
        LeetCode2006 leetCode2006 = new LeetCode2006();
        int ans = leetCode2006.countKDifference(new int[]{1, 2, 2, 1}, 1);
        assert ans == 4;
    }

    @Test
    public void testCase2() {
        LeetCode2006 leetCode2006 = new LeetCode2006();
        int ans = leetCode2006.countKDifference(new int[]{1, 3}, 3);
        assert ans == 0;
    }

    @Test
    public void testCase3() {
        LeetCode2006 leetCode2006 = new LeetCode2006();
        int ans = leetCode2006.countKDifference(new int[]{3, 2, 1, 5, 4}, 2);
        assert ans == 3;
    }

    @Test
    public void testCase4() {
        LeetCode2006 leetCode2006 = new LeetCode2006();
        int ans = leetCode2006.countKDifference(new int[]{7, 7, 8, 3, 1, 2, 7, 2, 9, 5}, 6);
        assert ans == 6;
    }
}
