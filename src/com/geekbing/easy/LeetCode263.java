package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode263 {
    public boolean isUgly(int num) {
        if (num < 1) {
            return false;
        }
        while (num % 5 == 0) {
            num = num / 5;
        }
        while (num % 3 == 0) {
            num = num / 3;
        }
        while (num % 2 == 0) {
            num = num / 2;
        }
        return num == 1;
    }

    public static void main(String[] args) {
        LeetCode263 leetCode263 = new LeetCode263();
        System.out.println(leetCode263.isUgly(6));
        System.out.println(leetCode263.isUgly(8));
        System.out.println(leetCode263.isUgly(14));
    }
}
