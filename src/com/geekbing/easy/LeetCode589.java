package com.geekbing.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bing
 */
public class LeetCode589 {
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();

        return result;
    }

    public static void main(String[] args) {
        LeetCode589 leetCode589 = new LeetCode589();
        Node root = new Node();

        System.out.println();
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

    ;
}
