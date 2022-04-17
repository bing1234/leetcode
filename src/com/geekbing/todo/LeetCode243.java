package com.geekbing.todo;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode243 {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        return 0;
    }

    @Test
    public void testCase1() {
        LeetCode243 leetCode243 = new LeetCode243();
        assert leetCode243.shortestDistance(new String[]{"practice", "makes", "perfect", "coding", "makes"}, "coding", "practice") == 1;
    }

    @Test
    public void testCase2() {
        LeetCode243 leetCode243 = new LeetCode243();
        assert leetCode243.shortestDistance(new String[]{"practice", "makes", "perfect", "coding", "makes"}, "makes", "coding") == 1;
    }
}
