package com.geekbing.middle;

import java.util.Arrays;

public class LeetCode1561 {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int ans = 0;
        for (int i = piles.length - 2; i > piles.length / 3 -1; i -= 2) {
            ans += piles[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode1561 leetCode1561 = new LeetCode1561();
        System.out.println(leetCode1561.maxCoins(new int[]{2, 4, 1, 2, 7, 8}));
        System.out.println(leetCode1561.maxCoins(new int[]{2, 4, 5}));
        System.out.println(leetCode1561.maxCoins(new int[]{9, 8, 7, 6, 5, 1, 2, 3, 4}));
    }
}
