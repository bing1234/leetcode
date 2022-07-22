package com.geekbing.middle;

public class LeetCode1476 {
    private final int[][] content;

    public LeetCode1476(int[][] rectangle) {
        this.content = rectangle;
    }

    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        for (int row = row1; row <= row2; row++) {
            for (int col = col1; col <= col2; col++) {
                this.content[row][col] = newValue;
            }
        }
    }

    public int getValue(int row, int col) {
        return this.content[row][col];
    }

    public static void main(String[] args) {
        LeetCode1476 subrectangleQueries = new LeetCode1476(new int[][]{{1, 2, 1}, {4, 3, 4}, {3, 2, 1}, {1, 1, 1}});
        System.out.println(subrectangleQueries.getValue(0, 2));// 返回 1
        subrectangleQueries.updateSubrectangle(0, 0, 3, 2, 5);
        System.out.println(subrectangleQueries.getValue(0, 2)); // 返回 5
        System.out.println(subrectangleQueries.getValue(3, 1)); // 返回 5
        subrectangleQueries.updateSubrectangle(3, 0, 3, 2, 10);
        System.out.println(subrectangleQueries.getValue(3, 1)); // 返回 10
        System.out.println(subrectangleQueries.getValue(0, 2)); // 返回 5
    }
}
