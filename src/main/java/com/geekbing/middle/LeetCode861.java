package com.geekbing.middle;

public class LeetCode861 {
    public int matrixScore(int[][] A) {
        int row = A.length, col = A[0].length;
        // 先处理行，将最左边不是1的行翻转一下
        for (int i = 0; i < row; i++) {
            if (A[i][0] == 0) {
                for (int j = 0; j < col; j++) {
                    A[i][j] = 1 ^ A[i][j];
                }
            }
        }
        // 处理列。从第二列开始，反转0多的列
        for (int i = 1; i < col; i++) {
            int count = 0;
            for (int[] nums : A) {
                if (nums[i] == 0) {
                    count++;
                }
            }
            if (count * 2 > row) {
                // 0多的列，反转该列
                for (int[] nums : A) {
                    nums[i] = 1 ^ nums[i];
                }
            }
        }
        int ans = 0, base;
        for (int[] nums : A) {
            base = 1;
            for (int j = col - 1; j >= 0; j--) {
                ans += nums[j] * base;
                base = base * 2;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode861 leetCode861 = new LeetCode861();
        System.out.println(leetCode861.matrixScore(new int[][]{{0, 0, 1, 1}, {1, 0, 1, 0}, {1, 1, 0, 0}}));
    }
}
