package com.geekbing.easy;

public class LeetCode1534 {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (Math.abs(arr[i] - arr[j]) > a) {
                    continue;
                }
                for (int k = j + 1; k < arr.length; k++) {
                    if (Math.abs(arr[j] - arr[k]) <= b && Math.abs(arr[i] - arr[k]) <= c) {
                        res++;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode1534 leetCode1534 = new LeetCode1534();
        System.out.println(leetCode1534.countGoodTriplets(new int[]{3, 0, 1, 1, 9, 7}, 7, 2, 3));
        System.out.println(leetCode1534.countGoodTriplets(new int[]{1, 1, 2, 2, 3}, 0, 0, 1));
    }
}
