package com.geekbing.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LeetCode893 {
    public int numSpecialEquivGroups(String[] A) {
        int[] parent = new int[A.length];
        int[] rank = new int[A.length];
        Arrays.fill(parent, -1);
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                if (isEquivalent(A[i], A[j])) {
                    union(i, j, parent, rank);
                }
            }
        }
        return (int) Arrays.stream(parent).filter(num -> num == -1).count();
    }

    private void union(int x, int y, int[] parent, int[] rank) {
        int rootX = findRoot(x, parent);
        int rootY = findRoot(y, parent);
        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else {
                parent[rootX] = rootY;
                rank[rootY]++;
            }
        }
    }

    private int findRoot(int num, int[] parent) {
        int root = num;
        while (parent[root] != -1) {
            root = parent[root];
        }
        return root;
    }

    private boolean isEquivalent(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        Map<Character, Integer> odd1 = new HashMap<>();
        Map<Character, Integer> even1 = new HashMap<>();
        Map<Character, Integer> odd2 = new HashMap<>();
        Map<Character, Integer> even2 = new HashMap<>();
        for (int i = 0; i < str1.toCharArray().length; i++) {
            if (i % 2 == 0) {
                even1.merge(str1.charAt(i), 1, Integer::sum);
            } else {
                odd1.merge(str1.charAt(i), 1, Integer::sum);
            }
        }
        for (int i = 0; i < str2.toCharArray().length; i++) {
            if (i % 2 == 0) {
                even2.merge(str2.charAt(i), 1, Integer::sum);
            } else {
                odd2.merge(str2.charAt(i), 1, Integer::sum);
            }
        }
        return mapIsEqual(odd1, odd2) && mapIsEqual(even1, even2);
    }

    private boolean mapIsEqual(Map<Character, Integer> set1, Map<Character, Integer> set2) {
        if (set1.size() != set2.size()) {
            return false;
        }
        for (Character c : set1.keySet()) {
            Integer num1 = set1.get(c);
            Integer num2 = set2.get(c);
            if (!num1.equals(num2)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode893 leetCode893 = new LeetCode893();
        System.out.println(leetCode893.numSpecialEquivGroups(new String[]{"abcd", "cdab", "cbad", "xyzz", "zzxy", "zzyx"}));
        System.out.println(leetCode893.numSpecialEquivGroups(new String[]{"abc", "acb", "bac", "bca", "cab", "cba"}));
    }
}
