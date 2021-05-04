package com.geekbing.easy;

/**
 * @author bing
 */
public class Solution1848 {
    public int getMinDistance(int[] nums, int target, int start) {
        int max = Math.max(start, nums.length - 1 - start);
        for (int i = 0; i <= max; i++) {
            if (start - i >= 0 && nums[start - i] == target) {
                return i;
            }
            if (start + i < nums.length && nums[start + i] == target) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution1848 solution1848 = new Solution1848();
        System.out.println(solution1848.getMinDistance(new int[]{1, 2, 3, 4, 5}, 5, 3));
        System.out.println(solution1848.getMinDistance(new int[]{1}, 1, 0));
        System.out.println(solution1848.getMinDistance(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, 1, 0));
        System.out.println(solution1848.getMinDistance(new int[]{5, 3, 6}, 5, 2));
        System.out.println(solution1848.getMinDistance(new int[]{6444, 6071, 8024, 485, 7690, 713, 5055, 9719, 9473}, 5055, 2));
    }
}
