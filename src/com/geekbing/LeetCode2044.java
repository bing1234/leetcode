package com.geekbing;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bing
 */
public class LeetCode2044 {
    public int countMaxOrSubsets(int[] nums) {
        // 得到最大的或
        int max = numsOr(nums);

        List<List<Integer>> lists = geneAllSubsets(nums);
        int ans = 0;
        for (List<Integer> list : lists) {
            if (numsOr(list) == max) {
                ans++;
            }
        }
        return ans;
    }

    private List<List<Integer>> geneAllSubsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        return ans;
    }

    private int numsOr(List<Integer> nums) {
        int ans = 1;
        for (int num : nums) {
            ans |= num;
        }
        return ans;
    }

    private int numsOr(int[] nums) {
        int ans = 1;
        for (int num : nums) {
            ans |= num;
        }
        return ans;
    }

    @Test
    public void testCase1() {
        LeetCode2044 leetCode2044 = new LeetCode2044();
        assert leetCode2044.countMaxOrSubsets(new int[]{3, 1}) == 2;
    }

    @Test
    public void testCase2() {
        LeetCode2044 leetCode2044 = new LeetCode2044();
        assert leetCode2044.countMaxOrSubsets(new int[]{2, 2, 2}) == 7;
    }

    @Test
    public void testCase3() {
        LeetCode2044 leetCode2044 = new LeetCode2044();
        assert leetCode2044.countMaxOrSubsets(new int[]{3, 2, 1, 5}) == 6;
    }
}
