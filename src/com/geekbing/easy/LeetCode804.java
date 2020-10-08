package com.geekbing.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LeetCode804 {
    private static final Map<Character, String> map = new HashMap<>();

    static {
        map.put('a', ".-");
        map.put('b', "-...");
        map.put('c', "-.-.");
        map.put('d', "-..");
        map.put('e', ".");
        map.put('f', "..-.");
        map.put('g', "--.");
        map.put('h', "....");
        map.put('i', "..");
        map.put('j', ".---");
        map.put('k', "-.-");
        map.put('l', ".-..");
        map.put('m', "--");
        map.put('n', "-.");
        map.put('o', "---");
        map.put('p', ".--.");
        map.put('q', "--.-");
        map.put('r', ".-.");
        map.put('s', "...");
        map.put('t', "-");
        map.put('u', "..-");
        map.put('v', "...-");
        map.put('w', ".--");
        map.put('x', "-..-");
        map.put('y', "-.--");
        map.put('z', "--..");
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
            ans.append(map.get(c));
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        LeetCode804 leetCode804 = new LeetCode804();
        System.out.println(leetCode804.uniqueMorseRepresentations(new String[]{"gin", "zen", "gig", "msg"}));
    }
}
