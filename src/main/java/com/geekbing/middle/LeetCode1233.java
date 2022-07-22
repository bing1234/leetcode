package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author bing
 */
public class LeetCode1233 {
    public List<String> removeSubfolders(String[] folder) {
        Trie trie = new Trie();
        for (String path : folder) {
            trie.insertPath(path);
        }
        List<String> ans = new ArrayList<>();
        for (String path : folder) {
            if (!trie.ifNeedDeletePath(path)) {
                ans.add(path);
            }
        }
        return ans;
    }

    private static class Trie {
        private final Node root;

        public Trie() {
            root = new Node();
        }

        private void insertPath(String path) {
            Node cur = root;
            for (int i = 0; i < path.length(); i++) {
                char c = path.charAt(i);
                int idx = c == '/' ? 26 : c - 'a';
                if (cur.childs[idx] == null) {
                    cur.childs[idx] = new Node();
                }
                cur = cur.childs[idx];
            }
            cur.isEnd = true;
        }

        private boolean ifNeedDeletePath(String path) {
            Node cur = root;
            for (int i = 0; i < path.length() - 1; i++) {
                char c = path.charAt(i);
                int idx = c == '/' ? 26 : c - 'a';
                cur = cur.childs[idx];
                if (cur.isEnd && path.charAt(i + 1) == '/') {
                    return true;
                }
            }
            return false;
        }
    }

    private static class Node {
        private final Node[] childs;
        private boolean isEnd;

        public Node() {
            childs = new Node[27];
            this.isEnd = false;
        }
    }

    @Test
    public void testCase1() {
        LeetCode1233 leetCode1233 = new LeetCode1233();
        List<String> ans = leetCode1233.removeSubfolders(new String[]{"/a", "/a/b", "/c/d", "/c/d/e", "/c/f"});
        List<String> expert = new ArrayList<>(Arrays.asList("/a", "/c/d", "/c/f"));
        assert expert.equals(ans);
    }

    @Test
    public void testCase2() {
        LeetCode1233 leetCode1233 = new LeetCode1233();
        List<String> ans = leetCode1233.removeSubfolders(new String[]{"/a", "/a/b/c", "/a/b/d"});
        List<String> expert = new ArrayList<>(Collections.singletonList("/a"));
        assert expert.equals(ans);
    }

    @Test
    public void testCase3() {
        LeetCode1233 leetCode1233 = new LeetCode1233();
        List<String> ans = leetCode1233.removeSubfolders(new String[]{"/a/b/c", "/a/b/ca", "/a/b/d"});
        List<String> expert = new ArrayList<>(Arrays.asList("/a/b/c", "/a/b/ca", "/a/b/d"));
        assert expert.equals(ans);
    }

    @Test
    public void testCase4() {
        LeetCode1233 leetCode1233 = new LeetCode1233();
        List<String> ans = leetCode1233.removeSubfolders(new String[]{"/ab", "/abc", "/abcd"});
        List<String> expert = new ArrayList<>(Arrays.asList("/ab", "/abc", "/abcd"));
        assert expert.equals(ans);
    }
}
