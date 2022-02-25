package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author bing
 */
public class LeetCode133 {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        // 保存新旧节点的对应关系
        Map<Node, Node> map = new HashMap<>();
        Node head = new Node(node.val, new ArrayList<>());
        map.put(node, head);

        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            for (Node neb : cur.neighbors) {
                if (!map.containsKey(neb)) {
                    map.put(neb, new Node(neb.val, new ArrayList<>()));
                    queue.offer(neb);
                }
                map.get(cur).neighbors.add(map.get(neb));
            }
        }
        return head;
    }

    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    @Test
    public void testCase1() {
        Node node1 = new Node(1, new ArrayList<>());
        Node node2 = new Node(2, new ArrayList<>());
        Node node3 = new Node(3, new ArrayList<>());
        Node node4 = new Node(4, new ArrayList<>());

        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        LeetCode133 leetCode133 = new LeetCode133();
        Node head = leetCode133.cloneGraph(node1);
        assert head.val == 1;
        assert head.neighbors.size() == 2;
    }

    @Test
    public void testCase2() {
        LeetCode133 leetCode133 = new LeetCode133();
        Node node = new Node(1, new ArrayList<>());

        Node head = leetCode133.cloneGraph(node);
        assert head != node;
        assert head.val == 1;
        assert head.neighbors.equals(new ArrayList<>());
    }

    @Test
    public void testCase3() {
        LeetCode133 leetCode133 = new LeetCode133();
        Node node = null;
        Node head = leetCode133.cloneGraph(node);
        assert head == null;
    }

    @Test
    public void testCase4() {
        LeetCode133 leetCode133 = new LeetCode133();

        Node node1 = new Node(1, new ArrayList<>());
        Node node2 = new Node(2, new ArrayList<>());
        node1.neighbors.add(node2);
        node2.neighbors.add(node1);

        Node head = leetCode133.cloneGraph(node1);
        assert head.val == 1;
        assert head.neighbors.size() == 1;
        assert head.neighbors.get(0).val == 2;
    }
}
