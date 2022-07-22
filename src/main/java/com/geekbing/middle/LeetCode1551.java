package com.geekbing.middle;

public class LeetCode1551 {
    public int minOperations(int n) {
        return n % 2 == 0 ? n * n / 4 : n / 2 * (n / 2 + 1);
    }

    public static void main(String[] args) {
        LeetCode1551 leetCode1551 = new LeetCode1551();
        System.out.println(leetCode1551.minOperations(3));
        System.out.println(leetCode1551.minOperations(6));
    }
}
