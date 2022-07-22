package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author bing
 */
public class LeetCode1166 {
    private static class FileSystem {
        private final Trie trie;

        public FileSystem() {
            trie = new Trie();
        }

        public boolean createPath(String path, int value) {
            return trie.createPath(path, value);
        }

        public int get(String path) {
            return trie.get(path);
        }
    }

    private static class Trie {
        private final Node root;

        public Trie() {
            root = new Node();
        }

        public boolean createPath(String path, int value) {
            Node cur = root;
            String[] items = path.split("/");
            for (int i = 1; i < items.length - 1; i++) {
                if (!cur.childs.containsKey(items[i])) {
                    return false;
                }
                cur = cur.childs.get(items[i]);
            }
            if (cur.childs.containsKey(items[items.length - 1])) {
                return false;
            }
            cur.childs.put(items[items.length - 1], new Node(value));
            return true;
        }

        public int get(String path) {
            Node cur = root;
            String[] items = path.split("/");
            for (int i = 1; i < items.length; i++) {
                if (!cur.childs.containsKey(items[i])) {
                    return -1;
                }
                cur = cur.childs.get(items[i]);
            }
            return cur.value;
        }
    }

    private static class Node {
        private final Map<String, Node> childs;
        private final int value;

        public Node() {
            childs = new HashMap<>();
            value = -1;
        }

        public Node(int value) {
            childs = new HashMap<>();
            this.value = value;
        }
    }

    @Test
    public void testCase1() {
        FileSystem fileSystem = new FileSystem();
        assert fileSystem.createPath("/a", 1); // 返回 true
        assert fileSystem.get("/a") == 1;                 // 返回 1
    }

    @Test
    public void testCase2() {
        FileSystem fileSystem = new FileSystem();
        assert fileSystem.createPath("/leet", 1);       // 返回 true
        assert fileSystem.createPath("/leet/code", 2);  // 返回 true
        assert fileSystem.get("/leet/code") == 2;                  // 返回 2
        assert !fileSystem.createPath("/c/d", 1);       // 返回 false 因为父路径 "/c" 不存在。
        assert fileSystem.get("/c") == -1;                         // 返回 -1 因为该路径不存在。
    }
}