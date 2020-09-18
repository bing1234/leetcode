package com.geekbing.middle;

import java.util.ArrayList;
import java.util.List;

public class LeetCode46 {
    private List<List<Integer>> ans;

    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<>();
        if (nums.length == 0) {
            return ans;
        }
        List<Integer> items = new ArrayList<>();
        items.add(nums[0]);
        ans.add(items);
        backtrack(nums, 1);
        return ans;
    }

    private void backtrack(int[] nums, int i) {
        if (i == nums.length) {
            return;
        }
        List<List<Integer>> temp = new ArrayList<>();
        for (List<Integer> arr : ans) {
            for (int j = 0; j <= arr.size(); j++) {
                List<Integer> items = new ArrayList<>(arr);
                items.add(j, nums[i]);
                temp.add(items);
            }
        }
        ans = temp;
        backtrack(nums, i + 1);
    }

    public List<List<Integer>> permute2(int[] nums) {
        ans = new ArrayList<>();
        if (nums.length == 0) {
            return ans;
        }
        backtrack(new ArrayList<>(), new boolean[nums.length], nums);
        return ans;
    }

    private void backtrack(List<Integer> path, boolean[] visited, int[] nums) {
        if (path.size() == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            path.add(nums[i]);
            backtrack(path, visited, nums);

            // 回溯
            visited[i] = false;
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        LeetCode46 leetCode46 = new LeetCode46();
        System.out.println(leetCode46.permute(new int[]{1, 2, 3}));
        System.out.println(leetCode46.permute2(new int[]{1, 2, 3}));
    }
}
