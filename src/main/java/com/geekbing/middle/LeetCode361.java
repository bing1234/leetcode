package com.geekbing.middle;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode361 {
    public int maxKilledEnemies(char[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '0') {
                    int cnt = countKilled(grid, i, j);
                    ans = Math.max(ans, cnt);
                }
            }
        }
        return ans;
    }

    private int countKilled(char[][] grid, int row, int col) {
        int ans = 0;
        // 朝左
        for (int j = col - 1; j >= 0; j--) {
            if (grid[row][j] == 'W') {
                break;
            }
            if (grid[row][j] == 'E') {
                ans++;
            }
        }
        // 朝右
        for (int j = col + 1; j < grid[0].length; j++) {
            if (grid[row][j] == 'W') {
                break;
            }
            if (grid[row][j] == 'E') {
                ans++;
            }
        }
        // 朝上
        for (int i = row - 1; i >= 0; i--) {
            if (grid[i][col] == 'W') {
                break;
            }
            if (grid[i][col] == 'E') {
                ans++;
            }
        }
        // 朝下
        for (int i = row + 1; i < grid.length; i++) {
            if (grid[i][col] == 'W') {
                break;
            }
            if (grid[i][col] == 'E') {
                ans++;
            }
        }
        return ans;
    }

    @Test
    public void testCase1() {
        LeetCode361 leetCode361 = new LeetCode361();
        int ans = leetCode361.maxKilledEnemies(new char[][]{
                {'0', 'E', '0', '0'},
                {'E', '0', 'W', 'E'},
                {'0', 'E', '0', '0'}
        });
        assert ans == 3;
    }

    @Test
    public void testCase2() {
        LeetCode361 leetCode361 = new LeetCode361();
        int ans = leetCode361.maxKilledEnemies(new char[][]{
                {'W', 'W', 'W'},
                {'0', '0', '0'},
                {'E', 'E', 'E'}
        });
        assert ans == 1;
    }
}
