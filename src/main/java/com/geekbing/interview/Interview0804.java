package com.geekbing.interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Interview0804 {
    public List<List<Integer>> subsets(int[] nums) {
        return subsets(nums, nums.length);
    }

    private List<List<Integer>> subsets(int[] nums, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        if (n == 0) {
            return ans;
        }
        if (n == 1) {
            ans.add(new ArrayList<>());
            ans.add(new ArrayList<>(Collections.singletonList(nums[0])));
            return ans;
        }
        List<List<Integer>> subs = subsets(nums, n - 1);
        // 第n个元素不选择
        ans.addAll(subs);
        // 第n个元素选择
        for (List<Integer> sub : subs) {
            List<Integer> item = new ArrayList<>(sub);
            item.add(nums[n - 1]);
            ans.add(item);
        }
        return ans;
    }

    public static void main(String[] args) {
        Interview0804 interview0804 = new Interview0804();
        System.out.println(interview0804.subsets(new int[]{1}));
        System.out.println(interview0804.subsets(new int[]{1, 2}));
        System.out.println(interview0804.subsets(new int[]{1, 2, 3}));
    }
}
