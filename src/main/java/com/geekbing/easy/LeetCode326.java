package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode326 {
    public boolean isPowerOfThree(int n) {
        // 1162261467 是整数范围内，最大的3的幂
        return n > 0 && 1162261467 % n == 0;
    }

    public static void main(String[] args) {
        LeetCode326 leetCode326 = new LeetCode326();
        System.out.println(leetCode326.isPowerOfThree(27));
        System.out.println(leetCode326.isPowerOfThree(0));
        System.out.println(leetCode326.isPowerOfThree(9));
        System.out.println(leetCode326.isPowerOfThree(45));
    }
}
