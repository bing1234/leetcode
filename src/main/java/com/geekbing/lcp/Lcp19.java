package com.geekbing.lcp;

/**
 * @author bing
 */
public class Lcp19 {
    public int minimumOperations(String leaves) {
        // dp[i][0] 表示将leaves[0...i]的第i片叶子调整为左边的红色所需要的最少调整数
        // dp[i][0] = dp[i-1][0] + isYellow(leaves[i])
        // dp[i][1] 表示将leaves[0...i]的第i片叶子调整为中间的黄色所需要的最少调整数
        // dp[i][1] = Math.min(dp[i-1][0], dp[i-1][1]) + isRed(leaves[i])
        // dp[i][2] 表示将leaves[0...i]的第i片叶子调整为右边的红色所需要的最少调整数
        // dp[i][2] = Math.min(dp[i-1][1], dp[i-1][2]) + isYellow(leaves[i])
        int[][] dp = new int[leaves.length()][3];
        dp[0][0] = leaves.charAt(0) == 'y' ? 1 : 0;
        dp[0][1] = dp[0][2] = dp[1][2] = Integer.MAX_VALUE;
        for (int i = 1; i < leaves.length(); i++) {
            dp[i][0] = dp[i - 1][0] + (leaves.charAt(i) == 'y' ? 1 : 0);
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][1]) + (leaves.charAt(i) == 'r' ? 1 : 0);
            if (i >= 2) {
                dp[i][2] = Math.min(dp[i - 1][1], dp[i - 1][2]) + (leaves.charAt(i) == 'y' ? 1 : 0);
            }
        }
        return dp[leaves.length() - 1][2];
    }

    public static void main(String[] args) {
        Lcp19 lcp19 = new Lcp19();
        System.out.println(lcp19.minimumOperations("rrryyyrryyyrr"));
        System.out.println(lcp19.minimumOperations("ryr"));
        System.out.println(lcp19.minimumOperations("yry"));
    }
}
