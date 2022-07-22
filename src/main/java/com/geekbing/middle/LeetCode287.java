package com.geekbing.middle;

public class LeetCode287 {
    public int findDuplicate(int[] nums) {
        int slow = nums[0], fast = nums[0];
        while (true) {
            slow = nums[slow];
            fast = nums[fast];
            fast = nums[fast];
            if (slow == fast) {
                fast = nums[0];
                while (slow != fast) {
                    slow = nums[slow];
                    fast = nums[fast];
                }
                return slow;
            }
        }
    }

    public static void main(String[] args) {
        LeetCode287 leetCode287 = new LeetCode287();
        System.out.println(leetCode287.findDuplicate(new int[]{1, 3, 4, 2, 2}));
        System.out.println(leetCode287.findDuplicate(new int[]{3, 1, 3, 4, 2}));
    }
}
