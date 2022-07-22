package com.geekbing.hard;

import org.junit.jupiter.api.Test;

/**
 * todo
 *
 * @author bing
 */
public class LeetCode407 {
    public int trapRainWater(int[][] heightMap) {
        int row = heightMap.length, col = heightMap[0].length;
        int[][] left = new int[row][col], right = new int[row][col], up = new int[row][col], down = new int[row][col];
        for (int i = 0; i < row; i++) {
            left[i] = buildLeft(heightMap[i]);
            right[i] = buildRight(heightMap[i]);
        }
        for (int j = 0; j < col; j++) {
            int[] arr = new int[row];
            for (int i = 0; i < row; i++) {
                arr[i] = heightMap[i][j];
            }
            int[] temp = buildLeft(arr);
            for (int i = 0; i < row; i++) {
                up[i][j] = temp[i];
            }
            temp = buildRight(arr);
            for (int i = 0; i < row; i++) {
                down[i][j] = temp[i];
            }
        }

        int ans = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int cur = Math.min(Math.min(left[i][j], right[i][j]), Math.min(up[i][j], down[i][j])) - heightMap[i][j];
                if (cur > 0) {
                    ans += cur;
                }
            }
        }
        return ans;
    }

    private int[] buildLeft(int[] arr) {
        int len = arr.length;
        int[] ans = new int[len];
        ans[0] = 0;
        int leftMax = arr[0];
        for (int i = 1; i < len; i++) {
            ans[i] = leftMax;
            leftMax = Math.max(leftMax, arr[i]);
        }
        return ans;
    }

    private int[] buildRight(int[] arr) {
        int len = arr.length;
        int[] ans = new int[len];
        ans[len - 1] = 0;
        int rightMax = arr[len - 1];
        for (int i = arr.length - 2; i >= 0; i--) {
            ans[i] = rightMax;
            rightMax = Math.max(rightMax, arr[i]);
        }
        return ans;
    }

    @Test
    public void testCase1() {
        LeetCode407 leetCode407 = new LeetCode407();
        int ans = leetCode407.trapRainWater(new int[][]{{1, 4, 3, 1, 3, 2}, {3, 2, 1, 3, 2, 4}, {2, 3, 3, 2, 3, 1}});
        assert ans == 4;
    }

    @Test
    public void testCase2() {
        LeetCode407 leetCode407 = new LeetCode407();
        int ans = leetCode407.trapRainWater(new int[][]{{3, 3, 3, 3, 3}, {3, 2, 2, 2, 3}, {3, 2, 1, 2, 3}, {3, 2, 2, 2, 3}, {3, 3, 3, 3, 3}});
        assert ans == 10;
    }

    @Test
    public void testCase3() {
        LeetCode407 leetCode407 = new LeetCode407();
        int ans = leetCode407.trapRainWater(new int[][]{{12, 13, 1, 12}, {13, 4, 13, 12}, {13, 8, 10, 12}, {12, 13, 12, 12}, {13, 13, 13, 13}});
        assert ans == 14;
    }
}
