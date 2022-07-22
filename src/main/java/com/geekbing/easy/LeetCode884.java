package com.geekbing.easy;

import java.util.*;

public class LeetCode884 {
    public String[] uncommonFromSentences(String A, String B) {
        List<String> ans = new ArrayList<>();
        String[] wordsA = A.split(" ");
        String[] wordsB = B.split(" ");
        Map<String, Integer> mapA = new HashMap<>();
        Map<String, Integer> mapB = new HashMap<>();
        for (String word : wordsA) {
            Integer count = mapA.get(word);
            mapA.put(word, count == null ? 1 : count + 1);
        }
        for (String word : wordsB) {
            Integer count = mapB.get(word);
            mapB.put(word, count == null ? 1 : count + 1);
        }
        for (String word : wordsA) {
            if (mapA.get(word) == 1 && !mapB.containsKey(word)) {
                ans.add(word);
            }
        }
        for (String word : wordsB) {
            if (mapB.get(word) == 1 && !mapA.containsKey(word)) {
                ans.add(word);
            }
        }
        return ans.toArray(new String[0]);
    }

    public static void main(String[] args) {
        LeetCode884 leetCode884 = new LeetCode884();
        System.out.println(Arrays.toString(leetCode884.uncommonFromSentences("this apple is sweet", "this apple is sour")));
        System.out.println(Arrays.toString(leetCode884.uncommonFromSentences("apple apple", "banana")));
    }
}
