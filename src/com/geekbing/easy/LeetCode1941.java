package com.geekbing.easy;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author bing
 */
public class LeetCode1941 {
    public boolean areOccurrencesEqual(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        return map.values().stream().distinct().count() == 1;
    }

    @Test
    public void testCase1() {
        LeetCode1941 leetCode1941 = new LeetCode1941();
        assert leetCode1941.areOccurrencesEqual("abacbc");
    }

    @Test
    public void testCase2() {
        LeetCode1941 leetCode1941 = new LeetCode1941();
        assert !leetCode1941.areOccurrencesEqual("aaabb");
    }
}
