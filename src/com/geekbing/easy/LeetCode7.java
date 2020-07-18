package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode7 {
    public int reverse(int x) {
        long sum = 0;
        while (x != 0) {
            sum = sum * 10 + (x % 10);
            if (sum > Integer.MAX_VALUE || sum < Integer.MIN_VALUE) {
                return 0;
            }
            x = x / 10;
        }
        return (int) sum;
    }

    public static void main(String[] args) {
        LeetCode7 leetCode7 = new LeetCode7();
        System.out.println(leetCode7.reverse(123));
        System.out.println(leetCode7.reverse(-123));
        System.out.println(leetCode7.reverse(120));
        System.out.println(leetCode7.reverse(1534236469));
    }
}
