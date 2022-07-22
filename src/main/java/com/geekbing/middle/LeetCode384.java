package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * @author bing
 */
public class LeetCode384 {
    private static class Solution {
        private final int[] nums;
        private final int[] origin;

        public Solution(int[] nums) {
            this.nums = nums;
            this.origin = new int[nums.length];
            System.arraycopy(nums, 0, origin, 0, nums.length);
        }

        public int[] reset() {
            System.arraycopy(origin, 0, nums, 0, nums.length);
            return nums;
        }

        public int[] shuffle() {
            int len = nums.length;

            Random random = new Random();
            // 每次产生1个随机数与当前元素交换位置
            for (int i = 0; i < len; i++) {
                int idx = random.nextInt(len);
                int temp = nums[idx];
                nums[idx] = nums[i];
                nums[i] = temp;
            }
            return nums;
        }
    }

    @Test
    public void testCase1() {
        int[] origin = new int[]{1, 2, 3};
        Solution solution = new Solution(origin);

        int[] ans = solution.shuffle();
        Arrays.sort(ans);
        assert Arrays.equals(ans, origin);

        ans = solution.reset();
        assert Arrays.equals(ans, origin);

        ans = solution.shuffle();
        Arrays.sort(ans);
        assert Arrays.equals(ans, origin);
    }
}
