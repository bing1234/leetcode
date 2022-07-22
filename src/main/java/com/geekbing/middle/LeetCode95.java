package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bing
 */
public class LeetCode95 {
    public List<TreeNode> generateTrees(int n) {
        return generateTreesWithRange(1, n);
    }

    private List<TreeNode> generateTreesWithRange(int start, int end) {
        List<TreeNode> ans = new ArrayList<>();
        if (start == end) {
            ans.add(new TreeNode(start));
            return ans;
        }

        // start作为根节点
        List<TreeNode> rightNodes = generateTreesWithRange(start + 1, end);
        for (TreeNode right : rightNodes) {
            ans.add(new TreeNode(start, null, right));
        }

        for (int i = start + 1; i <= end - 1; i++) {
            // 生成左边
            List<TreeNode> lefts = generateTreesWithRange(start, i - 1);
            // 生成右边
            List<TreeNode> rights = generateTreesWithRange(i + 1, end);
            for (TreeNode left : lefts) {
                for (TreeNode right : rights) {
                    // i 作为根节点
                    ans.add(new TreeNode(i, left, right));
                }
            }
        }

        // end作为根节点
        List<TreeNode> leftNodes = generateTreesWithRange(start, end - 1);
        for (TreeNode left : leftNodes) {
            ans.add(new TreeNode(end, left, null));
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

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    @Test
    public void testCase1() {
        LeetCode95 leetCode95 = new LeetCode95();
        List<TreeNode> ans = leetCode95.generateTrees(3);
        assert ans.size() == 5;
    }

    @Test
    public void testCase2() {
        LeetCode95 leetCode95 = new LeetCode95();
        List<TreeNode> ans = leetCode95.generateTrees(1);
        assert ans.size() == 1;
    }
}
