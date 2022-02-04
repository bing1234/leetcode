package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author bing
 */
public class LeetCode2080 {
    private static class RangeFreqQuery {
        private final SegmentTree segmentTree;

        public RangeFreqQuery(int[] arr) {
            segmentTree = new SegmentTree(arr);
        }

        public int query(int left, int right, int value) {
            return segmentTree.query(left, right, value);
        }

        private static class SegmentTree {
            private final int[] arr;
            private final Node tree;

            public SegmentTree(int[] arr) {
                this.arr = arr;
                this.tree = buildSegmentTree(0, arr.length - 1);
            }

            public Node buildSegmentTree(int start, int end) {
                if (start == end) {
                    Map<Integer, Integer> data = new HashMap<>();
                    data.put(arr[start], 1);
                    return new Node(start, end, null, null, data);
                }
                int mid = (start + end) / 2;
                Node left = buildSegmentTree(start, mid);
                Node right = buildSegmentTree(mid + 1, end);

                Map<Integer, Integer> data = new HashMap<>(left.data);
                for (Integer key : right.data.keySet()) {
                    data.put(key, data.getOrDefault(key, 0) + right.data.get(key));
                }
                return new Node(start, end, left, right, data);
            }

            public int query(int left, int right, int value) {
                return queryRange(tree, left, right, value);
            }

            public int queryRange(Node node, int queryStart, int queryEnd, int value) {
                if (node.start == queryStart && node.end == queryEnd) {
                    return node.data.getOrDefault(value, 0);
                }
                int mid = (node.start + node.end) / 2;
                if (queryEnd <= mid) {
                    return queryRange(node.left, queryStart, queryEnd, value);
                } else if (queryStart >= mid + 1) {
                    return queryRange(node.right, queryStart, queryEnd, value);
                } else {
                    int leftCnt = queryRange(node.left, queryStart, mid, value);
                    int rightCnt = queryRange(node.right, mid + 1, queryEnd, value);
                    return leftCnt + rightCnt;
                }
            }
        }

        private static class Node {
            private final int start;
            private final int end;
            private final Node left;
            private final Node right;
            private final Map<Integer, Integer> data;

            public Node(int start, int end, Node left, Node right, Map<Integer, Integer> data) {
                this.start = start;
                this.end = end;
                this.left = left;
                this.right = right;
                this.data = data;
            }
        }
    }

    @Test
    public void testCase1() {
        RangeFreqQuery rangeFreqQuery = new RangeFreqQuery(new int[]{12, 33, 4, 56, 22, 2, 34, 33, 22, 12, 34, 56});
        assert rangeFreqQuery.query(1, 2, 4) == 1;
        assert rangeFreqQuery.query(0, 11, 33) == 2;
    }

    @Test
    public void testCase2() {
        RangeFreqQuery rangeFreqQuery = new RangeFreqQuery(new int[]{8, 4, 2, 5, 4, 5, 8, 6, 2, 3});
        assert rangeFreqQuery.query(0, 3, 5) == 1;
        assert rangeFreqQuery.query(5, 6, 2) == 0;
        assert rangeFreqQuery.query(6, 8, 4) == 0;
        assert rangeFreqQuery.query(2, 8, 3) == 0;
        assert rangeFreqQuery.query(4, 5, 1) == 0;
        assert rangeFreqQuery.query(2, 4, 2) == 1;
    }

    @Test
    public void testCase3() {
        RangeFreqQuery rangeFreqQuery = new RangeFreqQuery(new int[]{3, 4, 5, 3, 3, 2, 2, 2, 5, 4});
        assert rangeFreqQuery.query(2, 6, 3) == 2;
        assert rangeFreqQuery.query(5, 6, 5) == 0;
        assert rangeFreqQuery.query(1, 6, 2) == 2;
        assert rangeFreqQuery.query(0, 2, 3) == 1;
        assert rangeFreqQuery.query(5, 6, 4) == 0;
    }
}
