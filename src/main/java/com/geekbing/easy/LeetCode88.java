package com.geekbing.easy;

import java.util.Arrays;

/**
 * @author bing
 */
public class LeetCode88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i, index1 = m - 1, index2 = n - 1;
        for (i = m + n - 1; i >= 0 && index1 >= 0 && index2 >= 0; i--) {
            if (nums1[index1] < nums2[index2]) {
                nums1[i] = nums2[index2--];
            } else {
                nums1[i] = nums1[index1--];
            }
        }
        while (index2 >= 0) {
            nums1[i--] = nums2[index2--];
        }
    }

    public static void main(String[] args) {
        LeetCode88 leetCode88 = new LeetCode88();
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        leetCode88.merge(nums1, 3, new int[]{2, 5, 6}, 3);
        System.out.println(Arrays.toString(nums1));
    }
}
