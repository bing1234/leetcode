package com.geekbing.easy;

/**
 * todo 优化性能
 * @author bing
 */
public class LeetCode441 {
    public int arrangeCoins(int n) {
        long sum = 0;
        for (int i = 1; i <= n; i++) {
            sum = sum + i;
            if (sum == n) {
                return i;
            }
            if (sum > n) {
                return i - 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        LeetCode441 leetCode441 = new LeetCode441();
        System.out.println(leetCode441.arrangeCoins(5));
        System.out.println(leetCode441.arrangeCoins(8));
        System.out.println(leetCode441.arrangeCoins(2147483647));
    }
}
