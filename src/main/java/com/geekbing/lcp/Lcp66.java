package com.geekbing.lcp;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author bing
 */
public class Lcp66 {
    public int minNumBooths(String[] demand) {
        int[] maxBucket = new int[26];
        for (String str : demand) {
            int[] bucket = new int[26];
            for (char c : str.toCharArray()) {
                bucket[c - 'a']++;
            }
            for (int i = 0; i < maxBucket.length; i++) {
                maxBucket[i] = Math.max(maxBucket[i], bucket[i]);
            }
        }
        return Arrays.stream(maxBucket).sum();
    }

    @Test
    public void testCase1() {
        Lcp66 lcp66 = new Lcp66();
        int ans = lcp66.minNumBooths(new String[]{"acd", "bed", "accd"});
        assert ans == 6;
    }

    @Test
    public void testCase2() {
        Lcp66 lcp66 = new Lcp66();
        int ans = lcp66.minNumBooths(new String[]{"abc", "ab", "ac", "b"});
        assert ans == 3;
    }
}
