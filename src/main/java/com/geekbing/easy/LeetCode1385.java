package com.geekbing.easy;

import java.util.Arrays;

public class LeetCode1385 {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int ans = 0;
        for (int num : arr1) {
            if (findMinDistance(num, arr2) > d) {
                ans++;
            }
        }
        return ans;
    }

    private int findMinDistance(int num, int[] arr) {
        if (num < arr[0]) {
            return arr[0] - num;
        }
        if (num > arr[arr.length - 1]) {
            return num - arr[arr.length - 1];
        }
        int left = 0, right = arr.length - 1, mid;
        // 找到第一个不小于num的数
        while (left < right) {
            mid = left + (right - left) / 2;
            if (arr[mid] < num) {
                left = mid + 1;
            } else if (arr[mid] == num) {
                return 0;
            } else {
                right = mid;
            }
        }
        if (right >= 1) {
            return Math.min(Math.abs(arr[right - 1] - num), arr[right] - num);
        }
        return arr[right] - num;
    }

    public static void main(String[] args) {
        LeetCode1385 leetCode1385 = new LeetCode1385();
        System.out.println(leetCode1385.findTheDistanceValue(new int[]{4, 5, 8}, new int[]{10, 9, 1, 8}, 2));
        System.out.println(leetCode1385.findTheDistanceValue(new int[]{1, 4, 2, 3}, new int[]{-4, -3, 6, 10, 20, 30}, 3));
        System.out.println(leetCode1385.findTheDistanceValue(new int[]{2, 1, 100, 3}, new int[]{-5, -2, 10, -3, 7}, 6));
    }
}
