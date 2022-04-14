package com.geekbing;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode456 {
    public boolean find132pattern(int[] nums) {
        int i = 1;
        boolean up = false, down = false;

        // 检测是否存在上升
        while (i < nums.length) {
            if (nums[i - 1] < nums[i]) {
                up = true;
                break;
            }
            i++;
        }

        // 检测是否存在下降
        while (i < nums.length) {
            if (nums[i - 1] > nums[i]) {
                down = true;
                break;
            }
            i++;
        }
        return up && down;
    }

    @Test
    public void testCase1() {
        LeetCode456 leetCode456 = new LeetCode456();
        assert !leetCode456.find132pattern(new int[]{1, 2, 3, 4});
    }

    @Test
    public void testCase2() {
        LeetCode456 leetCode456 = new LeetCode456();
        assert leetCode456.find132pattern(new int[]{3, 1, 4, 2});
    }

    @Test
    public void testCase3() {
        LeetCode456 leetCode456 = new LeetCode456();
        assert leetCode456.find132pattern(new int[]{-1, 3, 2, 0});
    }

    @Test
    public void testCase4() {
        LeetCode456 leetCode456 = new LeetCode456();
        assert leetCode456.find132pattern(new int[]{1, 0, 1, -4, -3});
    }
}
