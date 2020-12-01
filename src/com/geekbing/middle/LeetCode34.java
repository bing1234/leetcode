package com.geekbing.middle;

import java.util.Arrays;

public class LeetCode34 {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        int leftIdx = find(nums, 0, nums.length - 1, target, true);
        int rightIdx = find(nums, 0, nums.length - 1, target, false);
        return new int[]{leftIdx, rightIdx};
    }

    private int find(int[] nums, int L, int R, int target, boolean lower) {
        if (L == R) {
            return nums[L] == target ? L : -1;
        }
        if (L + 1 == R) {
            if (lower) {
                if (nums[L] == target) {
                    return L;
                }
                if (nums[R] == target) {
                    return R;
                }
            } else {
                if (nums[R] == target) {
                    return R;
                }
                if (nums[L] == target) {
                    return L;
                }
            }
            return -1;
        }
        int left = L, right = R;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] == target) {
                if (lower) {
                    return find(nums, left, mid, target, lower);
                } else {
                    return find(nums, mid, right, target, lower);
                }
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        LeetCode34 leetCode34 = new LeetCode34();
        System.out.println(Arrays.toString(leetCode34.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
        System.out.println(Arrays.toString(leetCode34.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6)));
        System.out.println(Arrays.toString(leetCode34.searchRange(new int[]{}, 0)));
    }
}
