package com.geekbing.easy;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author bing
 */
public class LeetCode163 {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> ans = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            if (lower == upper) {
                ans.add(String.valueOf(lower));
            } else {
                ans.add(lower + "->" + upper);
            }
            return ans;
        }
        if (nums[0] - lower == 1) {
            ans.add(String.valueOf(lower));
        } else if (nums[0] - lower > 1) {
            ans.add(lower + "->" + (nums[0] - 1));
        }
        int pre = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - pre == 2) {
                ans.add(String.valueOf(pre + 1));
            } else if (nums[i] - pre > 2) {
                ans.add((pre + 1) + "->" + (nums[i] - 1));
            }
            pre = nums[i];
        }
        pre = nums[nums.length - 1];
        if (upper - pre == 1) {
            ans.add(String.valueOf(upper));
        } else if (upper - pre > 1) {
            ans.add((pre + 1) + "->" + upper);
        }
        return ans;
    }

    @Test
    public void testCase1() {
        LeetCode163 leetCode163 = new LeetCode163();
        List<String> ans = leetCode163.findMissingRanges(new int[]{0, 1, 3, 50, 75}, 0, 99);
        List<String> expert = new ArrayList<>(Arrays.asList("2", "4->49", "51->74", "76->99"));
        assert expert.equals(ans);
    }

    @Test
    public void testCase2() {
        LeetCode163 leetCode163 = new LeetCode163();
        List<String> ans = leetCode163.findMissingRanges(new int[]{}, 1, 1);
        List<String> expert = new ArrayList<>(Collections.singletonList("1"));
        assert expert.equals(ans);
    }
}
