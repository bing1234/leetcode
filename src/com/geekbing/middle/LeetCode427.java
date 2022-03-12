package com.geekbing.middle;

/**
 * @author bing
 */
public class LeetCode427 {
    public Node construct(int[][] grid) {
        return null;
    }

    private static class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;
    }
}
