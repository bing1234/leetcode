package com.geekbing.easy;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author bing
 */
public class LeetCode734 {
    public boolean areSentencesSimilar(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        if (sentence1.length != sentence2.length) {
            return false;
        }
        Set<String> set = new HashSet<>();
        for (List<String> pair : similarPairs) {
            set.add(pair.get(0) + "," + pair.get(1));
        }
        for (int i = 0; i < sentence1.length; i++) {
            if (!sentence1[i].equals(sentence2[i]) &&
                    !set.contains(sentence1[i] + "," + sentence2[i]) &&
                    !set.contains(sentence2[i] + "," + sentence1[i])) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void testCase1() {
        LeetCode734 leetCode734 = new LeetCode734();
        List<List<String>> similarPairs = new ArrayList<>();
        similarPairs.add(new ArrayList<>(Arrays.asList("great", "fine")));
        similarPairs.add(new ArrayList<>(Arrays.asList("drama", "acting")));
        similarPairs.add(new ArrayList<>(Arrays.asList("skills", "talent")));
        assert leetCode734.areSentencesSimilar(new String[]{"great", "acting", "skills"},
                new String[]{"fine", "drama", "talent"}, similarPairs);
    }

    @Test
    public void testCase2() {
        LeetCode734 leetCode734 = new LeetCode734();
        assert leetCode734.areSentencesSimilar(new String[]{"great"}, new String[]{"great"}, new ArrayList<>());
    }

    @Test
    public void testCase3() {
        LeetCode734 leetCode734 = new LeetCode734();
        List<List<String>> similarPairs = new ArrayList<>();
        similarPairs.add(new ArrayList<>(Arrays.asList("great", "doubleplus")));
        assert !leetCode734.areSentencesSimilar(new String[]{"great"}, new String[]{"doubleplus", "good"}, similarPairs);
    }
}
