package com.geekbing.middle;

/**
 * https://leetcode-cn.com/problems/last-moment-before-all-ants-fall-out-of-a-plank/
 * 1503. 所有蚂蚁掉下来前的最后一刻
 *
 * @author bing
 */
public class LeetCode1503 {
    public int getLastMoment(int n, int[] left, int[] right) {
        int ans = 0;
        for (int num : left) {
            if (ans < num) {
                ans = num;
            }
        }
        for (int num : right) {
            if (ans < n - num) {
                ans = n - num;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode1503 leetCode1503 = new LeetCode1503();
        System.out.println(leetCode1503.getLastMoment(4, new int[]{4, 3}, new int[]{0, 1}));
        System.out.println(leetCode1503.getLastMoment(7, new int[]{}, new int[]{0, 1, 2, 3, 4, 5, 6, 7}));
        System.out.println(leetCode1503.getLastMoment(7, new int[]{0, 1, 2, 3, 4, 5, 6, 7}, new int[]{}));
        System.out.println(leetCode1503.getLastMoment(9, new int[]{5}, new int[]{4}));
        System.out.println(leetCode1503.getLastMoment(6, new int[]{6}, new int[]{0}));
    }
}
