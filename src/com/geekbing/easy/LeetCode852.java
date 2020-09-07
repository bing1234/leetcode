package com.geekbing.easy;

public class LeetCode852 {
    public int peakIndexInMountainArray(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (arr[middle + 1] > arr[middle]) {
                // 上坡路
                left = middle + 1;
            } else if (arr[middle - 1] > arr[middle]) {
                // 下坡路
                right = middle - 1;
            } else {
                return middle;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        LeetCode852 leetCode852 = new LeetCode852();
        System.out.println(leetCode852.peakIndexInMountainArray(new int[]{0, 1, 0}));
        System.out.println(leetCode852.peakIndexInMountainArray(new int[]{0, 2, 1, 0}));
    }
}
