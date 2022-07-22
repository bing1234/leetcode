package com.geekbing.offer;

/**
 * @author bing
 */
public class Offer63 {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int min = prices[0];
        int maxProfit = 0;
        for (int price : prices) {
            if (price < min) {
                min = price;
            }
            if (price - min > maxProfit) {
                maxProfit = price - min;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        Offer63 offer63 = new Offer63();
        System.out.println(offer63.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(offer63.maxProfit(new int[]{7, 6, 4, 3, 1}));
    }
}
