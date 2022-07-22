package com.geekbing.middle;

/**
 * https://leetcode-cn.com/problems/sum-of-nodes-with-even-valued-grandparent/
 * 1315. 祖父节点值为偶数的节点和
 *
 * @author bing
 */
public class LeetCode1315 {
    public int sumEvenGrandparent(TreeNode root) {
        int ans = 0;
        if (root == null) {
            return ans;
        }
        if (root.val % 2 == 0) {
            if (root.left != null) {
                if (root.left.left != null) {
                    ans += root.left.left.val;
                }
                if (root.left.right != null) {
                    ans += root.left.right.val;
                }
            }
            if (root.right != null) {
                if (root.right.left != null) {
                    ans += root.right.left.val;
                }
                if (root.right.right != null) {
                    ans += root.right.right.val;
                }
            }
        }
        if (root.left != null) {
            ans += sumEvenGrandparent(root.left);
        }
        if (root.right != null) {
            ans += sumEvenGrandparent(root.right);
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode1315 leetCode1315 = new LeetCode1315();

        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.left.left = new TreeNode(9);
        root.left.right= new TreeNode(7);
        root.left.right.left=new TreeNode(1);
        root.left.right.right=new TreeNode(4);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(5);
        System.out.println(leetCode1315.sumEvenGrandparent(root));
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
