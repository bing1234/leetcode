package com.geekbing.middle;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bing
 */
public class LeetCode1305 {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> arr1 = traverseTree(root1);
        List<Integer> arr2 = traverseTree(root2);
        return merge(arr1, arr2);
    }

    private List<Integer> traverseTree(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> ans = new ArrayList<>();
        if (root.left != null) {
            ans.addAll(traverseTree(root.left));
        }
        ans.add(root.val);
        if (root.right != null) {
            ans.addAll(traverseTree(root.right));
        }
        return ans;
    }

    private List<Integer> merge(List<Integer> arr1, List<Integer> arr2) {
        List<Integer> arr = new ArrayList<>();
        int idx1 = 0, idx2 = 0;
        while (idx1 < arr1.size() && idx2 < arr2.size()) {
            if (arr1.get(idx1) < arr2.get(idx2)) {
                arr.add(arr1.get(idx1));
                idx1++;
            } else {
                arr.add(arr2.get(idx2));
                idx2++;
            }
        }
        while (idx1 < arr1.size()) {
            arr.add(arr1.get(idx1));
            idx1++;
        }
        while (idx2 < arr2.size()) {
            arr.add(arr2.get(idx2));
            idx2++;
        }
        return arr;
    }

    public static void main(String[] args) {
        LeetCode1305 leetCode1305 = new LeetCode1305();

        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(4);

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(0);
        root2.right = new TreeNode(3);

        System.out.println(leetCode1305.getAllElements(root1, root2));
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
