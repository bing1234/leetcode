package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode26 {
    public int removeDuplicates(int[] nums) {
        int oldPlace = 0, step = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[oldPlace]) {
                step++;
            } else {
                nums[i - step] = nums[i];
                oldPlace++;
            }
        }
        return oldPlace + 1;
    }

    public static void main(String[] args) {
        LeetCode26 leetCode26 = new LeetCode26();
        System.out.println(leetCode26.removeDuplicates(new int[]{1, 1, 2}));
        System.out.println(leetCode26.removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
    }
}
