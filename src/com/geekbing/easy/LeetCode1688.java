package com.geekbing.easy;

public class LeetCode1688 {
    public int numberOfMatches(int n) {
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        if (n % 2 == 0) {
            return n / 2 + numberOfMatches(n / 2);
        } else {
            return (n - 1) / 2 + numberOfMatches((n - 1) / 2 + 1);
        }
    }

    public static void main(String[] args) {
        LeetCode1688 leetCode1688 = new LeetCode1688();
        System.out.println(leetCode1688.numberOfMatches(7));
        System.out.println(leetCode1688.numberOfMatches(14));
    }
}
