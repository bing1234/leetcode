package com.geekbing.easy;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode1150 {
    public boolean isMajorityElement(int[] nums, int target) {
        int preNum = nums[0], cnt = 1;
        for (int i = 1; i < nums.length; i++) {
            if (cnt == 0) {
                preNum = nums[i];
                cnt = 1;
            } else {
                if (nums[i] == preNum) {
                    cnt++;
                } else {
                    cnt--;
                }
            }
        }
        if (preNum != target) {
            return false;
        }
        cnt = 0;
        for (int num : nums) {
            if (num == preNum) {
                cnt++;
            }
        }
        return cnt > nums.length / 2;
    }

    @Test
    public void testCase1() {
        LeetCode1150 leetCode1150 = new LeetCode1150();
        assert leetCode1150.isMajorityElement(new int[]{2, 4, 5, 5, 5, 5, 5, 6, 6}, 5);
    }

    @Test
    public void testCase2() {
        LeetCode1150 leetCode1150 = new LeetCode1150();
        assert !leetCode1150.isMajorityElement(new int[]{10, 100, 101, 101}, 101);
    }
}
