package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * TODO
 * @author bing
 */
public class LeetCode130 {
    public void solve(char[][] board) {

    }

    @Test
    public void testCase1() {
        LeetCode130 leetCode130 = new LeetCode130();
        char[][] board = new char[][]{
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };

        leetCode130.solve(board);

        char[][] res = new char[][]{
                {'X', 'X', 'X', 'X'},
                {'X', 'X', 'X', 'X'},
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'X', 'X'}
        };
        assert Arrays.deepEquals(board, res);
    }

    @Test
    public void testCase2() {
        LeetCode130 leetCode130 = new LeetCode130();
        char[][] board = new char[][]{{'X'}};
        leetCode130.solve(board);
        char[][] res = new char[][]{{'X'}};
        assert Arrays.deepEquals(board, res);
    }
}
