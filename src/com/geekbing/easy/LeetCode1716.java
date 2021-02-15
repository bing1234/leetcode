package com.geekbing.easy;

public class LeetCode1716 {
    public int totalMoney(int n) {
        int a = n / 7;
        int b = n % 7;
        return (7 * a * a + 49 * a) / 2 + (2 * a + b + 1) * b / 2;
    }

    public static void main(String[] args) {
        LeetCode1716 leetCode1716 = new LeetCode1716();

        System.out.println(leetCode1716.totalMoney(4));
        System.out.println(leetCode1716.totalMoney(10));
        System.out.println(leetCode1716.totalMoney(20));
    }
}
