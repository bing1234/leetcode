package com.geekbing.easy;

public class LeetCode1588 {
    public int sumOddLengthSubarrays(int[] arr) {
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if ((j - i + 1) % 2 == 1) {
                    for (int k = i; k <= j; k++) {
                        ans += arr[k];
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode1588 leetCode1588 = new LeetCode1588();
        System.out.println(leetCode1588.sumOddLengthSubarrays(new int[]{1, 4, 2, 5, 3}));
        System.out.println(leetCode1588.sumOddLengthSubarrays(new int[]{1, 2}));
        System.out.println(leetCode1588.sumOddLengthSubarrays(new int[]{10, 11, 12}));
    }
}
