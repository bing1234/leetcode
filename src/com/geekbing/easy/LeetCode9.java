package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode9 {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int old = x, sum = 0, temp;
        while (x != 0) {
            temp = x % 10;
            sum = sum * 10 + temp;
            x = x / 10;
        }
        return old == sum;
    }

    public static void main(String[] args) {
        LeetCode9 leetCode9 = new LeetCode9();

        System.out.println(leetCode9.isPalindrome(121));
        System.out.println(leetCode9.isPalindrome(-121));
        System.out.println(leetCode9.isPalindrome(10));
        System.out.println(leetCode9.isPalindrome(123));
    }
}
