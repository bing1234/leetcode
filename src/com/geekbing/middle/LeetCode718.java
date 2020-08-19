package com.geekbing.middle;

/**
 * todo
 *
 * @author bing
 */
public class LeetCode718 {
    public int findLength(int[] A, int[] B) {
        // dp[i][j]表示以A中下标为i的元素结尾 与 B中下标为j的元素结尾的公共的、长度最长的子数组的长度
        int[][] dp = new int[A.length][B.length];
        for (int i = 0; i < A.length; i++) {
            dp[i][0] = A[i] == B[0] ? 1 : 0;
        }
        for (int j = 0; j < B.length; j++) {
            dp[0][j] = A[0] == B[j] ? 1 : 0;
        }
        int max = 0;
        for (int i = 1; i < A.length; i++) {
            for (int j = 1; j < B.length; j++) {
                if (A[i] == B[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = 0;
                }
                if (max < dp[i][j]) {
                    max = dp[i][j];
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LeetCode718 leetCode718 = new LeetCode718();
//        System.out.println(leetCode718.findLength(new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 4, 7}));
//        System.out.println(leetCode718.findLength(new int[]{0, 1, 1, 1, 1}, new int[]{1, 0, 1, 0, 1}));
        System.out.println(leetCode718.findLength(new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 4, 7}));
    }
}
