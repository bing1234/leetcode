package com.geekbing.offer;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author bing
 */
public class Offer7 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        // 找到下标
        int idx = findTarget(inorder, preorder[0]);
        TreeNode root = new TreeNode(preorder[0]);
        root.left = buildTree(Arrays.copyOfRange(preorder, 1, idx + 1), Arrays.copyOfRange(inorder, 0, idx));
        root.right = buildTree(Arrays.copyOfRange(preorder, idx + 1, preorder.length), Arrays.copyOfRange(inorder, idx + 1, inorder.length));
        return root;
    }

    private int findTarget(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return 0;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private List<Integer> preOrderTravel(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        ans.add(root.val);
        ans.addAll(preOrderTravel(root.left));
        ans.addAll(preOrderTravel(root.right));
        return ans;
    }

    private List<Integer> inOrderTravel(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        ans.addAll(inOrderTravel(root.left));
        ans.add(root.val);
        ans.addAll(inOrderTravel(root.right));
        return ans;
    }

    @Test
    public void testCase1() {
        Offer7 offer7 = new Offer7();
        int[] preOrder = new int[]{3, 9, 20, 15, 7};
        int[] inOrder = new int[]{9, 3, 15, 20, 7};
        TreeNode root = offer7.buildTree(preOrder, inOrder);
        assert Arrays.stream(preOrder).boxed().collect(Collectors.toList()).equals(preOrderTravel(root));
        assert Arrays.stream(inOrder).boxed().collect(Collectors.toList()).equals(inOrderTravel(root));
    }

    @Test
    public void testCase2() {
        Offer7 offer7 = new Offer7();
        int[] preOrder = new int[]{-1};
        int[] inOrder = new int[]{-1};
        TreeNode root = offer7.buildTree(preOrder, inOrder);
        assert Arrays.stream(preOrder).boxed().collect(Collectors.toList()).equals(preOrderTravel(root));
        assert Arrays.stream(inOrder).boxed().collect(Collectors.toList()).equals(inOrderTravel(root));
    }
}
