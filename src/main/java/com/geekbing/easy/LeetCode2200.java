package com.geekbing.easy;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author bing
 */
public class LeetCode2200 {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        Set<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == key) {
                for (int idx = i - k; idx <= i + k; idx++) {
                    if (idx >= 0 && idx < nums.length) {
                        set.add(idx);
                    }
                }
            }
        }
        return new ArrayList<>(set);
    }

    public List<Integer> findKDistantIndicesV2(int[] nums, int key, int k) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == key) {
                // 最小下标
                int min = ans.isEmpty() ? Math.max(0, i - k) : Math.max(ans.get(ans.size() - 1) + 1, i - k);
                // 最大下标
                int max = Math.min(i + k, nums.length - 1);
                // 最小下标和最大下标之间的都可以
                for (int idx = min; idx <= max; idx++) {
                    ans.add(idx);
                }
            }
        }
        return ans;
    }

    @Test
    public void testCase1() {
        LeetCode2200 leetCode2200 = new LeetCode2200();
        List<Integer> ans = leetCode2200.findKDistantIndices(new int[]{3, 4, 9, 1, 3, 9, 5}, 9, 1);
        List<Integer> expert = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        assert expert.equals(ans);
    }

    @Test
    public void testCase2() {
        LeetCode2200 leetCode2200 = new LeetCode2200();
        List<Integer> ans = leetCode2200.findKDistantIndices(new int[]{2, 2, 2, 2, 2}, 2, 2);
        List<Integer> expert = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4));
        assert expert.equals(ans);
    }

    @Test
    public void testCase3() {
        LeetCode2200 leetCode2200 = new LeetCode2200();
        List<Integer> ans = leetCode2200.findKDistantIndices(new int[]{222, 151, 842, 244, 103, 736, 219, 432, 565, 216, 36, 198, 10, 367, 778, 111, 307, 460, 92, 622, 750, 36, 559, 983, 782, 432, 312, 111, 676, 179, 44, 86, 766, 371, 746, 905, 850, 170, 892, 80, 449, 932, 295, 875, 259, 556, 730, 441, 153, 869}, 153, 19);
        List<Integer> expert = new ArrayList<>(Arrays.asList(29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49));
        assert expert.equals(ans);
    }

    @Test
    public void testCase4() {
        LeetCode2200 leetCode2200 = new LeetCode2200();
        List<Integer> ans = leetCode2200.findKDistantIndicesV2(new int[]{3, 4, 9, 1, 3, 9, 5}, 9, 1);
        List<Integer> expert = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        assert expert.equals(ans);
    }

    @Test
    public void testCase5() {
        LeetCode2200 leetCode2200 = new LeetCode2200();
        List<Integer> ans = leetCode2200.findKDistantIndicesV2(new int[]{2, 2, 2, 2, 2}, 2, 2);
        List<Integer> expert = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4));
        assert expert.equals(ans);
    }

    @Test
    public void testCase6() {
        LeetCode2200 leetCode2200 = new LeetCode2200();
        List<Integer> ans = leetCode2200.findKDistantIndicesV2(new int[]{222, 151, 842, 244, 103, 736, 219, 432, 565, 216, 36, 198, 10, 367, 778, 111, 307, 460, 92, 622, 750, 36, 559, 983, 782, 432, 312, 111, 676, 179, 44, 86, 766, 371, 746, 905, 850, 170, 892, 80, 449, 932, 295, 875, 259, 556, 730, 441, 153, 869}, 153, 19);
        List<Integer> expert = new ArrayList<>(Arrays.asList(29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49));
        assert expert.equals(ans);
    }
}
