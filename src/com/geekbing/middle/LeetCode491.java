package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author bing
 */
public class LeetCode491 {
    private final HashSet<List<Integer>> ans = new HashSet<>();
    private final List<Integer> temp = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        backtrack(nums, 0);
        return new ArrayList<>(ans);
    }

    private void backtrack(int[] nums, int idx) {
        if (temp.size() >= 2) {
            ans.add(new ArrayList<>(temp));
        }
        for (int i = idx; i < nums.length; i++) {
            if (temp.size() == 0 || nums[i] >= temp.get(temp.size() - 1)) {
                temp.add(nums[i]);
                backtrack(nums, i + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }

    @Test
    public void testCase1() {
        LeetCode491 leetCode491 = new LeetCode491();
        List<List<Integer>> ans = leetCode491.findSubsequences(new int[]{4, 6, 7, 7});
        List<List<Integer>> expert = new ArrayList<>();
        expert.add(new ArrayList<>(Arrays.asList(4, 6)));
        expert.add(new ArrayList<>(Arrays.asList(4, 6, 7)));
        expert.add(new ArrayList<>(Arrays.asList(4, 6, 7, 7)));
        expert.add(new ArrayList<>(Arrays.asList(4, 7)));
        expert.add(new ArrayList<>(Arrays.asList(4, 7, 7)));
        expert.add(new ArrayList<>(Arrays.asList(6, 7)));
        expert.add(new ArrayList<>(Arrays.asList(6, 7, 7)));
        expert.add(new ArrayList<>(Arrays.asList(7, 7)));
        ans.sort(this::compareList);
        expert.sort(this::compareList);
        assert expert.equals(ans);
    }

    private int compareList(List<Integer> list1, List<Integer> list2) {
        int len = Math.min(list1.size(), list2.size());
        for (int i = 0; i < len; i++) {
            int res = Integer.compare(list1.get(i), list2.get(i));
            if (res != 0) {
                return res;
            }
        }
        return Integer.compare(list1.size(), list2.size());
    }

    @Test
    public void testCase2() {
        LeetCode491 leetCode491 = new LeetCode491();
        List<List<Integer>> ans = leetCode491.findSubsequences(new int[]{4, 4, 3, 2, 1});
        List<List<Integer>> expert = new ArrayList<>();
        expert.add(new ArrayList<>(Arrays.asList(4, 4)));
        ans.sort(this::compareList);
        expert.sort(this::compareList);
        assert expert.equals(ans);
    }
}
