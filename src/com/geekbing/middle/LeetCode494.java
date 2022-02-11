package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author bing
 */
public class LeetCode494 {
    public int findTargetSumWays(int[] nums, int target) {
        // dp[i][j]表示nums[0...i]的数组合起来结果为j的数量, dp[nums.length - 1][target]
        // dp[i+1][j] = dp[i][j - nums[i+1]] + dp[i][j + nums[i+1]]
        Map<String, Integer> dp = new HashMap<>();
        if (nums[0] == 0) {
            dp.put("0,0", 2);
        } else {
            dp.put("0," + nums[0], 1);
            dp.put("0,-" + nums[0], 1);
        }
        int total = nums[0];
        for (int i = 1; i < nums.length; i++) {
            total += Math.abs(nums[i]);
            for (int j = -total; j <= total; j++) {
                dp.put(i + "," + j, dp.getOrDefault((i - 1) + "," + (j - nums[i]), 0) + dp.getOrDefault((i - 1) + "," + (j + nums[i]), 0));
            }
        }
        return dp.getOrDefault((nums.length - 1) + "," + target, 0);
    }

    @Test
    public void testCase1() {
        LeetCode494 leetCode494 = new LeetCode494();
        assert leetCode494.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3) == 5;
    }

    @Test
    public void testCase2() {
        LeetCode494 leetCode494 = new LeetCode494();
        assert leetCode494.findTargetSumWays(new int[]{1}, 1) == 1;
    }

    @Test
    public void testCase3() {
        LeetCode494 leetCode494 = new LeetCode494();
        assert leetCode494.findTargetSumWays(new int[]{1}, 2) == 0;
    }
}
