package com.geekbing.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bing
 */
public class LeetCode559 {
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        if (root.children == null) {
            return 1;
        }

        int max = 0;
        for (Node child : root.children) {
            int depth = maxDepth(child);
            if (depth > max) {
                max = depth;
            }
        }
        return max + 1;
    }

    public static void main(String[] args) {
        LeetCode559 leetCode559 = new LeetCode559();

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);

        node1.children = new ArrayList<>();
        node1.children.add(node3);
        node1.children.add(node2);
        node1.children.add(node4);

        node3.children = new ArrayList<>();
        node3.children.add(node5);
        node3.children.add(node6);

        System.out.println(leetCode559.maxDepth(node1));
    }

    private static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
