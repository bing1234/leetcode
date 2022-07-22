package com.geekbing.easy;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author bing
 */
public class LeetCode2215 {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> set2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());
        Set<Integer> list1 = new HashSet<>();
        for (int num : nums1) {
            if (!set2.contains(num)) {
                list1.add(num);
            }
        }
        Set<Integer> list2 = new HashSet<>();
        for (int num : nums2) {
            if (!set1.contains(num)) {
                list2.add(num);
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>(list1));
        ans.add(new ArrayList<>(list2));
        return ans;
    }

    @Test
    public void testCase1() {
        LeetCode2215 leetCode2215 = new LeetCode2215();
        List<List<Integer>> ans = leetCode2215.findDifference(new int[]{1, 2, 3}, new int[]{2, 4, 6});
        List<List<Integer>> expert = new ArrayList<>();
        expert.add(new ArrayList<>(Arrays.asList(1, 3)));
        expert.add(new ArrayList<>(Arrays.asList(4, 6)));
        assert expert.equals(ans);
    }

    @Test
    public void testCase2() {
        LeetCode2215 leetCode2215 = new LeetCode2215();
        List<List<Integer>> ans = leetCode2215.findDifference(new int[]{1, 2, 3, 3}, new int[]{1, 1, 2, 2});
        List<List<Integer>> expert = new ArrayList<>();
        expert.add(new ArrayList<>(Collections.singletonList(3)));
        expert.add(new ArrayList<>());
        assert expert.equals(ans);
    }
}
