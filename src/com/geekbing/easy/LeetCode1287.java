package com.geekbing.easy;

public class LeetCode1287 {
    public int findSpecialInteger(int[] arr) {
        int skip = arr.length / 4;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == arr[i + skip]) {
                return arr[i];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        LeetCode1287 leetCode1287 = new LeetCode1287();
        System.out.println(leetCode1287.findSpecialInteger(new int[]{1, 2, 2, 6, 6, 6, 6, 7, 10}));
    }
}
