package com.geekbing.middle;

/**
 * @author bing
 */
public class LeetCode931 {
    public int minFallingPathSum(int[][] A) {
        if (A.length == 0) {
            return 0;
        }
        // dp[i][j] 表示使用(i,j)时最小的下降路径和
        int[][] dp = new int[A.length][A[0].length];
        System.arraycopy(A[0], 0, dp[0], 0, A[0].length);
        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (j == 0) {
                    dp[i][j] = minOfArr(dp[i - 1][j], dp[i - 1][j + 1]) + A[i][j];
                } else if (j == A[0].length - 1) {
                    dp[i][j] = minOfArr(dp[i - 1][j - 1], dp[i - 1][j]) + A[i][j];
                } else {
                    dp[i][j] = minOfArr(dp[i - 1][j - 1], dp[i - 1][j], dp[i - 1][j + 1]) + A[i][j];
                }
            }
        }
        return minOfArr(dp[A.length - 1]);
    }

    private int minOfArr(int... nums) {
        int min = nums[0];
        for (int num : nums) {
            if (min > num) {
                min = num;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        LeetCode931 leetCode931 = new LeetCode931();
        int[][] case1 = new int[3][3];
        case1[0] = new int[]{1, 2, 3};
        case1[1] = new int[]{4, 5, 6};
        case1[2] = new int[]{7, 8, 9};
        System.out.println(leetCode931.minFallingPathSum(case1));
    }
}
