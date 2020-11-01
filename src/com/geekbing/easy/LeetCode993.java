package com.geekbing.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/cousins-in-binary-tree/submissions/
 * 993. 二叉树的堂兄弟节点
 *
 * @author bing
 */
public class LeetCode993 {
    private Map<Integer, Integer> depthMap;
    private Map<Integer, TreeNode> parentMap;

    public boolean isCousins(TreeNode root, int x, int y) {
        depthMap = new HashMap<>();
        parentMap = new HashMap<>();
        traverse(root, null, 0);
        return depthMap.get(x).equals(depthMap.get(y)) && !parentMap.get(x).equals(parentMap.get(y));
    }

    private void traverse(TreeNode root, TreeNode parent, int level) {
        if (root != null) {
            depthMap.put(root.val, level);
            parentMap.put(root.val, parent);
            traverse(root.left, root, level + 1);
            traverse(root.right, root, level + 1);
        }
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
