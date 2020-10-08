package com.geekbing.easy;

import java.util.Arrays;

public class LeetCode942 {
    public int[] diStringMatch(String S) {
        int remainMin = 0, remainMax = S.length();
        int[] ans = new int[S.length() + 1];
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == 'I') {
                ans[i] = remainMin;
                remainMin++;
            } else {
                ans[i] = remainMax;
                remainMax--;
            }
        }
        ans[S.length()] = remainMin;
        return ans;
    }

    public static void main(String[] args) {
        LeetCode942 leetCode942 = new LeetCode942();
        System.out.println(Arrays.toString(leetCode942.diStringMatch("IDID")));
        System.out.println(Arrays.toString(leetCode942.diStringMatch("III")));
        System.out.println(Arrays.toString(leetCode942.diStringMatch("DDI")));
    }
}
