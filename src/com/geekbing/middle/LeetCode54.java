package com.geekbing.middle;

import java.util.ArrayList;
import java.util.List;

public class LeetCode54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        LeetCode54 leetCode54 = new LeetCode54();
        System.out.println(leetCode54.spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
        System.out.println(leetCode54.spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}}));
    }
}
