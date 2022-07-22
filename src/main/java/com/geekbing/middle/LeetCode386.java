package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author bing
 */
public class LeetCode386 {
    private Node root;

    public List<Integer> lexicalOrder(int n) {
        root = new Node(' ');
        for (int i = 1; i <= n; i++) {
            insert(String.valueOf(i));
        }
        return travelTrees(root);
    }

    private List<Integer> travelTrees(Node root) {
        List<Integer> ans = new ArrayList<>();
        for (Node node : root.childs) {
            ans.addAll(travelTree(node, ""));
        }
        return ans;
    }

    private List<Integer> travelTree(Node root, String cur) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        if (root.isEnd) {
            cur += root.val;
            ans.add(Integer.parseInt(cur));
        }
        for (Node node : root.childs) {
            if (node != null) {
                ans.addAll(travelTree(node, cur));
            }
        }
        return ans;
    }

    private void insert(String num) {
        Node cur = root;
        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            if (cur.childs[c - '0'] == null) {
                cur.childs[c - '0'] = new Node(c);
            }
            cur = cur.childs[c - '0'];
        }
        cur.isEnd = true;
    }

    private static class Node {
        private char val;
        private Node[] childs;
        private boolean isEnd;

        public Node(char val) {
            this.val = val;
            this.childs = new Node[10];
            this.isEnd = false;
        }
    }

    @Test
    public void testCase1() {
        LeetCode386 leetCode386 = new LeetCode386();
        List<Integer> ans = leetCode386.lexicalOrder(13);
        List<Integer> expert = new ArrayList<>(Arrays.asList(1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9));
        assert expert.equals(ans);
    }

    @Test
    public void testCase2() {
        LeetCode386 leetCode386 = new LeetCode386();
        List<Integer> ans = leetCode386.lexicalOrder(2);
        List<Integer> expert = new ArrayList<>(Arrays.asList(1, 2));
        assert expert.equals(ans);
    }
}
