package com.geekbing;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author bing
 */
public class LeetCode2032 {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        Map<Integer, Integer> map1 = buildMap(nums1);
        Map<Integer, Integer> map2 = buildMap(nums2);
        Map<Integer, Integer> map3 = buildMap(nums3);
        List<Integer> ans = new ArrayList<>();
        for (Integer num : map1.keySet()) {
            if (!map2.containsKey(num) && !map3.containsKey(num)) {
                continue;
            }
            ans.add(num);
        }
        for (Integer num : map2.keySet()) {
            if (!map1.containsKey(num) && map3.containsKey(num)) {
                ans.add(num);
            }
        }
        return ans;
    }

    private Map<Integer, Integer> buildMap(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return map;
    }

    @Test
    public void testCase1() {
        LeetCode2032 leetCode2032 = new LeetCode2032();
        List<Integer> ans = leetCode2032.twoOutOfThree(new int[]{1, 1, 3, 2}, new int[]{2, 3}, new int[]{3});
        List<Integer> expert = new ArrayList<>(Arrays.asList(3, 2));

        ans.sort(Integer::compareTo);
        expert.sort(Integer::compareTo);
        assert expert.equals(ans);
    }

    @Test
    public void testCase2() {
        LeetCode2032 leetCode2032 = new LeetCode2032();
        List<Integer> ans = leetCode2032.twoOutOfThree(new int[]{3, 1}, new int[]{2, 3}, new int[]{1, 2});
        List<Integer> expert = new ArrayList<>(Arrays.asList(2, 3, 1));
        ans.sort(Integer::compareTo);
        expert.sort(Integer::compareTo);
        assert expert.equals(ans);
    }

    @Test
    public void testCase3() {
        LeetCode2032 leetCode2032 = new LeetCode2032();
        List<Integer> ans = leetCode2032.twoOutOfThree(new int[]{1, 2, 2}, new int[]{4, 3, 3}, new int[]{5});
        ans.sort(Integer::compareTo);
        assert new ArrayList<>().equals(ans);
    }
}
