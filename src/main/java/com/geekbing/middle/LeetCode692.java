package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author bing
 */
public class LeetCode692 {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        Map<Integer, Set<String>> reverseMap = new HashMap<>();
        map.forEach((key, val) -> {
            Set<String> set = reverseMap.getOrDefault(val, new HashSet<>());
            set.add(key);
            reverseMap.put(val, set);
        });

        List<Integer> list = reverseMap.keySet().stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());

        List<String> ans = new ArrayList<>();
        for (Integer num : list) {
            List<String> temp = reverseMap.get(num).stream().sorted().collect(Collectors.toList());
            for (String s : temp) {
                ans.add(s);
                k--;
                if (k == 0) {
                    return ans;
                }
            }
        }
        return ans;
    }

    @Test
    public void testCase1() {
        LeetCode692 leetCode692 = new LeetCode692();
        List<String> ans = leetCode692.topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2);
        List<String> expert = new ArrayList<>(Arrays.asList("i", "love"));
        assert expert.equals(ans);
    }

    @Test
    public void testCase2() {
        LeetCode692 leetCode692 = new LeetCode692();
        List<String> ans = leetCode692.topKFrequent(new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}, 4);
        List<String> expert = new ArrayList<>(Arrays.asList("the", "is", "sunny", "day"));
        assert expert.equals(ans);
    }
}
