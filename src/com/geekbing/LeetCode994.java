package com.geekbing;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author bing
 */
public class LeetCode994 {
    public int orangesRotting(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        int goodNum = 0, rottedNum = 0, time = 0;
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<Point> queue = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    goodNum++;
                } else if (grid[i][j] == 2) {
                    queue.offer(new Point(i, j));
                    rottedNum++;
                }
            }
        }
        if (goodNum == 0) {
            return 0;
        }
        if (rottedNum == 0) {
            return -1;
        }
        while (!queue.isEmpty()) {
            time++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Point point = queue.poll();
                for (int[] dir : dirs) {
                    int newRow = point.x + dir[0];
                    int newCol = point.y + dir[1];
                    if (0 <= newRow && newRow < row && 0 <= newCol && newCol < col && grid[newRow][newCol] == 1) {
                        grid[newRow][newCol] = 2;
                        goodNum--;
                        queue.offer(new Point(newRow, newCol));
                        if (goodNum == 0) {
                            return time;
                        }
                    }
                }
            }
        }
        return -1;
    }

    private static class Point {
        private final int x;
        private final int y;


        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    @Test
    public void testCase1() {
        LeetCode994 leetCode994 = new LeetCode994();
        assert leetCode994.orangesRotting(new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}}) == 4;
    }

    @Test
    public void testCase2() {
        LeetCode994 leetCode994 = new LeetCode994();
        assert leetCode994.orangesRotting(new int[][]{{2, 1, 1}, {0, 1, 1}, {1, 0, 1}}) == -1;
    }

    @Test
    public void testCase3() {
        LeetCode994 leetCode994 = new LeetCode994();
        assert leetCode994.orangesRotting(new int[][]{{0, 2}}) == 0;
    }
}
