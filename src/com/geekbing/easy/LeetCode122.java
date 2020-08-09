package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode122 {
    public int maxProfit(int[] prices) {
        // 峰底、峰顶
        int max = 0, i = 0, low, high;
        while (i < prices.length - 1) {
            while (i < prices.length - 1 && prices[i] >= prices[i + 1]) {
                i++;
            }
            low = prices[i];
            while (i < prices.length - 1 && prices[i] <= prices[i + 1]) {
                i++;
            }
            high = prices[i];
            max = high - low + max;
        }
        return max;
    }

    public static void main(String[] args) {
        LeetCode122 leetCode122 = new LeetCode122();
        System.out.println(leetCode122.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(leetCode122.maxProfit(new int[]{1, 2, 3, 4, 5}));
        System.out.println(leetCode122.maxProfit(new int[]{7, 6, 4, 3, 1}));
    }
}
