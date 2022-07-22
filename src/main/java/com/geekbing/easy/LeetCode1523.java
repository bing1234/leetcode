package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode1523 {
    public int countOdds(int low, int high) {
        return countOdds(high) - countOdds(low - 1);
    }

    private int countOdds(int num) {
        if (num < 0) {
            return 0;
        }
        return num % 2 == 0 ? num / 2 : num / 2 + 1;
    }

    public static void main(String[] args) {
        LeetCode1523 leetCode1523 = new LeetCode1523();
        System.out.println(leetCode1523.countOdds(3, 7));
        System.out.println(leetCode1523.countOdds(8, 10));
        System.out.println(leetCode1523.countOdds(0, 10));
    }
}
