package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author bing
 */
public class LeetCode1061 {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        UnionFind unionFind = new UnionFind();
        for (int i = 0; i < s1.length(); i++) {
            unionFind.union(s1.charAt(i) - 'a', s2.charAt(i) - 'a');
        }
        // root-圈子的对应关系
        Map<Integer, List<Character>> map = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            int root = unionFind.find(i);
            List<Character> list = map.getOrDefault(root, new ArrayList<>());
            list.add((char) ('a' + i));
            map.put(root, list);
        }
        // 排序
        for (Integer root : map.keySet()) {
            List<Character> list = map.get(root).stream().sorted().collect(Collectors.toList());
            map.put(root, list);
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < baseStr.length(); i++) {
            int root = unionFind.find(baseStr.charAt(i) - 'a');
            ans.append(map.get(root).get(0));
        }
        return ans.toString();
    }

    private static class UnionFind {
        private final int[] parent;
        private final int[] weight;

        public UnionFind() {
            parent = new int[26];
            weight = new int[26];
            for (int i = 0; i < 26; i++) {
                parent[i] = i;
            }
            Arrays.fill(weight, 1);
        }

        public int find(int x) {
            return parent[x] == x ? x : find(parent[x]);
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                if (weight[rootX] < weight[rootY]) {
                    weight[rootY] += weight[rootX];
                    parent[rootX] = rootY;
                } else {
                    weight[rootX] += weight[rootY];
                    parent[rootY] = rootX;
                }
            }
        }
    }

    @Test
    public void testCase1() {
        LeetCode1061 leetCode1061 = new LeetCode1061();
        assert leetCode1061.smallestEquivalentString("parker", "morris", "parser").equals("makkek");
    }

    @Test
    public void testCase2() {
        LeetCode1061 leetCode1061 = new LeetCode1061();
        assert leetCode1061.smallestEquivalentString("hello", "world", "hold").equals("hdld");
    }

    @Test
    public void testCase3() {
        LeetCode1061 leetCode1061 = new LeetCode1061();
        assert leetCode1061.smallestEquivalentString("leetcode", "programs", "sourcecode").equals("aauaaaaada");
    }
}
