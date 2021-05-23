package com.geekbing.lcp;

import java.util.Arrays;

/**
 * @author bing
 */
public class Lcp18 {
    public int breakfastNumber(int[] staple, int[] drinks, int x) {
        Arrays.sort(staple);
        Arrays.sort(drinks);
        long ans = 0L;
        int left = 0, right = drinks.length - 1;
        while (left < staple.length && right >= 0) {
            if (staple[left] + drinks[right] > x) {
                right--;
            } else {
                ans += right + 1;
                left++;
            }
        }
        return (int) (ans % 1000000007);
    }

    public static void main(String[] args) {
        Lcp18 lcp18 = new Lcp18();
        System.out.println(lcp18.breakfastNumber(new int[]{10, 20, 5}, new int[]{5, 5, 2}, 15));
        System.out.println(lcp18.breakfastNumber(new int[]{2, 1, 1}, new int[]{8, 9, 5, 1}, 9));
    }
}
