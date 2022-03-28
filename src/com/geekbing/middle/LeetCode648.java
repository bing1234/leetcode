package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author bing
 */
public class LeetCode648 {
    public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie();
        for (String word : dictionary) {
            trie.insertWord(word);
        }

        StringBuilder ans = new StringBuilder();
        StringBuilder word = new StringBuilder();
        int i = 0;
        while (i < sentence.length()) {
            // 找到一个单词
            while (i < sentence.length() && sentence.charAt(i) != ' ') {
                word.append(sentence.charAt(i));
                i++;
            }
            ans.append(trie.search(word.toString())).append(" ");
            word = new StringBuilder();
            i++;
        }
        return ans.substring(0, ans.length() - 1);
    }

    private static class Trie {
        private final Node root;

        public Trie() {
            root = new Node();
        }

        private void insertWord(String word) {
            Node cur = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (cur.childs[c - 'a'] == null) {
                    cur.childs[c - 'a'] = new Node();
                }
                cur = cur.childs[c - 'a'];
            }
            cur.isWord = true;
        }

        private String search(String word) {
            Node cur = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (cur.isWord) {
                    return word.substring(0, i);
                }
                if (cur.childs[c - 'a'] == null) {
                    return word;
                }
                cur = cur.childs[c - 'a'];
            }
            return word;
        }
    }

    private static class Node {
        private final Node[] childs;
        private boolean isWord;

        public Node() {
            this.childs = new Node[26];
            this.isWord = false;
        }
    }

    @Test
    public void testCase1() {
        LeetCode648 leetCode648 = new LeetCode648();
        List<String> dictionary = new ArrayList<>(Arrays.asList("cat", "bat", "rat"));
        String sentence = "the cattle was rattled by the battery";
        String ans = leetCode648.replaceWords(dictionary, sentence);
        assert ans.equals("the cat was rat by the bat");
    }

    @Test
    public void testCase2() {
        LeetCode648 leetCode648 = new LeetCode648();
        List<String> dictionary = new ArrayList<>(Arrays.asList("a", "b", "c"));
        String sentence = "aadsfasf absbs bbab cadsfafs";
        String ans = leetCode648.replaceWords(dictionary, sentence);
        assert ans.equals("a a b c");
    }
}
