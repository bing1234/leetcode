package com.geekbing.middle;

import java.util.ArrayList;
import java.util.List;

public class LeetCode236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return root;
    }

    public TreeNode lowestCommonAncestorV2(TreeNode root, TreeNode p, TreeNode q) {
        List<List<TreeNode>> allPaths = allPaths(root);
        List<TreeNode> pathOfP = findPath(allPaths, p);
        List<TreeNode> pathOfQ = findPath(allPaths, q);
        return findCommonNode(pathOfP, pathOfQ);
    }

    public static void main(String[] args) {
        LeetCode236 leetCode236 = new LeetCode236();
        TreeNode root = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        node5.left = new TreeNode(6);
        node5.right = new TreeNode(2);
        node5.right.left = new TreeNode(7);
        TreeNode node4 = new TreeNode(4);
        node5.right.right = node4;
        TreeNode node1 = new TreeNode(1);
        node1.left = new TreeNode(0);
        node1.right = new TreeNode(8);
        root.left = node5;
        root.right = node1;
        System.out.println(leetCode236.lowestCommonAncestor(root, node5, node1).val);
        System.out.println(leetCode236.lowestCommonAncestor(root, node5, node4).val);

        TreeNode root1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        root1.left = node2;
        System.out.println(leetCode236.lowestCommonAncestor(root1, root1, node2).val);
    }

    private List<List<TreeNode>> allPaths(TreeNode root) {
        List<List<TreeNode>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        if (root.left == null && root.right == null) {
            List<TreeNode> paths = new ArrayList<>();
            paths.add(root);
            ans.add(paths);
            return ans;
        }
        if (root.left != null) {
            List<List<TreeNode>> leftPaths = allPaths(root.left);
            for (List<TreeNode> leftPath : leftPaths) {
                leftPath.add(0, root);
                ans.add(leftPath);
            }
        }
        if (root.right != null) {
            List<List<TreeNode>> rightPaths = allPaths(root.right);
            for (List<TreeNode> rightPath : rightPaths) {
                rightPath.add(0, root);
                ans.add(rightPath);
            }
        }
        return ans;
    }

    private List<TreeNode> findPath(List<List<TreeNode>> allPaths, TreeNode node) {
        for (List<TreeNode> path : allPaths) {
            List<TreeNode> ans = new ArrayList<>();
            for (TreeNode item : path) {
                ans.add(item);
                if (item == node) {
                    return ans;
                }
            }
        }
        return new ArrayList<>();
    }

    private TreeNode findCommonNode(List<TreeNode> pathOfP, List<TreeNode> pathOfQ) {
        TreeNode ans = null;
        for (int i = 0; i < pathOfP.size() && i < pathOfQ.size(); i++) {
            if (pathOfP.get(i) == pathOfQ.get(i)) {
                ans = pathOfP.get(i);
            } else {
                return ans;
            }
        }
        return ans;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
