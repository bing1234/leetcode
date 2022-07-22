package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author bing
 */
public class LeetCode737 {
    public boolean areSentencesSimilarTwo(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        if (sentence1.length != sentence2.length) {
            return false;
        }
        UnionFind unionFind = new UnionFind();
        for (List<String> pair : similarPairs) {
            unionFind.union(pair.get(0), pair.get(1));
        }
        for (int i = 0; i < sentence1.length; i++) {
            if (sentence1[i].equals(sentence2[i])) {
                continue;
            }
            if (!unionFind.connected(sentence1[i], sentence2[i])) {
                return false;
            }
        }
        return true;
    }

    private static class UnionFind {
        private final Map<String, String> parent;

        public UnionFind() {
            parent = new HashMap<>();
        }

        public String find(String str) {
            if (str == null) {
                return null;
            }
            String p = parent.get(str);
            if (p == null) {
                return str;
            }
            return str.equals(p) ? str : find(p);
        }

        public boolean connected(String str1, String str2) {
            String root1 = find(str1);
            String root2 = find(str2);
            return root1 != null && root1.equals(root2);
        }

        public void union(String str1, String str2) {
            String root1 = find(str1);
            String root2 = find(str2);
            if (!Objects.equals(root1, root2)) {
                parent.put(root1, root2);
            }
        }
    }

    @Test
    public void testCase1() {
        LeetCode737 leetCode737 = new LeetCode737();
        List<List<String>> similarPairs = new ArrayList<>();
        similarPairs.add(new ArrayList<>(Arrays.asList("great", "good")));
        similarPairs.add(new ArrayList<>(Arrays.asList("fine", "good")));
        similarPairs.add(new ArrayList<>(Arrays.asList("drama", "acting")));
        similarPairs.add(new ArrayList<>(Arrays.asList("skills", "talent")));
        assert leetCode737.areSentencesSimilarTwo(new String[]{"great", "acting", "skills"}, new String[]{"fine", "drama", "talent"}, similarPairs);
    }

    @Test
    public void testCase2() {
        LeetCode737 leetCode737 = new LeetCode737();
        List<List<String>> similarPairs = new ArrayList<>();
        similarPairs.add(new ArrayList<>(Arrays.asList("manga", "onepiece")));
        similarPairs.add(new ArrayList<>(Arrays.asList("platform", "anime")));
        similarPairs.add(new ArrayList<>(Arrays.asList("leetcode", "platform")));
        similarPairs.add(new ArrayList<>(Arrays.asList("anime", "manga")));
        assert leetCode737.areSentencesSimilarTwo(new String[]{"I", "love", "leetcode"}, new String[]{"I", "love", "onepiece"}, similarPairs);
    }

    @Test
    public void testCase3() {
        LeetCode737 leetCode737 = new LeetCode737();
        List<List<String>> similarPairs = new ArrayList<>();
        similarPairs.add(new ArrayList<>(Arrays.asList("manga", "hunterXhunter")));
        similarPairs.add(new ArrayList<>(Arrays.asList("platform", "anime")));
        similarPairs.add(new ArrayList<>(Arrays.asList("leetcode", "platform")));
        similarPairs.add(new ArrayList<>(Arrays.asList("anime", "manga")));
        assert !leetCode737.areSentencesSimilarTwo(new String[]{"I", "love", "leetcode"}, new String[]{"I", "love", "onepiece"}, similarPairs);
    }
}
