package com.geekbing.easy;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author bing
 */
public class LeetCode1426 {
    public int countElements(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int ans = 0;
        for (int key : map.keySet()) {
            if (map.containsKey(key + 1)) {
                ans += map.get(key);
            }
        }
        return ans;
    }

    @Test
    public void testCase1() {
        LeetCode1426 leetCode1426 = new LeetCode1426();
        assert leetCode1426.countElements(new int[]{1, 2, 3}) == 2;
    }

    @Test
    public void testCase2() {
        LeetCode1426 leetCode1426 = new LeetCode1426();
        assert leetCode1426.countElements(new int[]{1, 1, 3, 3, 5, 5, 7, 7}) == 0;
    }

    @Test
    public void testCase3() {
        LeetCode1426 leetCode1426 = new LeetCode1426();
        assert leetCode1426.countElements(new int[]{1, 1, 2}) == 2;
    }

}
