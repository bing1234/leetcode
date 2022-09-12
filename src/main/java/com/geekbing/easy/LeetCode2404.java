package com.geekbing.easy;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author bing
 */
public class LeetCode2404 {
    public int mostFrequentEven(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int ans = -1, cnt = 0;
        for (int num : map.keySet()) {
            if (num % 2 != 0) {
                continue;
            }
            if (map.get(num) > cnt) {
                ans = num;
                cnt = map.get(num);
            } else if (map.get(num) == cnt) {
                ans = Math.min(ans, num);
            }
        }
        return ans;
    }

    @Test
    public void testCase1() {
        LeetCode2404 leetCode2404 = new LeetCode2404();
        assert leetCode2404.mostFrequentEven(new int[]{0, 1, 2, 2, 4, 4, 1}) == 2;
    }

    @Test
    public void testCase2() {
        LeetCode2404 leetCode2404 = new LeetCode2404();
        assert leetCode2404.mostFrequentEven(new int[]{4, 4, 4, 9, 2, 4}) == 4;
    }

    @Test
    public void testCase3() {
        LeetCode2404 leetCode2404 = new LeetCode2404();
        assert leetCode2404.mostFrequentEven(new int[]{29, 47, 21, 41, 13, 37, 25, 7}) == -1;
    }
}
