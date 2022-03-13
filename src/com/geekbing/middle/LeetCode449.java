package com.geekbing.middle;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode449 {
    private static class Codec {
        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            return null;
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            return null;
        }
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    @Test
    public void testCase1() {
        Codec ser = new Codec();
        Codec deser = new Codec();

        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        String tree = ser.serialize(root);

        TreeNode ans = deser.deserialize(tree);
        assert ans.val == 2;
        assert ans.left.val == 1;
        assert ans.left.left == null;
        assert ans.left.right == null;
        assert ans.right.val == 3;
        assert ans.right.left == null;
        assert ans.right.right == null;
    }
}
