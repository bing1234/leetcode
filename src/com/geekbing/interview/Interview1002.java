package com.geekbing.interview;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author bing
 */
public class Interview1002 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String key = convertCountStr(str);
            List<String> val = map.get(key);
            if (val == null) {
                val = new ArrayList<>();
            }
            val.add(str);
            map.put(key, val);
        }
        return new ArrayList<>(map.values());
    }

    private String convertCountStr(String str) {
        int[] bucket = new int[26];
        for (char c : str.toCharArray()) {
            bucket[c - 'a']++;
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < bucket.length; i++) {
            if (bucket[i] != 0) {
                ans.append((char) ('a' + i)).append(bucket[i]);
            }
        }
        return ans.toString();
    }

    @Test
    public void testCase1() {
        Interview1002 interview1002 = new Interview1002();

        List<List<String>> ans = interview1002.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        assert ans != null;
        assert ans.size() == 3;
    }
}
