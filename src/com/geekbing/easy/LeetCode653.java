package com.geekbing.easy;

public class LeetCode653 {
    public boolean findTarget(TreeNode root, int k) {
        return false;
    }

    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left != right) {
            if (numbers[left] + numbers[right] == target) {
                return new int[]{left + 1, right + 1};
            } else if (numbers[left] + numbers[right] < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{};
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
