package com.geekbing.todo;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author bing
 */
public class LeetCode2325 {
    private int cnt = 0;
    private final Map<Character, Character> map = new HashMap<>();

    public String decodeMessage(String key, String message) {
        for (char c : key.toCharArray()) {
            if (c == ' ') {
                continue;
            }
            if (!map.containsKey(c)) {
                map.put(c, (char) ('a' + cnt));
                cnt++;
                if (cnt == 26) {
                    break;
                }
            }
        }
        StringBuilder ans = new StringBuilder();
        for (char c : message.toCharArray()) {
            if (c == ' ') {
                ans.append(' ');
            } else {
                ans.append(map.get(c));
            }
        }
        return ans.toString();
    }

    @Test
    public void testCase1() {
        LeetCode2325 leetCode2325 = new LeetCode2325();
        String ans = leetCode2325.decodeMessage("the quick brown fox jumps over the lazy dog", "vkbs bs t suepuv");
        assert ans.equals("this is a secret");
    }

    @Test
    public void testCase2() {
        LeetCode2325 leetCode2325 = new LeetCode2325();
        String ans = leetCode2325.decodeMessage("eljuxhpwnyrdgtqkviszcfmabo", "zwx hnfx lqantp mnoeius ycgk vcnjrdb");
        assert ans.equals("the five boxing wizards jump quickly");
    }
}
