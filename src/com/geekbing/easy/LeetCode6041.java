package com.geekbing.easy;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author bing
 */
public class LeetCode6041 {
    public List<Integer> intersection(int[][] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] arr : nums) {
            for (int num : arr) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }
        int len = nums.length;
        List<Integer> ans = new ArrayList<>();
        map.forEach((key, val) -> {
            if (val == len) {
                ans.add(key);
            }
        });
        Collections.sort(ans);
        return ans;
    }

    @Test
    public void testCase1() {
        LeetCode6041 leetCode6041 = new LeetCode6041();
        List<Integer> ans = leetCode6041.intersection(new int[][]{{3, 1, 2, 4, 5}, {1, 2, 3, 4}, {3, 4, 5, 6}});
        List<Integer> expert = new ArrayList<>(Arrays.asList(3, 4));
        assert expert.equals(ans);
    }

    @Test
    public void testCase2() {
        LeetCode6041 leetCode6041 = new LeetCode6041();
        List<Integer> ans = leetCode6041.intersection(new int[][]{{1, 2, 3}, {4, 5, 6}});
        assert new ArrayList<>().equals(ans);
    }
}
