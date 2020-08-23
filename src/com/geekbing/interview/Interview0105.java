package com.geekbing.interview;

import java.util.Arrays;

/**
 * @author bing
 */
public class Interview0105 {
    public boolean oneEditAway(String first, String second) {
        if (first == null || "".equals(first)) {
            return second == null || second.length() < 2;
        }
        if (second == null || "".equals(second)) {
            return first.length() < 2;
        }
        // dp[i][j] 表示first的前i个字符编辑得到second的前j个字符所需的最少次数
        int[][] dp = new int[first.length()][second.length()];
        dp[0][0] = first.charAt(0) == second.charAt(0) ? 0 : 1;
        for (int i = 1; i < first.length(); i++) {
            dp[i][0] = first.charAt(i) == second.charAt(0) ? i : dp[i - 1][0] + 1;
        }
        for (int j = 1; j < second.length(); j++) {
            dp[0][j] = first.charAt(0) == second.charAt(j) ? j : dp[0][j - 1] + 1;
        }
        for (int i = 1; i < first.length(); i++) {
            for (int j = 1; j < second.length(); j++) {
                if (first.charAt(i) == second.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
            }
        }
        for (int[] arr : dp) {
            System.out.println(Arrays.toString(arr));
        }
        return dp[first.length() - 1][second.length() - 1] <= 1;
    }

    public static void main(String[] args) {
        Interview0105 interview0105 = new Interview0105();

        System.out.println(interview0105.oneEditAway("a", "ab"));
        System.out.println(interview0105.oneEditAway("ab", "bc"));
        System.out.println(interview0105.oneEditAway("pale", "ple"));
        System.out.println(interview0105.oneEditAway("pales", "pal"));
        System.out.println(interview0105.oneEditAway("teacher", "teached"));
    }
}
