package com.geekbing.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LeetCode804 {
    private static final Map<Character, String> MAP = new HashMap<>();

    static {
        MAP.put('a', ".-");
        MAP.put('b', "-...");
        MAP.put('c', "-.-.");
        MAP.put('d', "-..");
        MAP.put('e', ".");
        MAP.put('f', "..-.");
        MAP.put('g', "--.");
        MAP.put('h', "....");
        MAP.put('i', "..");
        MAP.put('j', ".---");
        MAP.put('k', "-.-");
        MAP.put('l', ".-..");
        MAP.put('m', "--");
        MAP.put('n', "-.");
        MAP.put('o', "---");
        MAP.put('p', ".--.");
        MAP.put('q', "--.-");
        MAP.put('r', ".-.");
        MAP.put('s', "...");
        MAP.put('t', "-");
        MAP.put('u', "..-");
        MAP.put('v', "...-");
        MAP.put('w', ".--");
        MAP.put('x', "-..-");
        MAP.put('y', "-.--");
        MAP.put('z', "--..");
    }

    public int uniqueMorseRepresentations(String[] words) {
        Set<String> set = new HashSet<>();
        for (String word : words) {
            set.add(translateWord(word));
        }
        return set.size();
    }

    private String translateWord(String word) {
        StringBuilder ans = new StringBuilder();
        for (char c : word.toCharArray()) {
            ans.append(MAP.get(c));
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        LeetCode804 leetCode804 = new LeetCode804();
        System.out.println(leetCode804.uniqueMorseRepresentations(new String[]{"gin", "zen", "gig", "msg"}));
    }
}
