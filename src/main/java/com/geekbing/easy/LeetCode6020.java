package com.geekbing.easy;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author bing
 */
public class LeetCode6020 {
    public boolean divideArray(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Integer num : map.values()) {
            if (num % 2 != 0) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void testCase1() {
        LeetCode6020 leetCode6020 = new LeetCode6020();
        assert leetCode6020.divideArray(new int[]{3, 2, 3, 2, 2, 2});
    }

    @Test
    public void testCase2() {
        LeetCode6020 leetCode6020 = new LeetCode6020();
        assert !leetCode6020.divideArray(new int[]{1, 2, 3, 4});
    }
}
