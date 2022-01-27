package com.geekbing.easy;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author bing
 */
public class LeetCode2089 {
    public List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                ans.add(i);
            }
        }
        return ans;
    }

    @Test
    public void testCase1() {
        LeetCode2089 leetCode2089 = new LeetCode2089();
        List<Integer> ans = leetCode2089.targetIndices(new int[]{1, 2, 5, 2, 3}, 2);
        List<Integer> expert = new ArrayList<>(Arrays.asList(1, 2));
        assert expert.equals(ans);
    }

    @Test
    public void testCase2() {
        LeetCode2089 leetCode2089 = new LeetCode2089();
        List<Integer> ans = leetCode2089.targetIndices(new int[]{1, 2, 5, 2, 3}, 3);
        List<Integer> expert = new ArrayList<>(Collections.singletonList(3));
        assert expert.equals(ans);
    }

    @Test
    public void testCase3() {
        LeetCode2089 leetCode2089 = new LeetCode2089();
        List<Integer> ans = leetCode2089.targetIndices(new int[]{1, 2, 5, 2, 3}, 5);
        List<Integer> expert = new ArrayList<>(Collections.singletonList(4));
        assert expert.equals(ans);
    }

    @Test
    public void testCase4() {
        LeetCode2089 leetCode2089 = new LeetCode2089();
        List<Integer> ans = leetCode2089.targetIndices(new int[]{1, 2, 5, 2, 3}, 4);
        assert new ArrayList<>().equals(ans);
    }
}
