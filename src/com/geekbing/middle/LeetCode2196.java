package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author bing
 */
public class LeetCode2196 {
    /**
     * 节点值-节点
     */
    private final Map<Integer, TreeNode> relationMap = new HashMap<>();

    /**
     * 节点 - 节点parent
     */
    private final Map<TreeNode, TreeNode> parentMap = new HashMap<>();

    public TreeNode createBinaryTree(int[][] descriptions) {
        for (int[] description : descriptions) {
            TreeNode parent = relationMap.get(description[0]);
            if (parent == null) {
                parent = new TreeNode(description[0]);
                relationMap.put(description[0], parent);
            }
            TreeNode child = relationMap.get(description[1]);
            if (child == null) {
                child = new TreeNode(description[1]);
                relationMap.put(description[1], child);
            }
            if (description[2] == 1) {
                parent.left = child;
            } else {
                parent.right = child;
            }
            parentMap.put(child, parent);
        }
        return findRoot(new ArrayList<>(parentMap.keySet()).get(0));
    }

    private TreeNode findRoot(TreeNode target) {
        if (parentMap.get(target) == null || parentMap.get(target).equals(target)) {
            return target;
        }
        return findRoot(parentMap.get(target));
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    @Test
    public void testCase1() {
        LeetCode2196 leetCode2196 = new LeetCode2196();
        TreeNode ans = leetCode2196.createBinaryTree(new int[][]{{20, 15, 1}, {20, 17, 0}, {50, 20, 1}, {50, 80, 0}, {80, 19, 1}});
        assert ans.val == 50;
    }

    @Test
    public void testCase2() {
        LeetCode2196 leetCode2196 = new LeetCode2196();
        TreeNode ans = leetCode2196.createBinaryTree(new int[][]{{1, 2, 1}, {2, 3, 0}, {3, 4, 1}});
        assert ans.val == 1;
    }
}
