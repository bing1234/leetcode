package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode1137 {
    public int tribonacci(int n) {
        int[] arrs = new int[38];
        arrs[0] = 0;
        arrs[1] = 1;
        arrs[2] = 1;
        int i = 3;
        while (i <= n) {
            arrs[i] = arrs[i - 1] + arrs[i - 2] + arrs[i - 3];
            i++;
        }
        return arrs[n];
    }

    public static void main(String[] args) {
        LeetCode1137 leetCode1137 = new LeetCode1137();
        System.out.println(leetCode1137.tribonacci(4));
        System.out.println(leetCode1137.tribonacci(25));
    }
}
