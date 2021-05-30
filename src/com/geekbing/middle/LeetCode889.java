package com.geekbing.middle;

/**
 * @author bing
 */
public class LeetCode889 {
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        return null;
    }

    public static void main(String[] args) {
        LeetCode889 leetCode889 = new LeetCode889();
        System.out.println(leetCode889.constructFromPrePost(new int[]{1, 2, 4, 5, 3, 6, 7}, new int[]{4, 5, 2, 6, 7, 3, 1}));
    }

    private static final class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
