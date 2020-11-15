package com.geekbing.easy;

import java.util.Arrays;

public class LeetCode5550 {
    public int[] decrypt(int[] code, int k) {
        int[] ans = new int[code.length];
        if (k < 0) {
            for (int i = 0; i < code.length; i++) {
                int sum = 0;
                int idx = i - 1;
                for (int j = 0; j < Math.abs(k); j++) {
                    if (idx < 0) {
                        idx = code.length - 1;
                    }
                    sum += code[idx];
                    idx--;
                }
                ans[i] = sum;
            }
        } else if (k > 0) {
            for (int i = 0; i < code.length; i++) {
                int sum = 0;
                int idx = i + 1;
                for (int j = 0; j < k; j++) {
                    if (idx >= code.length) {
                        idx = 0;
                    }
                    sum += code[idx];
                    idx++;
                }
                ans[i] = sum;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode5550 leetCode5550 = new LeetCode5550();
        System.out.println(Arrays.toString(leetCode5550.decrypt(new int[]{5, 7, 1, 4}, 3)));
        System.out.println(Arrays.toString(leetCode5550.decrypt(new int[]{1, 2, 3, 4}, 0)));
        System.out.println(Arrays.toString(leetCode5550.decrypt(new int[]{2, 4, 9, 3}, -2)));
    }
}
