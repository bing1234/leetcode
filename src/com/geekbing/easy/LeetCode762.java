package com.geekbing.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LeetCode762 {
    public int countPrimeSetBits(int L, int R) {
        Set<Integer> set = new HashSet<>(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19));
        int ans = 0;
        for (int i = L; i <= R; i++) {
            if (set.contains(countNum(i))) {
                ans++;
            }
        }
        return ans;
    }

    private int countNum(int num) {
        int ans = 0;
        while (num > 0) {
            if ((num & 1) == 1) {
                ans++;
            }
            num = num >> 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode762 leetCode762 = new LeetCode762();
        System.out.println(leetCode762.countPrimeSetBits(6, 10));
        System.out.println(leetCode762.countPrimeSetBits(10, 15));
    }
}
