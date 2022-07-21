package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author bing
 */
public class LeetCode498 {
    public int[] findDiagonalOrder(int[][] mat) {
        int row = mat.length, col = mat[0].length, curRow = 0, curCol = 0, cnt = 0;
        boolean right = true;
        int[] ans = new int[row * col];
        while (cnt < row * col) {
            ans[cnt] = mat[curRow][curCol];
            cnt++;
            if (curRow == 0 && curCol < col - 1 && right) {
                curCol++;
                right = false;
            } else if (curRow == 0 && curCol == col - 1 && right) {
                curRow++;
                right = false;
            } else if (curCol == 0 && 0 < curRow && curRow < row - 1 && !right) {
                curRow++;
                right = true;
            } else if (curCol == 0 && curRow == row - 1 && !right) {
                curCol++;
                right = true;
            } else if (curRow == row - 1 && 0 < curCol && curCol < col - 1 && !right) {
                curCol++;
                right = true;
            } else if (curCol == col - 1 && 0 < curRow && curRow < row - 1 && right) {
                curRow++;
                right = false;
            } else {
                if (right) {
                    curRow--;
                    curCol++;
                } else {
                    curRow++;
                    curCol--;
                }
            }
        }
        return ans;
    }

    @Test
    public void testCase1() {
        LeetCode498 leetCode498 = new LeetCode498();
        int[] ans = leetCode498.findDiagonalOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        int[] expert = new int[]{1, 2, 4, 7, 5, 3, 6, 8, 9};
        assert Arrays.equals(expert, ans);
    }

    @Test
    public void testCase2() {
        LeetCode498 leetCode498 = new LeetCode498();
        int[] ans = leetCode498.findDiagonalOrder(new int[][]{{1, 2}, {3, 4}});
        int[] expert = new int[]{1, 2, 3, 4};
        assert Arrays.equals(expert, ans);
    }
}
