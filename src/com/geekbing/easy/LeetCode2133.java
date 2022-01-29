package com.geekbing.easy;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author bing
 */
public class LeetCode2133 {
    public boolean checkValid(int[][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        if (row != col) {
            return false;
        }
        // 检查行
        for (int[] rows : matrix) {
            if (!checkLineValid(rows)) {
                return false;
            }
        }
        // 检查列
        for (int j = 0; j < col; j++) {
            int[] cols = new int[row];
            for (int i = 0; i < row; i++) {
                cols[i] = matrix[i][j];
            }
            if (!checkLineValid(cols)) {
                return false;
            }
        }
        return true;
    }

    private boolean checkLineValid(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int i = 1; i <= nums.length; i++) {
            if (!set.contains(i)) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void testCase1() {
        LeetCode2133 leetCode2133 = new LeetCode2133();
        assert leetCode2133.checkValid(new int[][]{
                {1, 2, 3},
                {3, 1, 2},
                {2, 3, 1}
        });
    }

    @Test
    public void testCase2() {
        LeetCode2133 leetCode2133 = new LeetCode2133();
        assert !leetCode2133.checkValid(new int[][]{
                {1, 1, 1},
                {1, 2, 3},
                {1, 2, 3}
        });
    }
}
