package com.geekbing.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * todo
 * @author bing
 */
public class LeetCode590 {
    /**
     * 迭代法
     */
    public List<Integer> postorder(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();

        // 先根节点入栈
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            // 获取栈顶元素
            Node node = stack.peek();

            // 该节点的子节点
            List<Node> childs = node.children;
            if (childs == null || childs.size() == 0) {
                result.add(node.val);
                stack.pop();
            } else {
                for (Node child : childs) {
                    stack.push(child);
                }
            }
        }

        return result;

    }

    /**
     * 递归遍历
     */
    public List<Integer> postorder2(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();
        if (root.children == null) {
            result.add(root.val);
            return result;
        }

        for (Node child : root.children) {
            result.addAll(postorder(child));
        }

        result.add(root.val);
        return result;
    }

    public static void main(String[] args) {
        LeetCode590 leetCode590 = new LeetCode590();

        Node root = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);

        node3.children = new ArrayList<>();
        node3.children.add(node5);
        node3.children.add(node6);

        root.children = new ArrayList<>();
        root.children.add(node3);
        root.children.add(node2);
        root.children.add(node4);

        List<Integer> order = leetCode590.postorder(root);
        System.out.println(order.toString());
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
