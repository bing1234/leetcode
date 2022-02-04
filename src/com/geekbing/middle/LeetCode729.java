package com.geekbing.middle;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode729 {
    private static class MyCalendar {
        private final SegmentTree segmentTree;

        public MyCalendar() {
            segmentTree = new SegmentTree();
        }

        public boolean book(int start, int end) {
            return segmentTree.addSegment(start, end);
        }

        private static class SegmentTree {
            private final Node tree;

            public SegmentTree() {
                tree = new Node(0, 0);
            }

            private boolean addSegment(int start, int end) {
                // 新节点，要么只能全在node.start往左，要么只能全在node.end往右
                Node node = tree;
                while (true) {
                    // 因为start,end是前闭后开区间，所以end可以取等号
                    if (end <= node.start) {
                        // 左子树为空，表示可以添加
                        if (node.left == null) {
                            node.left = new Node(start, end);
                            return true;
                        }
                        // 进入左子树线段树
                        node = node.left;
                    } else if (start >= node.end) {
                        // 右子树为空，表示可以添加
                        if (node.right == null) {
                            node.right = new Node(start, end);
                            return true;
                        }
                        // 进入右子树的线段树
                        node = node.right;
                    } else {
                        // start或end在[node.start,node.end)中，产生了重复预定
                        return false;
                    }
                }
            }
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
        MyCalendar calendar = new MyCalendar();
        assert calendar.book(10, 20);
        assert !calendar.book(15, 25);
        assert calendar.book(20, 30);
    }
}
