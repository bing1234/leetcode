package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode292 {
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }

    public static void main(String[] args) {
        LeetCode292 leetCode292 = new LeetCode292();
        System.out.println(leetCode292.canWinNim(4));
    }
}
