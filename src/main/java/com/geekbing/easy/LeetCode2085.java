package com.geekbing.easy;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author bing
 */
public class LeetCode2085 {
    public int countWords(String[] words1, String[] words2) {
        Map<String, Integer> map1 = buildMap(words1);
        Map<String, Integer> map2 = buildMap(words2);
        int ans = 0;
        for (String str : map1.keySet()) {
            if (Objects.equals(1, map1.get(str)) && Objects.equals(1, map2.get(str))) {
                ans++;
            }
        }
        return ans;
    }

    private Map<String, Integer> buildMap(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        return map;
    }

    @Test
    public void testCase1() {
        LeetCode2085 leetCode2085 = new LeetCode2085();
        int ans = leetCode2085.countWords(new String[]{"leetcode", "is", "amazing", "as", "is"}, new String[]{"amazing", "leetcode", "is"});
        assert ans == 2;
    }

    @Test
    public void testCase2() {
        LeetCode2085 leetCode2085 = new LeetCode2085();
        int ans = leetCode2085.countWords(new String[]{"b", "bb", "bbb"}, new String[]{"a", "aa", "aaa"});
        assert ans == 0;
    }

    @Test
    public void testCase3() {
        LeetCode2085 leetCode2085 = new LeetCode2085();
        int ans = leetCode2085.countWords(new String[]{"a", "ab"}, new String[]{"a", "a", "a", "ab"});
        assert ans == 1;
    }
}
