package com.geekbing.easy;

/**
 * 746. 使用最小花费爬楼梯
 * https://leetcode-cn.com/problems/min-cost-climbing-stairs/
 *
 * @author bing
 */
public class LeetCode746 {
    public int minCostClimbingStairs(int[] cost) {
        if (cost.length == 2) {
            return 0;
        }
        // dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        int[] dp = new int[cost.length + 1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= cost.length; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[cost.length];
    }

    public static void main(String[] args) {
        LeetCode746 leetCode746 = new LeetCode746();
        System.out.println(leetCode746.minCostClimbingStairs(new int[]{10, 15, 20}));
        System.out.println(leetCode746.minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }
}
