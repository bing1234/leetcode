package com.geekbing.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bing
 */
public class LeetCode5759 {
    List<List<Integer>> ans;

    public int subsetXORSum(int[] nums) {
        // 先求出所有子集
        ans = subsets(nums);

        // 再求所有子集的异或和
        int sum = 0;
        for (List<Integer> subSet : ans) {
            sum += xorSum(subSet);
        }
        return sum;
    }

    private int xorSum(List<Integer> set) {
        int ans = 0;
        for (int num : set) {
            ans = ans ^ num;
        }
        return ans;
    }

    private List<List<Integer>> subsets(int[] nums) {
        ans = new ArrayList<>();
        backtrack(new ArrayList<>(), nums, 0);
        return ans;
    }

    private void backtrack(List<Integer> cur, int[] nums, int i) {
        ans.add(new ArrayList<>(cur));
        for (int j = i; j < nums.length; j++) {
            cur.add(nums[j]);
            backtrack(cur, nums, j + 1);
            cur.remove(cur.size() - 1);
        }
    }

    public static void main(String[] args) {
        LeetCode5759 leetCode5759 = new LeetCode5759();
        System.out.println(leetCode5759.subsetXORSum(new int[]{1, 3}));
        System.out.println(leetCode5759.subsetXORSum(new int[]{5, 1, 6}));
        System.out.println(leetCode5759.subsetXORSum(new int[]{3, 4, 5, 6, 7, 8}));
    }
}
