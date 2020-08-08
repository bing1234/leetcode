package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode367 {
    public boolean isPerfectSquare(int num) {
        int low = 1, high = num, middle;
        long temp;
        while (low < high) {
            middle = low + (high - low) / 2;
            temp = (long) middle * (long) middle;
            if (temp > num) {
                high = middle - 1;
            } else if (temp == num) {
                return true;
            } else {
                low = middle + 1;
            }
        }
        return low * low == num || high * high == num;
    }

    public static void main(String[] args) {
        LeetCode367 leetCode367 = new LeetCode367();
        System.out.println(leetCode367.isPerfectSquare(16));
        System.out.println(leetCode367.isPerfectSquare(14));
        System.out.println(leetCode367.isPerfectSquare(808201));
    }
}
