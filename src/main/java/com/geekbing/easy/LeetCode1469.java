package com.geekbing.easy;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author bing
 */
public class LeetCode1469 {
    public List<Integer> getLonelyNodes(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        if (root.left == null && root.right == null) {
            return ans;
        } else if (root.right == null) {
            ans.add(root.left.val);
            ans.addAll(getLonelyNodes(root.left));
        } else if (root.left == null) {
            ans.add(root.right.val);
            ans.addAll(getLonelyNodes(root.right));
        } else {
            ans.addAll(getLonelyNodes(root.left));
            ans.addAll(getLonelyNodes(root.right));
        }
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
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(3);

        LeetCode1469 leetCode1469 = new LeetCode1469();
        List<Integer> ans = leetCode1469.getLonelyNodes(root);
        List<Integer> expert = new ArrayList<>(Collections.singletonList(4));
        assert expert.equals(ans);
    }

    @Test
    public void testCase2() {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(2);

        LeetCode1469 leetCode1469 = new LeetCode1469();
        List<Integer> ans = leetCode1469.getLonelyNodes(root);
        ans = ans.stream().sorted().collect(Collectors.toList());
        List<Integer> expert = new ArrayList<>(Arrays.asList(2, 6));
        assert expert.equals(ans);
    }

    @Test
    public void testCase3() {
        TreeNode root = new TreeNode(11);
        root.left = new TreeNode(99);
        root.left.left = new TreeNode(77);
        root.left.left.left = new TreeNode(55);
        root.left.left.left.left = new TreeNode(33);
        root.right = new TreeNode(88);
        root.right.right = new TreeNode(66);
        root.right.right.right = new TreeNode(44);
        root.right.right.right.right = new TreeNode(22);

        LeetCode1469 leetCode1469 = new LeetCode1469();
        List<Integer> ans = leetCode1469.getLonelyNodes(root);
        ans = ans.stream().sorted().collect(Collectors.toList());
        List<Integer> expert = new ArrayList<>(Arrays.asList(22, 33, 44, 55, 66, 77));
        assert expert.equals(ans);
    }

    @Test
    public void testCase4() {
        TreeNode root = new TreeNode(197);
        LeetCode1469 leetCode1469 = new LeetCode1469();
        List<Integer> ans = leetCode1469.getLonelyNodes(root);
        assert new ArrayList<>().equals(ans);
    }

    @Test
    public void testCase5() {
        TreeNode root = new TreeNode(31);
        root.right = new TreeNode(78);
        root.right.right = new TreeNode(28);

        LeetCode1469 leetCode1469 = new LeetCode1469();
        List<Integer> ans = leetCode1469.getLonelyNodes(root);
        ans = ans.stream().sorted().collect(Collectors.toList());
        List<Integer> expert = new ArrayList<>(Arrays.asList(28, 78));
        assert expert.equals(ans);
    }
}
