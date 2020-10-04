package com.geekbing.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode821 {
    public int[] shortestToChar(String S, char C) {
        int[] ans = new int[S.length()];
        List<Integer> idxs = new ArrayList<>();
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == C) {
                idxs.add(i);
            }
        }
        for (int i = 0; i < S.length(); i++) {
            int min = Integer.MAX_VALUE;
            for (int idx : idxs) {
                if (min > Math.abs(idx - i)) {
                    min = Math.abs(idx - i);
                }
            }
            ans[i] = min;
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode821 leetCode821 = new LeetCode821();
        System.out.println(Arrays.toString(leetCode821.shortestToChar("loveleetcode", 'e')));
    }
}
