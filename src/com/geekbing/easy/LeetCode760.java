package com.geekbing.easy;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author bing
 */
public class LeetCode760 {
    public int[] anagramMappings(int[] nums1, int[] nums2) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            List<Integer> list = map.getOrDefault(nums2[i], new ArrayList<>());
            list.add(i);
            map.put(nums2[i], list);
        }
        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            List<Integer> list = map.get(nums1[i]);
            // 取最后一个数
            ans[i] = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            map.put(nums1[i], list);
        }
        return ans;
    }

    @Test
    public void testCase1() {
        LeetCode760 leetCode760 = new LeetCode760();
        int[] ans = leetCode760.anagramMappings(new int[]{12, 28, 46, 32, 50}, new int[]{50, 12, 32, 46, 28});
        int[] expert = new int[]{1, 4, 3, 2, 0};
        assert Arrays.equals(expert, ans);
    }
}
