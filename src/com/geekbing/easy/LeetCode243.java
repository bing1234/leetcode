package com.geekbing.easy;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bing
 */
public class LeetCode243 {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        List<Integer> index1 = getIndex(wordsDict, word1);
        List<Integer> index2 = getIndex(wordsDict, word2);
        int ans = Integer.MAX_VALUE, idx1 = 0, idx2 = 0;
        while (idx1 < index1.size() && idx2 < index2.size()) {
            ans = Math.min(ans, Math.abs(index1.get(idx1) - index2.get(idx2)));
            if (index1.get(idx1) < index2.get(idx2)) {
                idx1++;
            } else {
                idx2++;
            }
        }
        return ans;
    }

    private List<Integer> getIndex(String[] wordsDict, String word) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < wordsDict.length; i++) {
            if (wordsDict[i].equals(word)) {
                ans.add(i);
            }
        }
        return ans;
    }

    @Test
    public void testCase1() {
        LeetCode243 leetCode243 = new LeetCode243();
        int ans = leetCode243.shortestDistance(new String[]{"practice", "makes", "perfect", "coding", "makes"}, "coding", "practice");
        assert ans == 3;
    }

    @Test
    public void testCase2() {
        LeetCode243 leetCode243 = new LeetCode243();
        int ans = leetCode243.shortestDistance(new String[]{"practice", "makes", "perfect", "coding", "makes"}, "makes", "coding");
        assert ans == 1;
    }
}
