package com.geekbing.offer;

import java.util.*;

/**
 * @author bing
 */
public class Offer32 {
    public int[] levelOrder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                result.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return result.stream().mapToInt(Integer::valueOf).toArray();
    }

    public static void main(String[] args) {
        Offer32 offer32 = new Offer32();
        TreeNode case1 = new TreeNode(3);
        case1.left = new TreeNode(9);
        case1.right = new TreeNode(20);
        case1.right.left = new TreeNode(15);
        case1.right.right = new TreeNode(7);
        System.out.println(Arrays.toString(offer32.levelOrder(case1)));

        System.out.println(Arrays.toString(offer32.levelOrder(null)));
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
