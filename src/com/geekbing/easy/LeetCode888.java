package com.geekbing.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LeetCode888 {
    public int[] fairCandySwap(int[] A, int[] B) {
        int sumA = Arrays.stream(A).sum();
        int sumB = 0;
        Set<Integer> numB = new HashSet<>();
        for (int num : B) {
            numB.add(num);
            sumB += num;
        }
        int avg = (sumA + sumB) / 2;
        for (int num1 : A) {
            int num2 = avg + num1 - sumA;
            if (numB.contains(num2)) {
                return new int[]{num1, num2};
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        LeetCode888 leetCode888 = new LeetCode888();
        System.out.println(Arrays.toString(leetCode888.fairCandySwap(new int[]{1, 1}, new int[]{2, 2})));
        System.out.println(Arrays.toString(leetCode888.fairCandySwap(new int[]{1, 2}, new int[]{2, 3})));
        System.out.println(Arrays.toString(leetCode888.fairCandySwap(new int[]{2}, new int[]{1, 3})));
        System.out.println(Arrays.toString(leetCode888.fairCandySwap(new int[]{1, 2, 5}, new int[]{2, 4})));
    }
}
