package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode70 {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        int minus2 = 1;
        int minus1 = 2;
        int current = 0;
        int i = 3;
        while (i <= n) {
            current = minus1 + minus2;
            minus2 = minus1;
            minus1 = current;
            i++;
        }
        return current;
    }

    public static void main(String[] args) {
        LeetCode70 leetCode70 = new LeetCode70();
        System.out.println(leetCode70.climbStairs(2));
        System.out.println(leetCode70.climbStairs(3));
    }
}
