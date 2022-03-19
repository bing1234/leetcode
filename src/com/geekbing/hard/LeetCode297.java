package com.geekbing.hard;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode297 {
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
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        Codec codec = new Codec();
        TreeNode ans = codec.deserialize(codec.serialize(root));

        assert ans.val == 1;
        assert ans.left.val == 2;
        assert ans.left.left == null;
        assert ans.left.right == null;
        assert ans.right.val == 3;
        assert ans.right.left.val == 4;
        assert ans.right.left.left == null;
        assert ans.right.left.right == null;
        assert ans.right.right.val == 5;
        assert ans.right.right.left == null;
        assert ans.right.right.right == null;
    }

    @Test
    public void testCase2() {
        Codec codec = new Codec();
        TreeNode ans = codec.deserialize(codec.serialize(null));
        assert ans == null;
    }

    @Test
    public void testCase3() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);

        Codec codec = new Codec();
        TreeNode ans = codec.deserialize(codec.serialize(root));

        assert ans.val == 1;
        assert ans.left.val == 2;
        assert ans.left.left == null;
        assert ans.left.right == null;
        assert ans.right == null;
    }
}
