package com.geekbing.lcp;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author bing
 */
public class Lcp44 {
    public int numColor(TreeNode root) {
        return travel(root).size();
    }

    private Set<Integer> travel(TreeNode root) {
        if (root == null) {
            return new HashSet<>();
        }
        Set<Integer> set = new HashSet<>();
        set.add(root.val);
        set.addAll(travel(root.left));
        set.addAll(travel(root.right));
        return set;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    @Test
    public void testCase1() {
        Lcp44 lcp44 = new Lcp44();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(2);

        assert lcp44.numColor(root) == 3;
    }

    @Test
    public void testCase2() {
        Lcp44 lcp44 = new Lcp44();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(3);
        root.right = new TreeNode(3);

        assert lcp44.numColor(root) == 1;
    }
}
