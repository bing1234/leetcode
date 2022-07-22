package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author bing
 */
public class LeetCode1079 {
    private final Set<String> set = new HashSet<>();

    public int numTilePossibilities(String tiles) {
        boolean[] visited = new boolean[tiles.length()];
        backtrack(tiles, visited, "");
        return set.size();
    }

    private void backtrack(String tiles, boolean[] visited, String cur) {
        if (!"".equals(cur)) {
            set.add(cur);
        }
        for (int i = 0; i < tiles.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                backtrack(tiles, visited, cur + tiles.charAt(i));
                visited[i] = false;
            }
        }
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
