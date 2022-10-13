package com.geekbing.easy;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * todo
 *
 * @author bing
 */
public class LeetCode2423 {
    public boolean equalFrequency(String word) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : word.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        if (map.keySet().size() == 1) {
            return true;
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
