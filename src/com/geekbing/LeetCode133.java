package com.geekbing;

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
        if (node.neighbors == null || node.neighbors.size() == 0) {
            return new Node(node.val);
        }

        Node newRoot = new Node(node.val);
        newRoot.neighbors = new ArrayList<>();
        for (Node neighbor : node.neighbors) {
            Node newNeighbor = cloneGraph(neighbor);
            newRoot.neighbors.add(newNeighbor);
        }
        return newRoot;
    }


    @Test
    public void testCase1() {

    }

    @Test
    public void testCase2() {

    }

    @Test
    public void testCase3() {
        LeetCode133 leetCode133 = new LeetCode133();
        Node node = leetCode133.cloneGraph(null);
        assert node == null;
    }

    @Test
    public void testCase4() {
        LeetCode133 leetCode133 = new LeetCode133();

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        node1.neighbors = new ArrayList<>();
        node2.neighbors = new ArrayList<>();
        node1.neighbors.add(node2);
        node2.neighbors.add(node1);

        Node newNode = leetCode133.cloneGraph(node1);
        assert newNode.val == 1;
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
}
