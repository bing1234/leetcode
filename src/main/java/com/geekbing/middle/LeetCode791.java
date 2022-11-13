package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author bing
 */
public class LeetCode791 {
    public String customSortString(String order, String s) {
        int idx = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (char c : order.toCharArray()) {
            map.put(c, idx++);
        }

        List<Character> left = new ArrayList<>();
        List<Character> right = new ArrayList<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                left.add(c);
            } else {
                right.add(c);
            }
        }
        // 左边的进行排序
        left.sort(Comparator.comparingInt(map::get));
        return left.stream().map(String::valueOf).collect(Collectors.joining()) + right.stream().map(String::valueOf).collect(Collectors.joining());
    }

    @Test
    public void testCase1() {
        LeetCode791 leetCode791 = new LeetCode791();
        String ans = leetCode791.customSortString("cba", "abcd");
        assert "cbad".equals(ans);
    }

    @Test
    public void testCase2() {
        LeetCode791 leetCode791 = new LeetCode791();
        String ans = leetCode791.customSortString("cbafg", "abcd");
        assert "cbad".equals(ans);
    }
}
