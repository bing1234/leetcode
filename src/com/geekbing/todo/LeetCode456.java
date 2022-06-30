package com.geekbing.todo;

import org.junit.jupiter.api.Test;

/**
 * 解题思路，找到每一个山峰，然后朝左边找到山谷，朝右边找到小于山峰的最大数，看右边小于山峰的最大数是否大于左边的山谷
 *
 * @author bing
 */
public class LeetCode456 {
    public boolean find132pattern(int[] nums) {
        for (int i = 1; i < nums.length - 1; i++) {
            // 判断当前数是否是山峰
            if (isTop(nums, i)) {
                // 找到左边的山谷
                int left = findLeftDown(nums, i);
                // 朝右找到小于山峰的最大数
                int right = findRightSecond(nums, i);
                // 查看左边的山谷是否小于右边的数
                if (left < right) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isTop(int[] nums, int idx) {
        boolean left = false, right = false;
        // 左边是否存在小于山峰的数
        for (int i = idx - 1; i >= 0; i--) {
            if (nums[i] == nums[idx]) {
                continue;
            }
            if (nums[i] < nums[idx]) {
                left = true;
                break;
            }
        }
        for (int i = idx + 1; i < nums.length; i++) {
            if (nums[i] == nums[idx]) {
                continue;
            }
            if (nums[i] < nums[idx]) {
                right = true;
                break;
            }
        }
        return left && right;
    }

    private int findLeftDown(int[] nums, int idx) {
        int min = Integer.MAX_VALUE;
        for (int i = idx; i >= 1; i--) {
            if (nums[i - 1] > nums[i]) {
                break;
            }
            if (nums[i - 1] < min) {
                min = nums[i - 1];
            }
        }
        return min;
    }

    private int findRightSecond(int[] nums, int idx) {
        int max = Integer.MIN_VALUE;
        for (int i = idx + 1; i < nums.length; i++) {
            if (nums[i] < nums[idx] && nums[i] > max) {
                max = nums[i];
            }
        }
        return max;
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
        assert !leetCode456.find132pattern(new int[]{1, 0, 1, -4, -3});
    }

    @Test
    public void testCase5() {
        LeetCode456 leetCode456 = new LeetCode456();
        assert leetCode456.find132pattern(new int[]{3, 5, 0, 3, 4});
    }

    @Test
    public void testCase6() {
        LeetCode456 leetCode456 = new LeetCode456();
        assert !leetCode456.find132pattern(new int[]{-2, 1, 1, -2, 1, 1});
    }
}
