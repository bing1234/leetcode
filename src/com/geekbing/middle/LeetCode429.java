package com.geekbing.middle;

import java.util.*;

/**
 * @author bing
 */
public class LeetCode429 {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                Node node = queue.poll();
                if (node == null) {
                    continue;
                }
                level.add(node.val);
                if (node.children != null && node.children.size() > 0) {
                    for (Node child : node.children) {
                        queue.offer(child);
                    }
                }
            }
            ans.add(level);
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode429 leetCode429 = new LeetCode429();
        Node root = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        node3.children = new ArrayList<>(Arrays.asList(node5, node6));
        root.children = new ArrayList<>(Arrays.asList(node3, node2, node4));
        System.out.println(leetCode429.levelOrder(root));
    }

    private static final class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, List<Node> children) {
            this.val = val;
            this.children = children;
        }
    }
}
