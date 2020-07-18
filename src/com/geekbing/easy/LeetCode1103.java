package com.geekbing.easy;

import java.util.Arrays;

/**
 * @author bing
 */
public class LeetCode1103 {
    public int[] distributeCandies(int candies, int num_people) {
        int[] result = new int[num_people];
        int currentShould = 1;
        int index = 0;
        while (candies > 0) {
            if (candies < currentShould) {
                result[index] = result[index] + candies;
                break;
            } else {
                result[index] = result[index] + currentShould;
                candies = candies - currentShould;
            }
            index++;
            currentShould++;
            if (index % num_people == 0) {
                index = 0;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LeetCode1103 leetCode1103 = new LeetCode1103();
        System.out.println(Arrays.toString(leetCode1103.distributeCandies(7, 4)));
        System.out.println(Arrays.toString(leetCode1103.distributeCandies(10, 3)));
    }
}
