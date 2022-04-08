package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author bing
 */
public class LeetCode398 {
    private static class Solution {
        private final Map<Integer, List<Integer>> map;
        private final Random random;

        public Solution(int[] nums) {
            map = new HashMap<>();
            random = new Random();
            for (int i = 0; i < nums.length; i++) {
                List<Integer> set = map.getOrDefault(nums[i], new ArrayList<>());
                set.add(i);
                map.put(nums[i], set);
            }
        }

        public int pick(int target) {
            List<Integer> list = map.get(target);
            return list.get(random.nextInt(list.size()));
        }
    }

    @Test
    public void testCase1() {
        Solution solution = new Solution(new int[]{1, 2, 3, 3, 3});

        // pick(3) 应该返回索引 2,3 或者 4。每个索引的返回概率应该相等。
        int ans = solution.pick(3);
        assert ans == 2 || ans == 3 || ans == 4;

        // pick(1) 应该返回 0。因为只有nums[0]等于1。
        assert solution.pick(1) == 0;
    }
}
