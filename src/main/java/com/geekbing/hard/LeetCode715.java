package com.geekbing.hard;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode715 {
    private static class RangeModule {
        private final Node tree;

        public RangeModule() {
            tree = new Node(0, 0);
        }

        public void addRange(int left, int right) {
            Node node = tree;
            while (true) {
                if (node.start >= right) {
                    if (node.left == null) {
                        node.left = new Node(left, right);
                        return;
                    }
                    node = node.left;
                } else if (node.end <= left) {
                    if (node.right == null) {
                        node.right = new Node(left, right);
                        return;
                    }
                    node = node.right;
                } else if (left <= node.start && node.end <= right) {
                    addRange(left, node.start);
                    addRange(node.end, right);
                } else if (left <= node.start && right <= node.end) {
                    addRange(left, node.start);
                } else if (node.start <= left && right <= node.end) {
                    return;
                } else if (node.start <= left && node.end <= right) {
                    addRange(node.end, right);
                }
            }
        }

        public boolean queryRange(int left, int right) {
            return rangeQuery(tree, left, right);
        }

        public boolean rangeQuery(Node node, int left, int right) {
            if (node == null) {
                return false;
            }
            if (node.start <= left && node.end >= right) {
                return true;
            }
            if (right <= node.start) {
                return rangeQuery(node.left, left, right);
            } else if (left >= node.end) {
                return rangeQuery(node.right, left, right);

            }
            return false;
        }

        public void removeRange(int left, int right) {

        }

        private static class Node {
            private final int start;
            private final int end;
            private Node left;
            private Node right;

            public Node(int start, int end) {
                this.start = start;
                this.end = end;
            }
        }
    }

    @Test
    public void testCase1() {
        RangeModule rangeModule = new RangeModule();
        rangeModule.addRange(10, 20);
        rangeModule.removeRange(14, 16);
        assert rangeModule.queryRange(10, 14);
        assert !rangeModule.queryRange(13, 15);
        assert rangeModule.queryRange(16, 17);
    }
}
