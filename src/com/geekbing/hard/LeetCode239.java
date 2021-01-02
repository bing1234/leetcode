package com.geekbing.hard;

import java.util.Arrays;

public class LeetCode239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 1) {
            return nums;
        }
        int[] ans = new int[nums.length - k + 1];
        int ansIdx = 0, max = Integer.MIN_VALUE, maxIdx = 0;
        for (int i = 0; i < k; i++) {
            if (max <= nums[i]) {
                max = nums[i];
                maxIdx = i;
            }
        }
        ans[ansIdx++] = nums[maxIdx];
        int left = 1, right = k;
        for (int i = k; i < nums.length; i++) {
            if (maxIdx < left) {
                // 重新计算最大值
                max = Integer.MIN_VALUE;
                maxIdx = left;
                for (int j = left; j <= right; j++) {
                    if (max <= nums[j]) {
                        max = nums[j];
                        maxIdx = j;
                    }
                }
            } else {
                if (max <= nums[i]) {
                    max = nums[i];
                    maxIdx = i;
                }
            }
            ans[ansIdx++] = nums[maxIdx];
            left++;
            right++;
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode239 leetCode239 = new LeetCode239();
//        System.out.println(Arrays.toString(leetCode239.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
//        System.out.println(Arrays.toString(leetCode239.maxSlidingWindow(new int[]{1}, 1)));
//        System.out.println(Arrays.toString(leetCode239.maxSlidingWindow(new int[]{1, -1}, 1)));
//        System.out.println(Arrays.toString(leetCode239.maxSlidingWindow(new int[]{9, 11}, 2)));
//        System.out.println(Arrays.toString(leetCode239.maxSlidingWindow(new int[]{4, -2}, 2)));
//        System.out.println(Arrays.toString(leetCode239.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
        System.out.println(Arrays.toString(leetCode239.maxSlidingWindow(new int[]{7, 2, 4}, 2)));
    }
}
