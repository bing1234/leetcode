package com.geekbing.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bing
 */
public class LeetCode1260 {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int total = grid.length * grid[0].length;
        k = k % total;

        int idx = 0;
        int[] temp = new int[total];
        for (int[] ints : grid) {
            for (int anInt : ints) {
                temp[idx++] = anInt;
            }
        }
        int[] arr = new int[total];
        for (int i = 0; i < total; i++) {
            arr[(i + k) % total] = temp[i];
        }

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> line = new ArrayList<>();
        for (int i = 0; i < total; i++) {
            line.add(arr[i]);
            if (line.size() == grid[0].length) {
                ans.add(line);
                line = new ArrayList<>();
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode1260 leetCode1260 = new LeetCode1260();
        System.out.println(leetCode1260.shiftGrid(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, 1));
        System.out.println(leetCode1260.shiftGrid(new int[][]{{3, 8, 1, 9}, {19, 7, 2, 5}, {4, 6, 11, 10}, {12, 0, 21, 13}}, 4));
        System.out.println(leetCode1260.shiftGrid(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, 9));
    }
}
