package com.geekbing.middle;

import java.util.Arrays;

/**
 * @author bing
 */
public class LeetCode59 {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int left = 0, right = n - 1, up = 0, down = n - 1;

        int i = 0, j = 0, cnt = 1, total = n * n;
        while (cnt <= total) {
            // 右
            while (cnt <= total && j <= right) {
                ans[i][j] = cnt++;
                j++;
            }
            j--;
            i++;
            up++;

            // 下
            while (cnt <= total && i <= down) {
                ans[i][j] = cnt++;
                i++;
            }
            i--;
            j--;
            right--;

            // 左
            while (cnt <= total && j >= left) {
                ans[i][j] = cnt++;
                j--;
            }
            j++;
            i--;
            down--;

            // 上
            while (cnt <= total && i >= up) {
                ans[i][j] = cnt++;
                i--;
            }
            i++;
            j++;
            left++;
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode59 leetCode59 = new LeetCode59();
        System.out.println(Arrays.deepToString(leetCode59.generateMatrix(1)));
        System.out.println(Arrays.deepToString(leetCode59.generateMatrix(2)));
        System.out.println(Arrays.deepToString(leetCode59.generateMatrix(3)));
        System.out.println(Arrays.deepToString(leetCode59.generateMatrix(4)));
    }
}
