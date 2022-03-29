package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author bing
 */
public class LeetCode1268 {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie trie = new Trie();
        for (String product : products) {
            trie.insertProduct(product);
        }
        List<List<String>> ans = new ArrayList<>();
        String cur = "";
        for (int i = 0; i < searchWord.length(); i++) {
            cur += searchWord.charAt(i);
            List<String> suggested = trie.startWithWord(cur);
            ans.add(suggested);
        }
        return ans;
    }

    private static class Trie {
        private final Node root;

        public Trie() {
            root = new Node(' ');
        }

        private void insertProduct(String product) {
            Node cur = root;
            for (int i = 0; i < product.length(); i++) {
                char c = product.charAt(i);
                if (cur.childs[c - 'a'] == null) {
                    cur.childs[c - 'a'] = new Node(c);
                }
                cur = cur.childs[c - 'a'];
            }
            cur.isWord = true;
        }

        private List<String> startWithWord(String word) {
            Node cur = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (cur.childs[c - 'a'] == null) {
                    return new ArrayList<>();
                }
                cur = cur.childs[c - 'a'];
            }
            List<String> ans = new ArrayList<>();
            travelTree(cur, ans, word.substring(0, word.length() - 1));
            return ans;
        }

        private void travelTree(Node root, List<String> ans, String cur) {
            if (ans.size() == 3) {
                return;
            }
            if (root == null) {
                return;
            }
            cur += root.val;
            if (root.isWord) {
                ans.add(cur);
            }
            for (Node child : root.childs) {
                if (child != null) {
                    travelTree(child, ans, cur);
                    if (ans.size() == 3) {
                        return;
                    }
                }
            }
        }
    }

    private static class Node {
        private final char val;
        private final Node[] childs;
        private boolean isWord;

        public Node(char val) {
            this.val = val;
            this.childs = new Node[26];
            this.isWord = false;
        }
    }

    @Test
    public void testCase1() {
        LeetCode1268 leetCode1268 = new LeetCode1268();
        List<List<String>> ans = leetCode1268.suggestedProducts(new String[]{"mobile", "mouse", "moneypot", "monitor", "mousepad"}, "mouse");
        List<List<String>> expert = new ArrayList<>();
        expert.add(new ArrayList<>(Arrays.asList("mobile", "moneypot", "monitor")));
        expert.add(new ArrayList<>(Arrays.asList("mobile", "moneypot", "monitor")));
        expert.add(new ArrayList<>(Arrays.asList("mouse", "mousepad")));
        expert.add(new ArrayList<>(Arrays.asList("mouse", "mousepad")));
        expert.add(new ArrayList<>(Arrays.asList("mouse", "mousepad")));
        assert expert.equals(ans);
    }

    @Test
    public void testCase2() {
        LeetCode1268 leetCode1268 = new LeetCode1268();
        List<List<String>> ans = leetCode1268.suggestedProducts(new String[]{"havana"}, "havana");
        List<List<String>> expert = new ArrayList<>();
        expert.add(new ArrayList<>(Collections.singletonList("havana")));
        expert.add(new ArrayList<>(Collections.singletonList("havana")));
        expert.add(new ArrayList<>(Collections.singletonList("havana")));
        expert.add(new ArrayList<>(Collections.singletonList("havana")));
        expert.add(new ArrayList<>(Collections.singletonList("havana")));
        expert.add(new ArrayList<>(Collections.singletonList("havana")));
        assert expert.equals(ans);
    }

    @Test
    public void testCase3() {
        LeetCode1268 leetCode1268 = new LeetCode1268();
        List<List<String>> ans = leetCode1268.suggestedProducts(new String[]{"bags", "baggage", "banner", "box", "cloths"}, "bags");
        List<List<String>> expert = new ArrayList<>();
        expert.add(new ArrayList<>(Arrays.asList("baggage", "bags", "banner")));
        expert.add(new ArrayList<>(Arrays.asList("baggage", "bags", "banner")));
        expert.add(new ArrayList<>(Arrays.asList("baggage", "bags")));
        expert.add(new ArrayList<>(Collections.singletonList("bags")));
        assert expert.equals(ans);
    }

    @Test
    public void testCase4() {
        LeetCode1268 leetCode1268 = new LeetCode1268();
        List<List<String>> ans = leetCode1268.suggestedProducts(new String[]{"havana"}, "tatiana");
        List<List<String>> expert = new ArrayList<>();
        expert.add(new ArrayList<>());
        expert.add(new ArrayList<>());
        expert.add(new ArrayList<>());
        expert.add(new ArrayList<>());
        expert.add(new ArrayList<>());
        expert.add(new ArrayList<>());
        expert.add(new ArrayList<>());
        assert expert.equals(ans);
    }
}
