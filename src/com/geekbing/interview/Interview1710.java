package com.geekbing.interview;

public class Interview1710 {
    public int majorityElement(int[] nums) {
        int leftNum = nums[0], leftCount = 1;
        for (int i = 1; i < nums.length; i++) {
            if (leftCount == 0) {
                leftNum = nums[i];
                leftCount++;
            } else {
                if (nums[i] == leftNum) {
                    leftCount++;
                } else {
                    leftCount--;
                }
            }
        }
        leftCount = 0;
        for (int num : nums) {
            if (num == leftNum) {
                leftCount++;
            }
        }
        return leftCount > nums.length / 2 ? leftNum : -1;
    }

    public static void main(String[] args) {
        Interview1710 interview1710 = new Interview1710();
        System.out.println(interview1710.majorityElement(new int[]{1, 2, 5, 9, 5, 9, 5, 5, 5}));
        System.out.println(interview1710.majorityElement(new int[]{3, 2}));
        System.out.println(interview1710.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
    }
}
