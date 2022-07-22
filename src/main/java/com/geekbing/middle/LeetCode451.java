package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author bing
 */
public class LeetCode451 {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        Map<Integer, Set<Character>> reverseMap = new HashMap<>();
        map.forEach((key, val) -> {
            Set<Character> set = reverseMap.getOrDefault(val, new HashSet<>());
            set.add(key);
            reverseMap.put(val, set);
        });
        List<Integer> list = reverseMap.keySet().stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
        StringBuilder ans = new StringBuilder();
        for (Integer num : list) {
            for (Character c : reverseMap.get(num)) {
                ans.append(buildStr(c, num));
            }
        }
        return ans.toString();
    }

    private String buildStr(char c, int num) {
        if (num == 0) {
            return "";
        }
        if (num == 1) {
            return String.valueOf(c);
        }
        String temp = buildStr(c, num / 2);
        if (num % 2 == 0) {
            return temp + temp;
        } else {
            return temp + temp + c;
        }
    }

    @Test
    public void testCase1() {
        LeetCode451 leetCode451 = new LeetCode451();
        assert leetCode451.frequencySort("tree").equals("eert");
    }

    @Test
    public void testCase2() {
        LeetCode451 leetCode451 = new LeetCode451();
        String ans = leetCode451.frequencySort("cccaaa");
        assert ans.equals("cccaaa") || ans.equals("aaaccc");
    }

    @Test
    public void testCase3() {
        LeetCode451 leetCode451 = new LeetCode451();
        assert leetCode451.frequencySort("Aabb").equals("bbAa");
    }
}
