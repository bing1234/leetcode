package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author bing
 */
public class LeetCode54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>(matrix.length * matrix[0].length);

        int left = 0, right = matrix[0].length - 1, top = 0, down = matrix.length - 1;
        int i = 0, j, idx = 0, total = matrix.length * matrix[0].length;
        while (true) {
            // 从左到右
            for (j = left; j <= right; j++) {
                ans.add(matrix[i][j]);
                idx++;
                if (idx == total) {
                    return ans;
                }
            }
            j--;
            top++;
            // 从上到下
            for (i = top; i <= down; i++) {
                ans.add(matrix[i][j]);
                idx++;
                if (idx == total) {
                    return ans;
                }
            }
            i--;
            right--;
            // 从右到左
            for (j = right; j >= left; j--) {
                ans.add(matrix[i][j]);
                idx++;
                if (idx == total) {
                    return ans;
                }
            }
            j++;
            down--;
            // 从下到上
            for (i = down; i >= top; i--) {
                ans.add(matrix[i][j]);
                idx++;
                if (idx == total) {
                    return ans;
                }
            }
            i++;
            left++;
        }
    }

    @Test
    public void testCase1() {
        LeetCode54 leetCode54 = new LeetCode54();
        List<Integer> ans = leetCode54.spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        List<Integer> expert = new ArrayList<>(Arrays.asList(1, 2, 3, 6, 9, 8, 7, 4, 5));
        assert expert.equals(ans);
    }

    @Test
    public void testCase2() {
        LeetCode54 leetCode54 = new LeetCode54();
        List<Integer> ans = leetCode54.spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}});
        List<Integer> expert = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7));
        assert expert.equals(ans);
    }
}
