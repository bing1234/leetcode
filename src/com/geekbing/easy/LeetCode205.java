package com.geekbing.easy;

import java.util.HashMap;
import java.util.Map;

public class LeetCode205 {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Character> map = new HashMap<>();
        Map<Character, Character> revertMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (map.containsKey(c1)) {
                Character temp = revertMap.get(c2);
                if (temp == null || !temp.equals(c1)) {
                    return false;
                }
            } else {
                if (revertMap.containsKey(c2)) {
                    return false;
                }
                map.put(c1, c2);
                revertMap.put(c2, c1);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode205 leetCode205 = new LeetCode205();
        System.out.println(leetCode205.isIsomorphic("egg", "add"));
        System.out.println(leetCode205.isIsomorphic("foo", "bar"));
        System.out.println(leetCode205.isIsomorphic("paper", "title"));
    }
}
