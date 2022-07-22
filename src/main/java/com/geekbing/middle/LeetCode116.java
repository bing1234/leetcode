package com.geekbing.middle;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author bing
 */
public class LeetCode116 {
    public Node connectV2(Node root) {
        helper(root, null);
        return root;
    }

    private void helper(Node cur, Node next) {
        if (cur == null) {
            return;
        }
        cur.next = next;
        helper(cur.left, cur.right);
        helper(cur.right, next == null ? null : (next.left != null ? next.left : next.right));
    }

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            // 当前层的节点数
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                Node node = queue.poll();
                if (node == null) {
                    continue;
                }
                if (i < levelSize - 1) {
                    node.next = queue.peek();
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return root;
    }

    public static void main(String[] args) {
        LeetCode116 leetCode116 = new LeetCode116();
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        Node node = leetCode116.connectV2(root);
        System.out.println(node);
    }

    private static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node left, Node right, Node next) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.next = next;
        }
    }
}
