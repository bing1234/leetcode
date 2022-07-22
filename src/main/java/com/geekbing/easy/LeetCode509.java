package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode509 {
    public int fib(int N) {
        int[] f = new int[31];
        f[0] = 0;
        f[1] = 1;
        for (int i = 2; i <= N; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[N];
    }

    public static void main(String[] args) {
        LeetCode509 leetCode509 = new LeetCode509();
        System.out.println(leetCode509.fib(2));
        System.out.println(leetCode509.fib(3));
        System.out.println(leetCode509.fib(4));
        System.out.println(leetCode509.fib(30));
    }
}
