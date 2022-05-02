package com.geekbing.todo;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * TODO
 *
 * @author bing
 */
public class LeetCode1258 {
    public List<String> generateSentences(List<List<String>> synonyms, String text) {
        UnionFind unionFind = new UnionFind();
        for (List<String> pair : synonyms) {
            unionFind.union(pair.get(0), pair.get(1));
        }
        // root - 圈子的对应关系
        Map<String, List<String>> rootMap = unionFind.getRootMap();

        String[] items = text.split(" ");
        for (String item : items) {

        }
        List<String> ans = new ArrayList<>();

        return ans;
    }

    private static class UnionFind {
        private final Map<String, String> parent = new HashMap<>();

        public String find(String str) {
            String p = parent.get(str);
            if (p == null) {
                return str;
            }
            return p.equals(str) ? str : find(p);
        }

        public Map<String, List<String>> getRootMap() {
            Map<String, List<String>> rootMap = new HashMap<>();
            for (String str : parent.keySet()) {
                String root = find(str);
                List<String> list = rootMap.getOrDefault(root, new ArrayList<>());
                rootMap.put(root, list);
            }
            for (String root : rootMap.keySet()) {
                List<String> list = rootMap.get(root);
                Collections.sort(list);
                rootMap.put(root, list);
            }
            return rootMap;
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
        LeetCode1258 leetCode1258 = new LeetCode1258();
        List<List<String>> synonyms = new ArrayList<>();
        synonyms.add(new ArrayList<>(Arrays.asList("happy", "joy")));
        synonyms.add(new ArrayList<>(Arrays.asList("sad", "sorrow")));
        synonyms.add(new ArrayList<>(Arrays.asList("joy", "cheerful")));
        List<String> ans = leetCode1258.generateSentences(synonyms, "I am happy today but was sad yesterday");
        List<String> expert = new ArrayList<>(Arrays.asList(
                "I am cheerful today but was sad yesterday",
                "I am cheerful today but was sorrow yesterday",
                "I am happy today but was sad yesterday",
                "I am happy today but was sorrow yesterday",
                "I am joy today but was sad yesterday",
                "I am joy today but was sorrow yesterday"));
        assert expert.equals(ans);
    }
}
