package com.geekbing;

/**
 * @author bing
 */
public class LeetCode731 {
    private static class MyCalendarTwo {
        // 使用线段树保存所有未交叉的日期
        private final SegmentTree singleTree;
        // 使用线段树保存所有交叉段的日期
        private final SegmentTree twoTree;

        public MyCalendarTwo() {
            singleTree = new SegmentTree();
            twoTree = new SegmentTree();
        }

        public boolean book(int start, int end) {
            if (!twoTree.canAddSegment(start, end)) {
                return false;
            }

            BookRes res = singleTree.addSegment(start, end);
            if (res.flag) {
                return true;
            }

            if (!twoTree.canAddSegment(res.start, res.end)) {
                return false;
            }

            twoTree.addSegment(res.start, res.end);
            return true;
        }

        private static class SegmentTree {
            private final Node tree;

            public SegmentTree() {
                this.tree = new Node(0, 0);
            }

            private BookRes addSegment(int start, int end) {
                Node node = tree;
                while (true) {
                    if (node.start >= end) {
                        if (node.left == null) {
                            node.left = new Node(start, end);
                            return new BookRes(true);
                        }
                        node = node.left;
                    } else if (node.end <= start) {
                        if (node.right == null) {
                            node.right = new Node(start, end);
                            return new BookRes(true);
                        }
                        node = node.right;
                    } else {
                        if (start <= node.start && node.end <= end) {
                            addSegment(start, node.start);
                            addSegment(node.end, end);
                            return new BookRes(false, node.start, node.end);
                        }
                        if (node.start <= start && end <= node.end) {
                            return new BookRes(false, start, end);
                        }
                        if (node.start <= start && start <= node.end && node.end <= end) {
                            return new BookRes(false, start, node.end);
                        }
                        if (start <= node.start && node.start <= end && end <= end) {
                            return new BookRes(false, node.start, end);
                        }
                        return new BookRes(false);
                    }
                }
            }

            private boolean canAddSegment(int start, int end) {
                Node node = tree;
                while (true) {
                    if (node.start >= end) {
                        if (node.left == null) {
                            return true;
                        }
                        node = node.left;
                    } else if (node.end <= start) {
                        if (node.right == null) {
                            return true;
                        }
                        node = node.right;
                    } else {
                        return false;
                    }
                }
            }
        }

        private static class BookRes {
            private boolean flag;
            private int start;
            private int end;

            public BookRes(boolean flag, int start, int end) {
                this.flag = flag;
                this.start = start;
                this.end = end;
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
}
