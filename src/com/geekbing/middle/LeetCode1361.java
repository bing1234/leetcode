package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author bing
 */
public class LeetCode1361 {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        UnionFind unionFind = new UnionFind(n);
        for (int i = 0; i < leftChild.length; i++) {
            if (leftChild[i] != -1 && unionFind.union(i, leftChild[i])) {
                return false;
            }
        }
        for (int i = 0; i < rightChild.length; i++) {
            if (rightChild[i] != -1 && unionFind.union(i, rightChild[i])) {
                return false;
            }
        }
        Set<Integer> roots = new HashSet<>();
        for (int i = 0; i < n; i++) {
            roots.add(unionFind.find(i));
            if (roots.size() > 1) {
                return false;
            }
        }
        return true;
    }

    private static class UnionFind {
        private final int[] parent;

        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
            }
        }

        private int find(int i) {
            return i == parent[i] ? i : find(parent[i]);
        }

        private boolean union(int i, int j) {
            int rootI = find(i);
            int rootJ = find(j);
            if (rootI == rootJ) {
                return true;
            }
            parent[j] = i;
            return false;
        }
    }

    @Test
    public void testCase1() {
        LeetCode1361 leetCode1361 = new LeetCode1361();
        assert leetCode1361.validateBinaryTreeNodes(4, new int[]{1, -1, 3, -1}, new int[]{2, -1, -1, -1});
    }

    @Test
    public void testCase2() {
        LeetCode1361 leetCode1361 = new LeetCode1361();
        assert !leetCode1361.validateBinaryTreeNodes(4, new int[]{1, -1, 3, -1}, new int[]{2, 3, -1, -1});
    }

    @Test
    public void testCase3() {
        LeetCode1361 leetCode1361 = new LeetCode1361();
        assert !leetCode1361.validateBinaryTreeNodes(2, new int[]{1, 0}, new int[]{-1, -1});
    }

    @Test
    public void testCase4() {
        LeetCode1361 leetCode1361 = new LeetCode1361();
        assert !leetCode1361.validateBinaryTreeNodes(6, new int[]{1, -1, -1, 4, -1, -1}, new int[]{2, -1, -1, 5, -1, -1});
    }

    @Test
    public void testCase5() {
        LeetCode1361 leetCode1361 = new LeetCode1361();
        assert !leetCode1361.validateBinaryTreeNodes(3, new int[]{1, -1, -1}, new int[]{-1, -1, 1});
    }

    @Test
    public void testCase6() {
        LeetCode1361 leetCode1361 = new LeetCode1361();
        assert leetCode1361.validateBinaryTreeNodes(4, new int[]{3, -1, 1, -1}, new int[]{-1, -1, 0, -1});
    }
}
