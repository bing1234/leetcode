package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author bing
 */
public class LeetCode652 {
    private final Map<String, Integer> tupleIdxMap = new HashMap<>();
    private final Map<Integer, Integer> idxCntMap = new HashMap<>();
    private final List<TreeNode> ans = new ArrayList<>();
    private int i = 1;

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        calNodeIdx(root);
        return ans;
    }

    private int calNodeIdx(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 当前节点的表示形式 = 左孩子标号,当前节点值,右孩子标号
        String tuple = calNodeIdx(root.left) + "," + root.val + "," + calNodeIdx(root.right);
        // 得到当前节点的标号
        int idx = tupleIdxMap.computeIfAbsent(tuple, x -> i++);
        // 更新标号对应的次数
        idxCntMap.put(idx, idxCntMap.getOrDefault(idx, 0) + 1);
        // 只有第二次遇到同样的标号才添加
        if (idxCntMap.get(idx) == 2) {
            ans.add(root);
        }
        return idx;
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
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        root.right.left.left = new TreeNode(4);
        root.right.right = new TreeNode(4);

        LeetCode652 leetCode652 = new LeetCode652();
        List<TreeNode> ans = leetCode652.findDuplicateSubtrees(root);

        assert ans != null && ans.size() == 2;
    }

    @Test
    public void testCase2() {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(1);

        LeetCode652 leetCode652 = new LeetCode652();
        List<TreeNode> ans = leetCode652.findDuplicateSubtrees(root);

        assert ans != null && ans.size() == 1;
        assert ans.get(0).val == 1;
    }

    @Test
    public void testCase3() {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        LeetCode652 leetCode652 = new LeetCode652();
        List<TreeNode> ans = leetCode652.findDuplicateSubtrees(root);

        assert ans != null && ans.size() == 2;
    }
}
