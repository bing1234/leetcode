package com.geekbing.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author bing
 */
public class LeetCode2423 {
    public boolean equalFrequency(String word) {
        int[] bucket = new int[26];
        for (char c : word.toCharArray()) {
            bucket[c - 'a']++;
        }
        for (int i = 0; i < bucket.length; i++) {
            if (bucket[i] == 0) {
                continue;
            }
            bucket[i]--;
            if (Arrays.stream(bucket).filter(num -> num > 0).distinct().count() < 2) {
                return true;
            }
            bucket[i]++;
        }
        return false;
    }

    @Test
    public void testCase1() {
        LeetCode2423 leetCode2423 = new LeetCode2423();
        assert leetCode2423.equalFrequency("abcc");
    }

    @Test
    public void testCase2() {
        LeetCode2423 leetCode2423 = new LeetCode2423();
        assert !leetCode2423.equalFrequency("aazz");
    }
}
