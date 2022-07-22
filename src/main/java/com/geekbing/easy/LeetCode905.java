package com.geekbing.easy;

import java.util.Arrays;

/**
 * @author bing
 */
public class LeetCode905 {
    public int[] sortArrayByParity(int[] A) {
        int left = 0, right = A.length - 1, temp;
        while (left < right) {
            // left指向奇数
            while (left < right && A[left] % 2 == 0) {
                left++;
            }
            // right指向偶数
            while (left < right && A[right] % 2 == 1) {
                right--;
            }
            temp = A[left];
            A[left] = A[right];
            A[right] = temp;

            left++;
            right--;
        }
        return A;
    }

    public static void main(String[] args) {
        LeetCode905 leetCode905 = new LeetCode905();
        System.out.println(Arrays.toString(leetCode905.sortArrayByParity(new int[]{3, 1, 2, 4})));
        System.out.println(Arrays.toString(leetCode905.sortArrayByParity(new int[]{0, 2})));
    }
}
