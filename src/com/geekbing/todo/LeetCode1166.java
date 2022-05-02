package com.geekbing.todo;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode1166 {
    private static class FileSystem {

        public FileSystem() {

        }

        public boolean createPath(String path, int value) {
            return true;
        }

        public int get(String path) {
            return 0;
        }
    }

    private static class Node {
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