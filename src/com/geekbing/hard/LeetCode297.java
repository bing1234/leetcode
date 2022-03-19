package com.geekbing.hard;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author bing
 */
public class LeetCode297 {
    private static class Codec {
        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) {
                return "";
            }
            List<Integer> ans = new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int levelSize = queue.size();
                for (int i = 0; i < levelSize; i++) {
                    TreeNode cur = queue.poll();
                    if (cur == null) {
                        ans.add(null);
                    } else {
                        ans.add(cur.val);
                        queue.offer(cur.left);
                        queue.offer(cur.right);
                    }
                }
            }
            // 去掉末尾的null
            for (int i = ans.size() - 1; i >= 0; i--) {
                if (ans.get(i) == null) {
                    ans.remove(i);
                } else {
                    break;
                }
            }
            StringBuilder res = new StringBuilder();
            for (Integer an : ans) {
                res.append(an).append(",");
            }
            return res.substring(0, res.length() - 1);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data == null || data.equals("")) {
                return null;
            }
            String[] items = data.split(",");
            TreeNode root = new TreeNode(Integer.parseInt(items[0]));
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            int idx = 1;
            while (!queue.isEmpty()) {
                int levelSize = queue.size();
                for (int i = 0; i < levelSize; i++) {
                    TreeNode cur = queue.poll();
                    if (cur == null) {
                        continue;
                    }
                    if (idx == items.length) {
                        break;
                    }
                    String left = items[idx++];
                    if ("null".equals(left)) {
                        cur.left = null;
                    } else {
                        cur.left = new TreeNode(Integer.parseInt(left));
                        queue.offer(cur.left);
                    }
                    if (idx == items.length) {
                        break;
                    }
                    String right = items[idx++];
                    if ("null".equals(right)) {
                        cur.right = null;
                    } else {
                        cur.right = new TreeNode(Integer.parseInt(right));
                        queue.offer(cur.right);
                    }
                }
            }
            return root;
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
