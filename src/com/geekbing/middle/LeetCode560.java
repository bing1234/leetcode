package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author bing
 */
public class LeetCode560 {
    public int subarraySum(int[] nums, int k) {
        int ans = 0, preSum = 0;
        // 前缀和-前缀和的数量
        // [...i] + [i...j] = [...j]
        // 令[i...j] = k, 则: [...j] - k = [...i]
        Map<Integer, Integer> preSumCount = new HashMap<>();
        preSumCount.put(0, 1);
        for (int num : nums) {
            preSum += num;
            ans += preSumCount.getOrDefault(preSum - k, 0);
            preSumCount.put(preSum, preSumCount.getOrDefault(preSum, 0) + 1);
        }
        return ans;
    }

    @Test
    public void testCase1() {
        LeetCode560 leetCode560 = new LeetCode560();
        assert leetCode560.subarraySum(new int[]{1, 1, 1}, 2) == 2;
    }

    @Test
    public void testCase2() {
        LeetCode560 leetCode560 = new LeetCode560();
        assert leetCode560.subarraySum(new int[]{1, 2, 3}, 3) == 2;
    }
}
