package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode35 {
    public int searchInsert(int[] nums, int target) {
        int low = 0, high = nums.length - 1, mid = 0;
        if (target > nums[high]) {
            return nums.length;
        }
        if (target < nums[low]) {
            return 0;
        }
        while (low < high) {
            mid = low + (high - low) / 2;
            if (nums[mid] > target) {
                high = mid - 1;
            } else if (nums[mid] == target) {
                return mid;
            } else {
                low = mid + 1;
            }
        }
        if (nums[low] < target) {
            return low + 1;
        } else {
            return low;
        }
    }

    public static void main(String[] args) {
        LeetCode35 leetCode35 = new LeetCode35();
        System.out.println(leetCode35.searchInsert(new int[]{1, 3, 5, 6}, 2));
        System.out.println(leetCode35.searchInsert(new int[]{1, 3, 5}, 1));
        System.out.println(leetCode35.searchInsert(new int[]{1, 3}, 2));
    }
}
