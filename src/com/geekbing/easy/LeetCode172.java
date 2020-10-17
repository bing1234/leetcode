package com.geekbing.easy;

/**
 * 172. 阶乘后的零
 * https://leetcode-cn.com/problems/factorial-trailing-zeroes/
 */
public class LeetCode172 {
    public int trailingZeroes(int n) {
        int ans = 0;
        int div = 5;
        while (div <= n) {
            ans += n / div;
            div *= 5;
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode172 leetCode172 = new LeetCode172();

        System.out.println(leetCode172.trailingZeroes(3));
        System.out.println(leetCode172.trailingZeroes(5));
    }
}
