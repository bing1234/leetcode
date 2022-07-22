package com.geekbing.easy;

import java.util.Arrays;

/**
 * @author bing
 */
public class LeetCode1646 {
    public int getMaximumGenerated(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int[] nums = new int[n + 1];
        nums[0] = 0;
        nums[1] = 1;
        for (int i = 1; i <= n; i++) {
            if (2 * i <= n) {
                nums[2 * i] = nums[i];
            }
            if (2 * i + 1 <= n) {
                nums[2 * i + 1] = nums[i] + nums[i + 1];
            }
        }
        return Arrays.stream(nums).max().getAsInt();
    }

    public static void main(String[] args) {
        LeetCode1646 leetCode1646 = new LeetCode1646();
        System.out.println(leetCode1646.getMaximumGenerated(7));
        System.out.println(leetCode1646.getMaximumGenerated(2));
        System.out.println(leetCode1646.getMaximumGenerated(3));
        System.out.println(leetCode1646.getMaximumGenerated(11));
    }
}
