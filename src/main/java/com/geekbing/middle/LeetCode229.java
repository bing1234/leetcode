package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author bing
 */
public class LeetCode229 {
    public List<Integer> majorityElement(int[] nums) {
        int cnt = nums.length / 3;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer> ans = new ArrayList<>();
        map.forEach((key, val) -> {
            if (val > cnt) {
                ans.add(key);
            }
        });
        return ans;
    }

    @Test
    public void testCase1() {
        LeetCode229 leetCode229 = new LeetCode229();
        List<Integer> ans = leetCode229.majorityElement(new int[]{3, 2, 3});
        List<Integer> expert = new ArrayList<>(Collections.singletonList(3));
        assert expert.equals(ans);
    }

    @Test
    public void testCase2() {
        LeetCode229 leetCode229 = new LeetCode229();
        List<Integer> ans = leetCode229.majorityElement(new int[]{1});
        List<Integer> expert = new ArrayList<>(Collections.singletonList(1));
        assert expert.equals(ans);
    }

    @Test
    public void testCase3() {
        LeetCode229 leetCode229 = new LeetCode229();
        List<Integer> ans = leetCode229.majorityElement(new int[]{1, 1, 1, 3, 3, 2, 2, 2});
        List<Integer> expert = new ArrayList<>(Arrays.asList(1, 2));
        assert expert.equals(ans);
    }
}
