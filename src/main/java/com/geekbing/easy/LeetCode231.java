package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode231 {
    public boolean isPowerOfTwo(int n) {
        if (n < 1) {
            return false;
        }
        while (true) {
            if (n % 2 == 0) {
                n = n / 2;
            } else {
                return n == 1;
            }
        }
    }

    public boolean isPowerOfTwoV2(int n) {
        if (n < 1) {
            return false;
        }
        return (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        LeetCode231 leetCode231 = new LeetCode231();
        System.out.println(leetCode231.isPowerOfTwo(1));
        System.out.println(leetCode231.isPowerOfTwo(16));
        System.out.println(leetCode231.isPowerOfTwo(218));
    }
}
