package com.geekbing;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode2068 {
    public boolean checkAlmostEquivalent(String word1, String word2) {
        int[] bucket1 = buildBucket(word1);
        int[] bucket2 = buildBucket(word2);
        int diff = 0;
        for (int i = 0; i < bucket1.length; i++) {
            diff = Math.max(diff, Math.abs(bucket1[i] - bucket2[i]));
        }
        return diff <= 3;
    }

    private int[] buildBucket(String word) {
        char[] chars = word.toCharArray();
        int[] bucket = new int[26];
        for (char c : chars) {
            bucket[c - 'a']++;
        }
        return bucket;
    }

    @Test
    public void testCase1() {
        LeetCode2068 leetCode2068 = new LeetCode2068();
        assert !leetCode2068.checkAlmostEquivalent("aaaa", "bccb");
    }

    @Test
    public void testCase2() {
        LeetCode2068 leetCode2068 = new LeetCode2068();
        assert leetCode2068.checkAlmostEquivalent("abcdeef", "abaaacc");
    }

    @Test
    public void testCase3() {
        LeetCode2068 leetCode2068 = new LeetCode2068();
        assert leetCode2068.checkAlmostEquivalent("cccddabba", "babababab");
    }
}
