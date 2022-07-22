package com.geekbing.easy;

import java.util.Arrays;

public class LeetCode1720 {
    public int[] decode(int[] encoded, int first) {
        int[] ans = new int[encoded.length + 1];
        ans[0] = first;

        int cur = first;
        for (int i = 0; i < encoded.length; i++) {
            cur = cur ^ encoded[i];
            ans[i + 1] = cur;
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode1720 leetCode1720 = new LeetCode1720();
        System.out.println(Arrays.toString(leetCode1720.decode(new int[]{1, 2, 3}, 1)));
        System.out.println(Arrays.toString(leetCode1720.decode(new int[]{6, 2, 7, 3}, 4)));
    }
}
