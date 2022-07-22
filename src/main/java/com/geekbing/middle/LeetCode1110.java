package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author bing
 */
public class LeetCode1110 {
    private final List<TreeNode> ans = new ArrayList<>();
    private Set<Integer> deletes;

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        if (to_delete == null || to_delete.length == 0) {
            return new ArrayList<>(Collections.singletonList(root));
        }
        deletes = Arrays.stream(to_delete).boxed().collect(Collectors.toSet());

        root = delNodesHelper(root);
        if (root != null) {
            ans.add(root);
        }
        return ans;
    }

    private TreeNode delNodesHelper(TreeNode root) {
        if (root == null) {
            return root;
        }
        root.left = delNodesHelper(root.left);
        root.right = delNodesHelper(root.right);
        if (deletes.contains(root.val)) {
            if (root.left != null) {
                ans.add(root.left);
            }
            if (root.right != null) {
                ans.add(root.right);
            }
            root = null;
        }
        return root;
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
        LeetCode1110 leetCode1110 = new LeetCode1110();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        List<TreeNode> ans = leetCode1110.delNodes(root, new int[]{3, 5});
        assert ans.size() == 3;
    }

    @Test
    public void testCase2() {
        LeetCode1110 leetCode1110 = new LeetCode1110();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(4);

        List<TreeNode> ans = leetCode1110.delNodes(root, new int[]{3, 5});
        assert ans.size() == 1;
    }
}
