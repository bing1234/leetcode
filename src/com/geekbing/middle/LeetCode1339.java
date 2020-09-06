package com.geekbing.middle;

import java.util.Stack;

/**
 * todo
 * @author bing
 */
public class LeetCode1339 {
    public int maxProduct(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int total = sumOfTree(root);
        long max = Integer.MIN_VALUE;
        long subSum;
        long temp;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            if (node.left != null) {
                subSum = sumOfTree(node.left);
                temp = subSum * (total - subSum);
                if (max < temp) {
                    max = temp;
                }

                stack.push(node.left);
            }
            if (node.right != null) {
                subSum = sumOfTree(node.right);
                temp = subSum * (total - subSum);
                if (max < temp) {
                    max = temp;
                }
                stack.push(node.right);
            }
        }
        return (int) max;
    }

    private int sumOfTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = root.val;
        if (root.left != null) {
            sum = sum + sumOfTree(root.left);
        }
        if (root.right != null) {
            sum = sum + sumOfTree(root.right);
        }
        return sum;
    }

    public static void main(String[] args) {
        LeetCode1339 leetCode1339 = new LeetCode1339();
        TreeNode case1 = new TreeNode(1);
        case1.left = new TreeNode(2);
        case1.left.left = new TreeNode(4);
        case1.left.right = new TreeNode(5);
        case1.right = new TreeNode(3);
        case1.right.left = new TreeNode(6);
        System.out.println(leetCode1339.maxProduct(case1));

        TreeNode case2 = new TreeNode(1);
        case2.right = new TreeNode(2);
        case2.right.left = new TreeNode(3);
        case2.right.right = new TreeNode(4);
        case2.right.right.left = new TreeNode(5);
        case2.right.right.right = new TreeNode(6);
        System.out.println(leetCode1339.maxProduct(case2));

        TreeNode case3 = new TreeNode(2);
        case3.left = new TreeNode(3);
        case3.left.left = new TreeNode(10);
        case3.left.left.left = new TreeNode(5);
        case3.left.left.right = new TreeNode(4);
        case3.left.right = new TreeNode(7);
        case3.left.right.left = new TreeNode(11);
        case3.left.right.right = new TreeNode(1);
        case3.right = new TreeNode(9);
        case3.right.left = new TreeNode(8);
        case3.right.right = new TreeNode(6);
        System.out.println(leetCode1339.maxProduct(case3));

        TreeNode case4 = new TreeNode(1);
        case4.left = new TreeNode(1);
        System.out.println(leetCode1339.maxProduct(case4));
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