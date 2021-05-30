package com.geekbing.middle;

/**
 * @author bing
 */
public class LeetCode1791 {
    public int findCenter(int[][] edges) {
        if (edges[0][0] == edges[1][0]) {
            return edges[0][0];
        }
        if (edges[0][0] == edges[1][1]) {
            return edges[0][0];
        }
        if (edges[0][1] == edges[1][0]) {
            return edges[0][1];
        }
        if (edges[0][1] == edges[1][1]) {
            return edges[0][1];
        }
        return edges[0][1];
    }

    public static void main(String[] args) {
        LeetCode1791 leetCode1791 = new LeetCode1791();
        System.out.println(leetCode1791.findCenter(new int[][]{{1, 2}, {2, 3}, {4, 2}}));
        System.out.println(leetCode1791.findCenter(new int[][]{{1, 2}, {5, 1}, {1, 3}, {1, 4}}));
    }
}
