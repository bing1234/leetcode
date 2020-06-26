package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode121 {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        // 当前为止最小价格、最大收益
        int min = prices[0], max = 0;
        // 当前的收益
        int currentProfit;

        for (int price : prices) {
            if (price < min) {
                min = price;
            }
            currentProfit = price - min;
            if (currentProfit > max) {
                max = currentProfit;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LeetCode121 leetCode121 = new LeetCode121();
        System.out.println(leetCode121.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(leetCode121.maxProfit(new int[]{7, 6, 4, 3, 1}));
    }
}
