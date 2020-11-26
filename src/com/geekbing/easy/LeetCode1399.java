package com.geekbing.easy;

public class LeetCode1399 {
    public int countLargestGroup(int n) {
        int[] counts = new int[36];
        for (int i = 1; i <= n; i++) {
            counts[calBitSum(i)]++;
        }
        int max = Integer.MIN_VALUE, count = 0;
        for (int num : counts) {
            if (num == 0) {
                continue;
            }
            if (max < num) {
                max = num;
                count = 1;
            } else if (num == max) {
                count++;
            }
        }
        return count;
    }

    private int calBitSum(int num) {
        int sum = 0;
        for (char c : String.valueOf(num).toCharArray()) {
            sum += Integer.parseInt(String.valueOf(c));
        }
        return sum;
    }

    public static void main(String[] args) {
        LeetCode1399 leetCode1399 = new LeetCode1399();
        System.out.println(leetCode1399.countLargestGroup(13));
        System.out.println(leetCode1399.countLargestGroup(2));
        System.out.println(leetCode1399.countLargestGroup(15));
        System.out.println(leetCode1399.countLargestGroup(24));
    }
}
