package com.geekbing.middle;

/**
 * @author bing
 */
public class LeetCode33 {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int i = 1;
        if (nums[0] < target) {
            // 从前朝后查找
            while (i < nums.length - 1 && nums[i] < nums[i + 1]) {
                if (nums[i] < target) {
                    i++;
                } else if (nums[i] == target) {
                    return i;
                } else {
                    return -1;
                }
            }
            if (nums[i] == target) {
                return i;
            }
            if (i == nums.length - 1 && nums[i] == target) {
                return i;
            }
        } else if (nums[0] == target) {
            return 0;
        } else {
            // 从后朝前查找
            i = nums.length - 1;
            while (i > 0 && nums[i] > nums[i - 1]) {
                if (nums[i] < target) {
                    return -1;
                } else if (nums[i] == target) {
                    return i;
                } else {
                    i--;
                }
            }
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        LeetCode33 leetCode33 = new LeetCode33();

        System.out.println(leetCode33.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 7));
        System.out.println(leetCode33.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        System.out.println(leetCode33.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
        System.out.println(leetCode33.search(new int[]{1}, 0));
        System.out.println(leetCode33.search(new int[]{1}, 2));
    }
}
