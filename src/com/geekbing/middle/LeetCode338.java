package com.geekbing.middle;

import java.util.Arrays;

public class LeetCode338 {
    public int[] countBits(int num) {
        // dp[i] 表示数字i的二进制数中1的个数
        int[] dp = new int[num + 1];
        dp[0] = 0;
        for (int i = 1; i <= num; i++) {
            if (i % 2 == 1) {
                // 如果i是奇数，则i-1为偶数，偶数的二进制形式的最后一位为0，故dp[i]=dp[i-1]+1;
                dp[i] = dp[i - 1] + 1;
            } else {
                // 如果i是偶数，偶数的二进制形式的最后一位为0，故dp[i] = dp[i/2];
                dp[i] = dp[i / 2];
            }
        }
        return dp;
    }

    public static void main(String[] args) {
        LeetCode338 leetCode338 = new LeetCode338();
        System.out.println(Arrays.toString(leetCode338.countBits(2)));
        System.out.println(Arrays.toString(leetCode338.countBits(5)));
    }
}
