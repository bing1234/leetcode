package com.geekbing.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author bing
 */
public class LeetCode1329 {
    public int[][] diagonalSort(int[][] mat) {
        // 竖直方向
        int i = 0, j = 0;
        while (i < mat.length) {
            // 收集并排序
            List<Integer> list = collect(mat, i, j);
            // 重新赋值
            reAssignValue(mat, i, j, list);

            i++;
        }
        // 水平方向
        i = 0;
        j = 1;
        while (j < mat[0].length) {
            // 收集并排序
            List<Integer> list = collect(mat, i, j);
            // 重新赋值
            reAssignValue(mat, i, j, list);
            j++;
        }
        return mat;
    }

    private List<Integer> collect(int[][] mat, int i, int j) {
        List<Integer> list = new ArrayList<>();
        while (i < mat.length && j < mat[0].length) {
            list.add(mat[i][j]);
            i++;
            j++;
        }
        list.sort(Integer::compare);
        return list;
    }

    private void reAssignValue(int[][] mat, int i, int j, List<Integer> list) {
        int idx = 0;
        while (i < mat.length && j < mat[0].length) {
            mat[i][j] = list.get(idx);
            i++;
            j++;
            idx++;
        }
    }

    public static void main(String[] args) {
        LeetCode1329 leetCode1329 = new LeetCode1329();

        System.out.println(Arrays.deepToString(leetCode1329.diagonalSort(new int[][]{{3, 3, 1, 1}, {2, 2, 1, 2}, {1, 1, 1, 2}})));
        System.out.println(Arrays.deepToString(leetCode1329.diagonalSort(new int[][]{{11, 25, 66, 1, 69, 7}, {23, 55, 17, 45, 15, 52}, {75, 31, 36, 44, 58, 8}, {22, 27, 33, 25, 68, 4}, {84, 28, 14, 11, 5, 50}})));
    }
}
