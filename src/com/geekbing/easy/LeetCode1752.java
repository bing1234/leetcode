package com.geekbing.easy;

public class LeetCode1752 {
    public boolean check(int[] nums) {
        // 找出第一个转折点
        int idx = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                idx = i + 1;
                break;
            }
        }
        // 全部是从小到大排序
        if (idx == 0) {
            return true;
        }
        // 后面必须从小到大排序
        for (int i = idx; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                return false;
            }
        }
        // 最后一个元素不能大于第一个元素
        return nums[nums.length - 1] <= nums[0];
    }

    public static void main(String[] args) {
        LeetCode1752 leetCode1752 = new LeetCode1752();
        System.out.println(leetCode1752.check(new int[]{3, 4, 5, 1, 2}));
        System.out.println(leetCode1752.check(new int[]{2, 1, 3, 4}));
        System.out.println(leetCode1752.check(new int[]{1, 2, 3}));
        System.out.println(leetCode1752.check(new int[]{1, 1, 1}));
        System.out.println(leetCode1752.check(new int[]{2, 1}));
    }
}
