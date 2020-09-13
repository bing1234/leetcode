package com.geekbing.easy;

public class LeetCode1550 {
    public boolean threeConsecutiveOdds(int[] arr) {
        for (int i = 0; i < arr.length - 2; i++) {
            if (arr[i] % 2 == 0) {
                continue;
            }
            if (arr[i + 1] % 2 == 0) {
                i++;
                continue;
            }
            if (arr[i + 2] % 2 == 0) {
                i = i + 2;
                continue;
            }
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        LeetCode1550 leetCode1550 = new LeetCode1550();
        System.out.println(leetCode1550.threeConsecutiveOdds(new int[]{2, 6, 4, 1}));
        System.out.println(leetCode1550.threeConsecutiveOdds(new int[]{1, 2, 34, 3, 4, 5, 7, 23, 12}));
    }
}
