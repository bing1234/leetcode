package com.geekbing.middle;

import java.util.Arrays;

public class LeetCode75 {
    public void sortColorsV2(int[] nums) {
        // 分别指向0，2下一个位置
        int p0 = 0, p2 = nums.length - 1;
        for (int i = p0; i <= p2; i++) {
            if (nums[i] == 0) {
                nums[i] = nums[p0];
                nums[p0] = 0;
                p0++;
            } else if (nums[i] == 2) {
                nums[i--] = nums[p2];
                nums[p2] = 2;
                p2--;
            }
        }
    }

    public void sortColors(int[] nums) {
        // 分别指向0，1，2下一个位置
        int p0 = 0, p1 = 0, p2 = 0;
        for (int num : nums) {
            switch (num) {
                case 2:
                    nums[p2] = 2;
                    p2++;
                    break;
                case 1:
                    nums[p1] = 1;
                    if (p2 > p1) {
                        nums[p2] = 2;
                    }
                    p1++;
                    p2++;
                    break;
                default:
                    nums[p0] = 0;
                    if (p1 > p0) {
                        nums[p1] = 1;
                    }
                    if (p2 > p1) {
                        nums[p2] = 2;
                    }
                    p0++;
                    p1++;
                    p2++;
                    break;
            }
        }
    }

    public static void main(String[] args) {
        LeetCode75 leetCode75 = new LeetCode75();
        int[] case1 = new int[]{2, 0, 2, 1, 1, 0};
        //leetCode75.sortColorsV2(case1);
        System.out.println(Arrays.toString(case1));

        int[] case2 = new int[]{1,2,0};
        leetCode75.sortColorsV2(case2);
        System.out.println(Arrays.toString(case2));
    }
}
