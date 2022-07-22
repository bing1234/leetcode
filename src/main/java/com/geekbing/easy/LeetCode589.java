package com.geekbing.easy;

import java.util.*;

/**
 * @author bing
 */
public class LeetCode589 {
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        // 栈
        Stack<Node> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            // 栈顶元素出栈
            Node node = stack.pop();
            result.add(node.val);

            // 子节点数组
            List<Node> childrens = node.children;
            if (childrens == null) {
                continue;
            }
            // 子节点倒序依次入栈
            for (int i = childrens.size() - 1; i >= 0; i--) {
                stack.push(childrens.get(i));
            }
        }
        return result;
    }

    public List<Integer> preorderV2(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        // 双端队列
        Deque<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            // 队列头结点出队列
            Node node = queue.pollFirst();
            result.add(node.val);

            // 子节点倒序加到队列头部
            List<Node> childrens = node.children;
            if (childrens == null) {
                continue;
            }
            for (int i = childrens.size() - 1; i >= 0; i--) {
                queue.offerFirst(childrens.get(i));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LeetCode589 leetCode589 = new LeetCode589();

        Node root = new Node(1);
        Node node3 = new Node(3);
        node3.children = new ArrayList<>(Arrays.asList(new Node(5), new Node(6)));
        root.children = new ArrayList<>(Arrays.asList(node3, new Node(2), new Node(4)));

        System.out.println(leetCode589.preorder(root));
    }

    private static class Node {
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
