package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author bing
 */
public class LeetCode1202 {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        UnionFind unionFind = new UnionFind(s.length());
        for (List<Integer> pair : pairs) {
            unionFind.union(pair.get(0), pair.get(1));
        }
        // parent - 该parent下所有的子元素
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            int p = unionFind.find(i);
            List<Integer> list = map.getOrDefault(p, new ArrayList<>());
            list.add(i);
            map.put(p, list);
        }

        return "";
    }

    private static class UnionFind {
        private final int[] parent;
        private final int[] weight;

        public UnionFind(int len) {
            this.parent = new int[len];
            this.weight = new int[len];
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
            }
        }

        private int find(int i) {
            return i == parent[i] ? i : find(parent[i]);
        }

        private void union(int i, int j) {
            int rootI = find(i);
            int rootJ = find(j);
            if (rootI != rootJ) {
                if (weight[rootI] < weight[rootJ]) {
                    parent[rootI] = rootJ;
                    weight[rootJ] += weight[rootI];
                } else {
                    parent[rootJ] = rootI;
                    weight[rootI] += weight[rootJ];
                }
            }
        }
    }

    @Test
    public void testCase1() {
        LeetCode1202 leetCode1202 = new LeetCode1202();
        String s = "dcab";
        List<List<Integer>> pairs = new ArrayList<>();
        pairs.add(new ArrayList<>(Arrays.asList(0, 3)));
        pairs.add(new ArrayList<>(Arrays.asList(1, 2)));
        assert leetCode1202.smallestStringWithSwaps(s, pairs).equals("bacd");
    }

    @Test
    public void testCase2() {
        LeetCode1202 leetCode1202 = new LeetCode1202();
        String s = "dcab";
        List<List<Integer>> pairs = new ArrayList<>();
        pairs.add(new ArrayList<>(Arrays.asList(0, 3)));
        pairs.add(new ArrayList<>(Arrays.asList(1, 2)));
        pairs.add(new ArrayList<>(Arrays.asList(0, 2)));
        assert leetCode1202.smallestStringWithSwaps(s, pairs).equals("abcd");
    }

    @Test
    public void testCase3() {
        LeetCode1202 leetCode1202 = new LeetCode1202();
        String s = "cba";
        List<List<Integer>> pairs = new ArrayList<>();
        pairs.add(new ArrayList<>(Arrays.asList(0, 1)));
        pairs.add(new ArrayList<>(Arrays.asList(1, 2)));
        assert leetCode1202.smallestStringWithSwaps(s, pairs).equals("abc");
    }
}
