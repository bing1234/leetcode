package com.geekbing.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bing
 */
public class LeetCode235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 处理特殊情况
        List<TreeNode> pathNodesP = pathNodes(root, p);
        List<TreeNode> pathNodesQ = pathNodes(root, q);
        for (int i = pathNodesP.size() - 1; i >= 0; i--) {
            if (pathNodesQ.contains(pathNodesP.get(i))) {
                return pathNodesP.get(i);
            }
        }
        return null;
    }

    public TreeNode lowestCommonAncestorV2(TreeNode root, TreeNode p, TreeNode q) {
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

    public TreeNode lowestCommonAncestorV3(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        // p,q分布在root的两侧
        if ((p.val < root.val && root.val < q.val) || (q.val < root.val && root.val < p.val)) {
            return root;
        }
        // p,q分布在root的左侧
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestorV3(root.left, p, q);
        } else {
            return lowestCommonAncestorV3(root.right, p, q);
        }
    }

    private List<TreeNode> pathNodes(TreeNode root, TreeNode p) {
        List<TreeNode> result = new ArrayList<>();
        TreeNode current = root;
        while (current.val != p.val) {
            result.add(current);
            if (current.val > p.val) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        result.add(p);
        return result;
    }

    public static void main(String[] args) {
        LeetCode235 leetCode235 = new LeetCode235();

        TreeNode root = new TreeNode(6);
        TreeNode node2 = new TreeNode(2);
        TreeNode node4 = new TreeNode(4);
        TreeNode node8 = new TreeNode(8);
        root.left = node2;
        root.left.left = new TreeNode(0);
        root.left.right = node4;
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);
        root.right = node8;
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        System.out.println(leetCode235.lowestCommonAncestorV3(root, node2, node8).val);
        System.out.println(leetCode235.lowestCommonAncestorV3(root, node2, node4).val);
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
