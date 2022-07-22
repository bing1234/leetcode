package com.geekbing.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author bing
 */
public class LeetCode653 {
    public boolean findTarget(TreeNode root, int k) {
        // 中序遍历得到从小到大排列的列表
        List<Integer> arrs = inOrderTravel(root);
        return twoSum(arrs, k);
    }

    private List<Integer> inOrderTravelV2(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        ans.addAll(inOrderTravelV2(root.left));
        ans.add(root.val);
        ans.addAll(inOrderTravelV2(root.right));
        return ans;
    }

    private List<Integer> inOrderTravel(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                if (node.right != null) {
                    stack.push(node.right);
                }
                stack.push(node);
                stack.push(null);
                if (node.left != null) {
                    stack.push(node.left);
                }
            } else {
                TreeNode cur = stack.pop();
                ans.add(cur.val);
            }
        }
        return ans;
    }

    private boolean twoSum(List<Integer> arrs, int target) {
        int left = 0, right = arrs.size() - 1;
        while (left != right) {
            int sum = arrs.get(left) + arrs.get(right);
            if (sum == target) {
                return true;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }

    private static final class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);

        LeetCode653 leetCode653 = new LeetCode653();
        System.out.println(leetCode653.findTarget(root, 9));
        System.out.println(leetCode653.findTarget(root, 28));
    }
}
