package com.geekbing.middle;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode117 {
    public Node connectV2(Node root) {
        helper(root, null);
        return root;
    }

    private void helper(Node cur, Node next) {
        if (cur == null) {
            return;
        }
        cur.next = next;
        if (cur.left != null && cur.right != null) {
            helper(cur.left, cur.right);
            helper(cur.right, findNext(next));
        } else if (cur.left != null) {
            helper(cur.left, findNext(next));
        } else if (cur.right != null) {
            helper(cur.right, findNext(next));
        }
    }

    private Node findNext(Node next) {
        Node idx = next;
        if (idx == null) {
            return null;
        }
        while (idx != null) {
            if (idx.left != null) {
                return idx.left;
            }
            if (idx.right != null) {
                return idx.right;
            }
            idx = idx.next;
        }
        return null;
    }

    public Node connect(Node root) {
        // 参数校验
        if (root == null) {
            return root;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            int i = 0;
            while (i < levelSize) {
                Node cur = queue.poll();
                if (cur == null) {
                    continue;
                }
                if (i < levelSize - 1) {
                    cur.next = queue.peek();
                }
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
                i++;
            }
        }
        return root;
    }

    private static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
