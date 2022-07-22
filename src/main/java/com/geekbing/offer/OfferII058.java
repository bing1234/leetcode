package com.geekbing.offer;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class OfferII058 {
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
                Node node = tree;
                while (true) {
                    if (node.start >= end) {
                        if (node.left == null) {
                            node.left = new Node(start, end);
                            return true;
                        }
                        node = node.left;
                    } else if (node.end <= start) {
                        if (node.right == null) {
                            node.right = new Node(start, end);
                            return true;
                        }
                        node = node.right;
                    } else {
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
