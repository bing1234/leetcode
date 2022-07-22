package com.geekbing.easy;

import java.util.Arrays;

/**
 * @author bing
 */
public class LeetCode832 {
    public int[][] flipAndInvertImage(int[][] A) {
        int low, high, temp;
        for (int i = 0; i < A.length; i++) {
            low = 0;
            high = A[i].length - 1;
            while (low < high) {
                temp = A[i][low];
                A[i][low] = A[i][high] ^ 1;
                A[i][high] = temp ^ 1;

                low++;
                high--;
            }
            if (low == high) {
                A[i][low] = A[i][high] ^ 1;
            }
        }
        return A;
    }

    public static void main(String[] args) {
        LeetCode832 leetCode832 = new LeetCode832();
        int[][] result1 = leetCode832.flipAndInvertImage(new int[][]{{1, 1, 0}, {1, 0, 1}, {0, 0, 0}});
        print(result1);

        int[][] result2 = leetCode832.flipAndInvertImage(new int[][]{{1, 1, 0, 0}, {1, 0, 0, 1}, {0, 1, 1, 1}, {1, 0, 1, 0}});
        print(result2);
    }

    private static void print(int[][] arrs) {
        for (int[] arr : arrs) {
            System.out.println(Arrays.toString(arr));
        }
    }
}
