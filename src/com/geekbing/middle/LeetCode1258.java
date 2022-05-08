package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author bing
 */
public class LeetCode1258 {
    public List<String> generateSentences(List<List<String>> synonyms, String text) {
        UnionFind unionFind = new UnionFind();
        for (List<String> pair : synonyms) {
            unionFind.union(pair.get(0), pair.get(1));
        }
        // root - 圈子的对应关系
        Map<String, Set<String>> rootMap = unionFind.getRootMap();
        String[] words = text.split(" ");
        List<String> ans = new ArrayList<>();
        dfs(unionFind, ans, rootMap, words, 0);
        Collections.sort(ans);
        return ans;
    }

    private void dfs(UnionFind unionFind, List<String> ans, Map<String, Set<String>> rootMap, String[] words, int idx) {
        if (idx == words.length) {
            ans.add(String.join(" ", words));
        } else {
            Set<String> synonyms = rootMap.get(unionFind.find(words[idx]));
            // 当前单词存在近义词
            if (synonyms != null && synonyms.size() > 1) {
                String oldWord = words[idx];
                for (String word : synonyms) {
                    words[idx] = word;
                    dfs(unionFind, ans, rootMap, words.clone(), idx + 1);
                    words[idx] = oldWord;
                }
            } else {
                // 不存在近义词
                dfs(unionFind, ans, rootMap, words.clone(), idx + 1);
            }
        }
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

        public void union(String str1, String str2) {
            String root1 = find(str1);
            String root2 = find(str2);
            if (!Objects.equals(root1, root2)) {
                parent.put(root1, root2);
            }
        }

        public Map<String, Set<String>> getRootMap() {
            Map<String, Set<String>> rootMap = new HashMap<>();
            for (String word : parent.keySet()) {
                String root = find(word);
                Set<String> set = rootMap.getOrDefault(root, new HashSet<>());
                set.add(word);
                set.add(root);
                rootMap.put(root, set);
            }
            return rootMap;
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
