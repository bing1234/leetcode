package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode1512 {
    public int numIdenticalPairs(int[] nums) {
        int[] counts = new int[101];
        for (int num : nums) {
            counts[num]++;
        }
        int result = 0;
        for (int i = 0; i < 101; i++) {
            result = result + counts[i] * (counts[i] - 1) / 2;
        }
        return result;
    }

    public static void main(String[] args) {
        LeetCode1512 leetCode1512 = new LeetCode1512();
        System.out.println(leetCode1512.numIdenticalPairs(new int[]{1, 2, 3, 1, 1, 3}));
        System.out.println(leetCode1512.numIdenticalPairs(new int[]{1, 1, 1, 1}));
        System.out.println(leetCode1512.numIdenticalPairs(new int[]{1, 2, 3}));
    }
}
