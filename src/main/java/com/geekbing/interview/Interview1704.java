package com.geekbing.interview;

import java.util.Arrays;

/**
 * @author bing
 */
public class Interview1704 {
    public int missingNumber(int[] nums) {
        return nums.length * (nums.length + 1) / 2 - Arrays.stream(nums).sum();
    }

    public static void main(String[] args) {
        Interview1704 interview1704 = new Interview1704();

        System.out.println(interview1704.missingNumber(new int[]{3, 0, 1}));
        System.out.println(interview1704.missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}));
    }
}
