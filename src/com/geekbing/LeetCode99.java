package com.geekbing;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author bing
 */
public class LeetCode99 {
    public void recoverTree(TreeNode root) {
        // 中序遍历
        List<Integer> orders = travel(root);
        // 应该正确的顺序
        List<Integer> rightOrder = new ArrayList<>(orders).stream().sorted().collect(Collectors.toList());

        // 找到两个错误数字的下标
        int[] arr = new int[2];
        for (int i = 0; i < orders.size(); i++) {
            if (!Objects.equals(orders.get(i), rightOrder.get(i))) {
                arr[0] = orders.get(i);
                arr[1] = rightOrder.get(i);
                break;
            }
        }

        // 找到
        TreeNode node1 = getOrder(root, arr[0]);
        TreeNode node2 = getOrder(root, arr[1]);

        // 交换
        int temp = node1.val;
        node1.val = node2.val;
        node2.val = temp;
    }

    private TreeNode getOrder(TreeNode root, int target) {
        if (root == null) {
            return null;
        }
        if (root.left != null) {
            TreeNode temp = getOrder(root.left, target);
            if (temp != null) {
                return temp;
            }
        }
        if (root.val == target) {
            return root;
        }
        if (root.right != null) {
            TreeNode temp = getOrder(root.right, target);
            if (temp != null) {
                return temp;
            }
        }
        return null;
    }

    private List<Integer> travel(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        if (root.left != null) {
            ans.addAll(travel(root.left));
        }
        ans.add(root.val);
        if (root.right != null) {
            ans.addAll(travel(root.right));
        }
        return ans;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    @Test
    public void testCase1() {
        LeetCode99 leetCode99 = new LeetCode99();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.right = new TreeNode(2);

        leetCode99.recoverTree(root);

        assert root.val == 3;
        assert root.left.val == 1;
        assert root.left.right.val == 2;
    }

    @Test
    public void testCase2() {
        LeetCode99 leetCode99 = new LeetCode99();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(2);

        leetCode99.recoverTree(root);

        assert root.val == 2;
        assert root.left.val == 1;
        assert root.right.val == 4;
        assert root.right.left.val == 3;
    }
}
