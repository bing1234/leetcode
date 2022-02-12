package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author bing
 */
public class LeetCode1079 {
    public int numTilePossibilities(String tiles) {
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = tiles.toCharArray();
        for (char c : chars) {
            Integer count = map.get(c);
            if (count == null) {
                count = 0;
            }
            map.put(c, count + 1);
        }

        return 0;
    }

    @Test
    public void testCase1() {
        LeetCode1079 leetCode1079 = new LeetCode1079();
        assert leetCode1079.numTilePossibilities("AAB") == 8;
    }

    @Test
    public void testCase2() {
        LeetCode1079 leetCode1079 = new LeetCode1079();
        assert leetCode1079.numTilePossibilities("AAABBC") == 188;
    }

    @Test
    public void testCase3() {
        LeetCode1079 leetCode1079 = new LeetCode1079();
        assert leetCode1079.numTilePossibilities("V") == 1;
    }
}
