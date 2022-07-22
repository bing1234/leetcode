package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode896 {
    public boolean isMonotonic(int[] A) {
        int pre = A[0];
        // -1 递减、0：相等、1：递增
        int flag = 0;
        for (int num : A) {
            if (num > pre) {
                if (flag == -1) {
                    return false;
                }
                flag = 1;
            } else if (num < pre) {
                if (flag == 1) {
                    return false;
                }
                flag = -1;
            }
            pre = num;
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode896 leetCode896 = new LeetCode896();
        System.out.println(leetCode896.isMonotonic(new int[]{1, 2, 2, 3}));
        System.out.println(leetCode896.isMonotonic(new int[]{6, 5, 4, 4}));
        System.out.println(leetCode896.isMonotonic(new int[]{1, 3, 2}));
        System.out.println(leetCode896.isMonotonic(new int[]{1, 2, 4, 5}));
        System.out.println(leetCode896.isMonotonic(new int[]{1, 1, 1}));
    }
}
