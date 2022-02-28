package com.geekbing.middle;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode80 {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int cnt = 1, len = 1, i = 1;
        while (i < nums.length) {
            if (nums[i] == nums[i - 1]) {
                cnt++;
                if (cnt <= 2) {
                    nums[len] = nums[i];
                    len++;
                }
            } else {
                cnt = 1;
                nums[len] = nums[i];
                len++;
            }
            i++;
        }
        return len;
    }

    @Test
    public void testCase1() {
        LeetCode80 leetCode80 = new LeetCode80();
        assert leetCode80.removeDuplicates(new int[]{1, 1, 1, 2, 2, 3}) == 5;
    }

    @Test
    public void testCase2() {
        LeetCode80 leetCode80 = new LeetCode80();
        assert leetCode80.removeDuplicates(new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3}) == 7;
    }
}
