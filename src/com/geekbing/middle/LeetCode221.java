package com.geekbing.middle;

/**
 * @author bing
 */
public class LeetCode221 {
    public int maximalSquare(char[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];

        return 0;
    }

    public static void main(String[] args) {
        LeetCode221 leetCode221 = new LeetCode221();

        System.out.println(leetCode221.maximalSquare(new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}}));
        System.out.println(leetCode221.maximalSquare(new char[][]{{'0', '1'}, {'1', '0'}}));
        System.out.println(leetCode221.maximalSquare(new char[][]{{'0'}}));
    }
}
