package com.geekbing.easy;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/duplicate-zeros/
 * 1089. 复写零
 * todo
 * @author bing
 */
public class LeetCode1089 {
    public void duplicateZeros(int[] arr) {
        int zeroCount = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                if (i + zeroCount >= arr.length) {
                    break;
                } else {
                    zeroCount++;
                }
            }
        }
        int i = arr.length - 1 - zeroCount;
        int current = arr.length - 1;
        if (arr[arr.length - 1 - zeroCount] == 0) {
            arr[current--] = 0;
            zeroCount--;
            i = arr.length - 2;
        }
        while (i >= 0) {
            if (zeroCount == 0) {
                return;
            }
            if (arr[i] == 0) {
                arr[current--] = 0;
                arr[current--] = 0;
                zeroCount--;
            } else {
                arr[current--] = arr[i];
            }
            i--;
        }
    }

    public static void main(String[] args) {
        LeetCode1089 leetCode1089 = new LeetCode1089();

//        int[] arr1 = new int[]{1, 0, 2, 3, 0, 4, 5, 0};
//        leetCode1089.duplicateZeros(arr1);
//        System.out.println(Arrays.toString(arr1));
//
//        int[] arr2 = new int[]{1, 2, 3};
//        leetCode1089.duplicateZeros(arr2);
//        System.out.println(Arrays.toString(arr2));
//
//        int[] arr3 = new int[]{8, 4, 5, 0, 0, 0, 0, 7};
//        leetCode1089.duplicateZeros(arr3);
//        System.out.println(Arrays.toString(arr3));
//
//        int[] arr4 = new int[]{0, 1, 7, 6, 0, 2, 0, 7};
//        leetCode1089.duplicateZeros(arr4);
//        System.out.println(Arrays.toString(arr4));

        int[] arr5 = new int[]{1, 5, 2, 0, 6, 8, 0, 6, 0};
        leetCode1089.duplicateZeros(arr5);
        System.out.println(Arrays.toString(arr5));
    }
}
