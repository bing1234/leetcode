package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bing
 */
public class LeetCode990 {
    public boolean equationsPossible(String[] equations) {
        UnionFind unionFind = new UnionFind();

        List<Pair> notEquals = new ArrayList<>();
        for (String equation : equations) {
            int left = equation.charAt(0) - 'a';
            int right = equation.charAt(3) - 'a';
            if (equation.charAt(1) == '=') {
                unionFind.union(left, right);
            } else {
                notEquals.add(new Pair(left, right));
            }
        }
        for (Pair notEqual : notEquals) {
            if (unionFind.find(notEqual.left) == unionFind.find(notEqual.right)) {
                return false;
            }
        }
        return true;
    }

    private static class Pair {
        private final int left;
        private final int right;

        public Pair(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    private static class UnionFind {
        private final int[] parent;
        private final int[] weight;

        public UnionFind() {
            this.parent = new int[26];
            this.weight = new int[26];
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
        LeetCode990 leetCode990 = new LeetCode990();
        assert !leetCode990.equationsPossible(new String[]{"a==b", "b!=a"});
    }

    @Test
    public void testCase2() {
        LeetCode990 leetCode990 = new LeetCode990();
        assert leetCode990.equationsPossible(new String[]{"b==a", "a==b"});
    }

    @Test
    public void testCase3() {
        LeetCode990 leetCode990 = new LeetCode990();
        assert leetCode990.equationsPossible(new String[]{"a==b", "b==c", "a==c"});
    }

    @Test
    public void testCase4() {
        LeetCode990 leetCode990 = new LeetCode990();
        assert !leetCode990.equationsPossible(new String[]{"a==b", "b!=c", "c==a"});
    }

    @Test
    public void testCase5() {
        LeetCode990 leetCode990 = new LeetCode990();
        assert leetCode990.equationsPossible(new String[]{"c==c", "b==d", "x!=z"});
    }
}
