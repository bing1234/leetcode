package com.geekbing.easy;

public class LeetCode1539 {
    public int findKthPositive(int[] arr, int k) {
        int arrIdx = 0, idx = 1, misCount = 0;
        while (misCount < k) {
            if (arrIdx < arr.length) {
                if (arr[arrIdx] < idx) {
                    arrIdx++;
                } else if (arr[arrIdx] == idx) {
                    arrIdx++;
                    idx++;
                } else {
                    idx++;
                    misCount++;
                }
            } else {
                idx++;
                misCount++;
            }
        }
        return idx - 1;
    }

    public static void main(String[] args) {
        LeetCode1539 leetCode1539 = new LeetCode1539();
        System.out.println(leetCode1539.findKthPositive(new int[]{2, 3, 4, 7, 11}, 5));
        System.out.println(leetCode1539.findKthPositive(new int[]{1, 2, 3, 4}, 2));
    }
}
