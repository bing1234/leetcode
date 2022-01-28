package com.geekbing.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author bing
 */
public class LeetCode2022 {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if (m * n != original.length) {
            return new int[][]{};
        }
        int[][] ans = new int[m][n];
        int idx = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans[i][j] = original[idx];
                idx++;
            }
        }
        return ans;
    }

    @Test
    public void testCase1() {
        LeetCode2022 leetCode2022 = new LeetCode2022();
        int[][] ans = leetCode2022.construct2DArray(new int[]{1, 2, 3, 4}, 2, 2);
        int[][] expert = new int[][]{{1, 2}, {3, 4}};
        assert Arrays.deepEquals(expert, ans);
    }

    @Test
    public void testCase2() {
        LeetCode2022 leetCode2022 = new LeetCode2022();
        int[][] ans = leetCode2022.construct2DArray(new int[]{1, 2, 3}, 1, 3);
        int[][] expert = new int[][]{{1, 2, 3}};
        assert Arrays.deepEquals(expert, ans);
    }

    @Test
    public void testCase3() {
        LeetCode2022 leetCode2022 = new LeetCode2022();
        int[][] ans = leetCode2022.construct2DArray(new int[]{1, 2}, 1, 1);
        assert Arrays.deepEquals(new int[][]{}, ans);
    }

    @Test
    public void testCase4() {
        LeetCode2022 leetCode2022 = new LeetCode2022();
        int[][] ans = leetCode2022.construct2DArray(new int[]{3}, 1, 2);
        assert Arrays.deepEquals(new int[][]{}, ans);
    }
}
