package com.geekbing.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode47 {
    private List<List<Integer>> result;

    public List<List<Integer>> permuteUnique(int[] nums) {
        result = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(new ArrayList<>(), new boolean[nums.length], nums);
        return result;
    }

    private void backtrack(List<Integer> path, boolean[] visited, int[] nums) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // 去重
            if (visited[i] || (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1])) {
                continue;
            }

            // 添加path并标记visited
            path.add(nums[i]);
            visited[i] = true;
            backtrack(path, visited, nums);

            // 回溯
            visited[i] = false;
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        LeetCode47 leetCode47 = new LeetCode47();
        System.out.println(leetCode47.permuteUnique(new int[]{1, 1, 2}));
        System.out.println(leetCode47.permuteUnique(new int[]{2, 2, 1, 1}));
    }
}
