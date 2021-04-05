package com.geekbing.easy;

import java.util.HashMap;
import java.util.Map;

public class LeetCode953 {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i);
        }
        for (int i = 0; i < words.length - 1; i++) {
            if (!isAsc(words[i], words[i + 1], map)) {
                return false;
            }
        }
        return true;
    }

    private boolean isAsc(String word1, String word2, Map<Character, Integer> map) {
        int idx = 0;
        while (idx < word1.length() && idx < word2.length()) {
            if (map.get(word1.charAt(idx)) < map.get(word2.charAt(idx))) {
                return true;
            } else if (map.get(word1.charAt(idx)) > map.get(word2.charAt(idx))) {
                return false;
            } else {
                idx++;
            }
        }
        return word1.length() <= word2.length();
    }

    public static void main(String[] args) {
        LeetCode953 leetCode953 = new LeetCode953();
        System.out.println(leetCode953.isAlienSorted(new String[]{"hello", "leetcode"}, "hlabcdefgijkmnopqrstuvwxyz"));
        System.out.println(leetCode953.isAlienSorted(new String[]{"word", "world", "row"}, "worldabcefghijkmnpqstuvxyz"));
        System.out.println(leetCode953.isAlienSorted(new String[]{"apple", "app"}, "abcdefghijklmnopqrstuvwxyz"));
    }
}
