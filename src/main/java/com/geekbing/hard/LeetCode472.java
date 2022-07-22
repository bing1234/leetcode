package com.geekbing.hard;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 解题错误
 *
 * @author bing
 */
public class LeetCode472 {
    private Node root;

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        root = new Node(' ');
        for (String word : words) {
            insert(word);
        }
        return travel(root);
    }

    private List<String> travel(Node root) {
        List<String> ans = new ArrayList<>();
        for (Node node : root.childs) {
            ans.addAll(travelTree(node, "", 0));
        }
        return ans;
    }

    private List<String> travelTree(Node root, String cur, int cnt) {
        List<String> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        cur += root.val;
        if (root.isWord) {
            cnt++;
            if (cnt >= 2) {
                ans.add(cur);
            }
        }
        for (Node node : root.childs) {
            if (node != null) {
                ans.addAll(travelTree(node, cur, cnt));
            }
        }
        return ans;
    }

    private void insert(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.childs[c - 'a'] == null) {
                cur.childs[c - 'a'] = new Node(c);
            }
            cur = cur.childs[c - 'a'];
        }
        cur.isWord = true;
    }

    private static class Node {
        private char val;
        private Node[] childs;
        private boolean isWord;

        public Node(char val) {
            this.val = val;
            this.childs = new Node[26];
            this.isWord = false;
        }
    }

    @Test
    public void testCase1() {
        LeetCode472 leetCode472 = new LeetCode472();
        List<String> ans = leetCode472.findAllConcatenatedWordsInADict(new String[]{"cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat"});
        List<String> expert = new ArrayList<>(Arrays.asList("catsdogcats", "dogcatsdog", "ratcatdogcat"));
        assert expert.equals(ans);
    }

    @Test
    public void testCase2() {
        LeetCode472 leetCode472 = new LeetCode472();
        List<String> ans = leetCode472.findAllConcatenatedWordsInADict(new String[]{"cat", "dog", "catdog"});
        List<String> expert = new ArrayList<>(Collections.singletonList("catdog"));
        assert expert.equals(ans);
    }
}
