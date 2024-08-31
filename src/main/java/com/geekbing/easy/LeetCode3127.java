package com.geekbing.easy;

public class LeetCode3127 {
    public boolean canMakeSquare(char[][] grid) {
        for (int i = 0; i < grid.length - 1; i++) {
            for (int j = 0; j < grid[i].length - 1; j++) {
                int cnt = 0;
                if (grid[i][j] == 'W') {
                    cnt++;
                }
                if (grid[i][j + 1] == 'W') {
                    cnt++;
                }
                if (grid[i + 1][j] == 'W') {
                    cnt++;
                }
                if (grid[i + 1][j + 1] == 'W') {
                    cnt++;
                }
                if (cnt == 0 || cnt == 1 || cnt == 3 || cnt == 4) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LeetCode3127 leetCode = new LeetCode3127();
        boolean ans = leetCode.canMakeSquare(new char[][]{{'B', 'W', 'B'}, {'B', 'W', 'W'}, {'B', 'W', 'B'}});
        if (!ans) {
            throw new RuntimeException("should be true");
        }

        ans = leetCode.canMakeSquare(new char[][]{{'B', 'W', 'B'}, {'W', 'B', 'W'}, {'B', 'W', 'B'}});
        if (ans) {
            throw new RuntimeException("should be false");
        }

        ans = leetCode.canMakeSquare(new char[][]{{'B', 'W', 'B'}, {'B', 'W', 'W'}, {'B', 'W', 'W'}});
        if (!ans) {
            throw new RuntimeException("should be true");
        }
    }
}
