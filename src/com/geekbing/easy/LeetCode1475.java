package com.geekbing.easy;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/final-prices-with-a-special-discount-in-a-shop/
 * 1475. 商品折扣后的最终价格
 *
 * @author bing
 */
public class LeetCode1475 {
    public int[] finalPrices(int[] prices) {
        int[] ans = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            ans[i] = prices[i];
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] <= prices[i]) {
                    ans[i] -= prices[j];
                    break;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode1475 leetCode1475 = new LeetCode1475();
        System.out.println(Arrays.toString(leetCode1475.finalPrices(new int[]{8, 4, 6, 2, 3})));
        System.out.println(Arrays.toString(leetCode1475.finalPrices(new int[]{1, 2, 3, 4, 5})));
        System.out.println(Arrays.toString(leetCode1475.finalPrices(new int[]{10, 1, 1, 6})));
    }
}
