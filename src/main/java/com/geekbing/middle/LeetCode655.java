package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author bing
 */
public class LeetCode655 {
    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> ans = new ArrayList<>();
        return ans;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    @Test
    public void testCase1() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);

        LeetCode655 leetCode655 = new LeetCode655();
        List<List<String>> ans = leetCode655.printTree(root);
        List<List<String>> expert = new ArrayList<>();
        expert.add(new ArrayList<>(Arrays.asList("", "1", "")));
        expert.add(new ArrayList<>(Arrays.asList("2", "", "")));
        assert expert.equals(ans);
    }

    @Test
    public void testCase2() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);

        LeetCode655 leetCode655 = new LeetCode655();
        List<List<String>> ans = leetCode655.printTree(root);
        List<List<String>> expert = new ArrayList<>();
        expert.add(new ArrayList<>(Arrays.asList("", "1", "")));
        expert.add(new ArrayList<>(Arrays.asList("2", "", "")));
        assert expert.equals(ans);
    }
}
