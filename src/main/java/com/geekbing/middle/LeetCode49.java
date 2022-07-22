package com.geekbing.middle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        // 值的映射 - 单词数组
        Map<String, List<String>> map = new HashMap<>();
        for (String word : strs) {
            String key = wordMapping(word);
            List<String> val = map.get(key);
            if (val == null) {
                val = new ArrayList<>();
            }
            val.add(word);
            map.put(key, val);
        }
        List<List<String>> ans = new ArrayList<>();
        for (String key : map.keySet()) {
            ans.add(map.get(key));
        }
        return ans;
    }

    private static String wordMapping(String word) {
        int[] bucket = new int[26];
        for (char c : word.toCharArray()) {
            bucket[c - 'a']++;
        }
        StringBuilder ans = new StringBuilder();
        for (int num : bucket) {
            ans.append(num).append(",");
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        LeetCode49 leetCode49 = new LeetCode49();
        System.out.println(leetCode49.groupAnagrams(new String[]{"bdddddddddd", "bbbbbbbbbbc"}));
    }
}
