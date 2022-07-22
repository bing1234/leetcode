package com.geekbing.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode1002 {
    public List<String> commonChars(String[] A) {
        Map<Character, Integer> resMap = countString(A[0]);
        for (int i = 1; i < A.length; i++) {
            if (resMap.isEmpty()) {
                return new ArrayList<>();
            }
            resMap = diffOfMap(resMap, countString(A[i]));
        }
        List<String> ans = new ArrayList<>();
        for (Character c : resMap.keySet()) {
            for (int i = 0; i < resMap.get(c); i++) {
                ans.add(String.valueOf(c));
            }
        }
        return ans;
    }

    private Map<Character, Integer> diffOfMap(Map<Character, Integer> map1, Map<Character, Integer> map2) {
        Map<Character, Integer> diff = new HashMap<>();
        for (Character c : map1.keySet()) {
            if (map2.containsKey(c)) {
                diff.put(c, Math.min(map1.get(c), map2.get(c)));
            }
        }
        return diff;
    }

    private Map<Character, Integer> countString(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : str.toCharArray()) {
            map.merge(c, 1, Integer::sum);
        }
        return map;
    }

    public static void main(String[] args) {
        LeetCode1002 leetCode1002 = new LeetCode1002();
        System.out.println(leetCode1002.commonChars(new String[]{"bella", "label", "roller"}));
        System.out.println(leetCode1002.commonChars(new String[]{"cool", "lock", "cook"}));
    }
}
