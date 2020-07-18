package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode342 {
    public boolean isPowerOfFour(int num) {
        if (num < 1) {
            return false;
        }
        while (true) {
            if (num % 4 == 0) {
                num = num / 4;
            } else {
                return num == 1;
            }
        }
    }

    public static void main(String[] args) {
        LeetCode342 leetCode342 = new LeetCode342();
        System.out.println(leetCode342.isPowerOfFour(16));
        System.out.println(leetCode342.isPowerOfFour(5));
    }
}
