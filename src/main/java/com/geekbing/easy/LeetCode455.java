package com.geekbing.easy;

import java.util.Arrays;

public class LeetCode455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0, j = 0, ans = 0;
        while (i < g.length && j < s.length) {
            if (s[j] >= g[i]) {
                ans++;
                i++;
            }
            j++;
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode455 leetCode455 = new LeetCode455();
        System.out.println(leetCode455.findContentChildren(new int[]{1, 2, 3}, new int[]{1, 1}));
        System.out.println(leetCode455.findContentChildren(new int[]{1, 2}, new int[]{1, 2, 3}));
    }
}
