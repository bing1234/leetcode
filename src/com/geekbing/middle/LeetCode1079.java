package com.geekbing.middle;

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

    public static void main(String[] args) {

    }
}
