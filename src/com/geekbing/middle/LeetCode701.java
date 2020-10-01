package com.geekbing.middle;

import java.util.ArrayList;
import java.util.List;

public class LeetCode701 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode cur = new TreeNode(val);
        if (root == null) {
            return cur;
        }
        // 先序遍历二叉搜索树
        List<TreeNode> nodes = travelTree(root);

        // 找到恰好比待插入节点大的节点
        TreeNode largerNode = findLargerNode(nodes, val);

        // 如果不存在比待插入的节点大的节点
        if (largerNode == null) {
            // 获取最大的节点
            TreeNode max = nodes.get(nodes.size() - 1);
            max.right = cur;
        } else {
            TreeNode left = largerNode.left;
            largerNode.left = cur;
            if (left != null) {
                cur.left = left;
            }
        }
        return root;
    }

    private TreeNode findLargerNode(List<TreeNode> nodes, int val) {
        if (nodes.size() == 0) {
            return null;
        }
        if (val < nodes.get(0).val) {
            return nodes.get(0);
        }
        for (int i = 1; i < nodes.size(); i++) {
            if (nodes.get(i - 1).val < val && val < nodes.get(i).val) {
                return nodes.get(i);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        LeetCode701 leetCode701 = new LeetCode701();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(7);

        TreeNode newRoot = leetCode701.insertIntoBST(root, 5);
        for (TreeNode node : leetCode701.travelTree(newRoot)) {
            System.out.print(node.val + " ");
        }
    }

    private List<TreeNode> travelTree(TreeNode root) {
        List<TreeNode> nodes = new ArrayList<>();
        if (root != null) {
            nodes.addAll(travelTree(root.left));
            nodes.add(root);
            nodes.addAll(travelTree(root.right));
        }
        return nodes;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
