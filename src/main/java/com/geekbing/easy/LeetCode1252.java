package com.geekbing.easy;

import java.util.Arrays;

public class LeetCode1252 {
    public int oddCells(int n, int m, int[][] indices) {
        int[][] arr = new int[n][m];
        for (int[] index : indices) {
            for (int i = 0; i < m; i++) {
                arr[index[0]][i] += 1;
            }
            for (int i = 0; i < n; i++) {
                arr[i][index[1]] += 1;
            }
        }
        int ans = 0;
        for (int[] index : arr) {
            for (int num : index) {
                if (num % 2 == 1) {
                    ans++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode1252 leetCode1252 = new LeetCode1252();

        int[][] case1 = new int[2][2];
        case1[0] = new int[]{0, 1};
        case1[1] = new int[]{1, 1};
        System.out.println(leetCode1252.oddCells(2, 3, case1));

        int[][] case2 = new int[2][2];
        case2[0] = new int[]{1, 1};
        case2[1] = new int[]{0, 0};
        System.out.println(leetCode1252.oddCells(2, 2, case2));
    }
}
