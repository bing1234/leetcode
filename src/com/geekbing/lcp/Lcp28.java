package com.geekbing.lcp;

import java.util.Arrays;

/**
 * @author bing
 */
public class Lcp28 {
    public int purchasePlans(int[] nums, int target) {
        Arrays.sort(nums);
        long ans = 0;
        int left = 0, right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] > target) {
                right--;
            } else {
                ans += right - left;
                left++;
            }
        }
        return (int) (ans % 1000000007);
    }

    private int binarySearch(int[] nums, int i, int target) {
        // 从下标[i + 1...nums.length - 1]中，找到最大的下标j保证nums[j] <= target - nums[i]
        target = target - nums[i];
        int left = i + 1, right = nums.length - 1, mid;
        while (right - left >= 2) {
            mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid;
            } else if (nums[mid] == target) {
                return mid;
            } else {
                left = mid;
            }
        }
        if (nums[right] <= target) {
            return right;
        }
        mid = left + (right - left) / 2;
        if (nums[mid] <= target) {
            return mid;
        }
        if (nums[left] <= target) {
            return left;
        }
        return -1;
    }

    public static void main(String[] args) {
        Lcp28 lcp28 = new Lcp28();
        System.out.println(lcp28.purchasePlans(new int[]{2, 5, 3, 5}, 6));
        System.out.println(lcp28.purchasePlans(new int[]{2, 2, 1, 9}, 10));
        System.out.println(lcp28.purchasePlans(new int[]{3, 1, 2}, 5));
        System.out.println(lcp28.purchasePlans(new int[]{43877, 10848, 10442, 48132, 83395, 71523, 60275, 39527}, 50642));
    }
}
