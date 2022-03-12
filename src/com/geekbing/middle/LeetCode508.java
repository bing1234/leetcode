package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author bing
 */
public class LeetCode508 {
    /**
     * 子数和-子数和出现的次数
     */
    private final Map<Integer, Integer> cntMap = new HashMap<>();

    public int[] findFrequentTreeSum(TreeNode root) {
        // 遍历树，不断统计子树和以及子数和出现的次数
        travelTree(root);

        // 得到次数和子树和的倒排Map
        Map<Integer, List<Integer>> reverseMap = buildReverseMap(cntMap);

        // 得到最大的次数
        int maxCnt = Optional.of(reverseMap.keySet().stream().max(Integer::compareTo)).get().orElse(0);

        // 得到最大次数对应的子树和
        return reverseMap.get(maxCnt).stream().mapToInt(Integer::valueOf).toArray();
    }

    private Map<Integer, List<Integer>> buildReverseMap(Map<Integer, Integer> cntMap) {
        Map<Integer, List<Integer>> reverseMap = new HashMap<>();
        cntMap.forEach((key, val) -> {
            List<Integer> list = reverseMap.getOrDefault(val, new ArrayList<>());
            list.add(key);
            reverseMap.put(val, list);
        });
        return reverseMap;
    }

    private int travelTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 当前和
        int curSum = root.val + travelTree(root.left) + travelTree(root.right);
        // 当前和的计数+1
        cntMap.put(curSum, cntMap.getOrDefault(curSum, 0) + 1);
        return curSum;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    @Test
    public void testCase1() {
        LeetCode508 leetCode508 = new LeetCode508();

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(-3);

        int[] ans = leetCode508.findFrequentTreeSum(root);
        int[] expert = new int[]{2, -3, 4};

        assert Arrays.equals(expert, ans);
    }

    @Test
    public void testCase2() {
        LeetCode508 leetCode508 = new LeetCode508();

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(-5);

        int[] ans = leetCode508.findFrequentTreeSum(root);
        int[] expert = new int[]{2};

        assert Arrays.equals(expert, ans);
    }
}
