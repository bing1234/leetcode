package com.geekbing.easy;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author bing
 */
public class LeetCode6024 {
    public int mostFrequent(int[] nums, int key) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == key) {
                map.put(nums[i + 1], map.getOrDefault(nums[i + 1], 0) + 1);
            }
        }
        int maxCnt = Integer.MIN_VALUE, ans = 0;
        for (int num : map.keySet()) {
            int cnt = map.get(num);
            if (cnt > maxCnt){
                maxCnt = cnt;
                ans = num;
            }
        }
        return ans;
    }

    @Test
    public void testCase1() {
        LeetCode6024 leetCode6024 = new LeetCode6024();
        assert leetCode6024.mostFrequent(new int[]{1, 100, 200, 1, 100}, 1) == 100;
    }

    @Test
    public void testCase2() {
        LeetCode6024 leetCode6024 = new LeetCode6024();
        assert leetCode6024.mostFrequent(new int[]{2, 2, 2, 2, 3}, 2) == 2;
    }
}
