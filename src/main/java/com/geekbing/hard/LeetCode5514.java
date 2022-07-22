package com.geekbing.hard;

/**
 * todo
 */
public class LeetCode5514 {
    public boolean isTransformable(String s, String t) {
        // dp[i][j] 表示 s[0,i] 能否 转变为 t[0,j]
        int[][] dp = new int[s.length()][t.length()];

        return false;
    }

    public static void main(String[] args) {
        LeetCode5514 leetCode5514 = new LeetCode5514();
        System.out.println(leetCode5514.isTransformable("84532", "34852"));
    }
}
