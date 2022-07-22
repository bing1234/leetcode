package com.geekbing.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bing
 */
public class LeetCode1431 {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        for (int candy : candies) {
            if (candy >= max) {
                max = candy;
            }
        }
        List<Boolean> result = new ArrayList<>();
        for (int candy : candies) {
            if (candy + extraCandies >= max) {
                result.add(true);
            } else {
                result.add(false);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LeetCode1431 leetCode1431 = new LeetCode1431();
        System.out.println(leetCode1431.kidsWithCandies(new int[]{2, 3, 5, 1, 3}, 3));
        System.out.println(leetCode1431.kidsWithCandies(new int[]{4, 2, 1, 1, 2}, 1));
        System.out.println(leetCode1431.kidsWithCandies(new int[]{12, 1, 12}, 10));
    }
}
