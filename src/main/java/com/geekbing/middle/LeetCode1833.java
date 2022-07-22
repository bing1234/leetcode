package com.geekbing.middle;

import java.util.Arrays;

/**
 * @author bing
 */
public class LeetCode1833 {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int total = 0, ans = 0;
        for (int cost : costs) {
            total += cost;
            if (total > coins) {
                return ans;
            }
            ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode1833 leetCode1833 = new LeetCode1833();
        System.out.println(leetCode1833.maxIceCream(new int[]{1, 3, 2, 4, 1}, 7));
        System.out.println(leetCode1833.maxIceCream(new int[]{10, 6, 8, 7, 7, 8}, 5));
        System.out.println(leetCode1833.maxIceCream(new int[]{1, 6, 3, 1, 2, 5}, 20));
    }
}
