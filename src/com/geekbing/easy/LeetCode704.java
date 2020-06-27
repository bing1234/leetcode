package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode704 {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        int middle;
        while (low <= high) {
            middle = low + (high - low) / 2;
            if (nums[middle] > target) {
                high = middle - 1;
            } else if (nums[middle] == target) {
                return middle;
            } else {
                low = middle + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        LeetCode704 leetCode704 = new LeetCode704();
        System.out.println(leetCode704.search(new int[]{5}, 5));
        System.out.println(leetCode704.search(new int[]{-1, 0, 3, 5, 9, 12}, 9));
        System.out.println(leetCode704.search(new int[]{-1, 0, 3, 5, 9, 12}, 2));
    }
}
