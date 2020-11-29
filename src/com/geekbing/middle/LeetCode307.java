package com.geekbing.middle;

public class LeetCode307 {
    public static void main(String[] args) {
        NumArray obj = new NumArray(new int[]{1, 3, 5});
        System.out.println(obj.sumRange(0, 2));
        obj.update(1, 2);
        System.out.println(obj.sumRange(0, 2));
    }

    private static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;
        private final int start;
        private final int end;

        public TreeNode(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    private static class NumArray {
        private final TreeNode root;

        private TreeNode buildTree(int[] nums, int start, int end) {
            if (nums == null || nums.length == 0) {
                return null;
            }
            TreeNode cur = new TreeNode(start, end);
            if (start == end) {
                cur.val = nums[start];
            } else {
                int mid = start + (end - start) / 2;
                cur.left = buildTree(nums, start, mid);
                cur.right = buildTree(nums, mid + 1, end);
                cur.val = cur.left.val + cur.right.val;
            }
            return cur;
        }

        public void updateTree(TreeNode node, int i, int val) {
            if (node.start == node.end) {
                node.val = val;
            } else {
                int mid = node.start + (node.end - node.start) / 2;
                if (i <= mid) {
                    updateTree(node.left, i, val);
                } else {
                    updateTree(node.right, i, val);
                }
                node.val = node.left.val + node.right.val;
            }
        }

        public int queryTree(TreeNode node, int i, int j) {
            if (node.end < i || node.start > j) {
                return 0;
            }
            if (i <= node.start && node.end <= j) {
                return node.val;
            }
            if (node.start == node.end) {
                return node.val;
            }
            return queryTree(node.left, i, j) + queryTree(node.right, i, j);
        }

        public NumArray(int[] nums) {
            root = buildTree(nums, 0, nums.length - 1);
        }

        public void update(int i, int val) {
            updateTree(root, i, val);
        }

        public int sumRange(int i, int j) {
            return queryTree(root, i, j);
        }
    }
}
