package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode1295 {
    public int findNumbers(int[] nums) {
        int count = 0;
        for (int num : nums) {
            if (lengthOfNumber(num) % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    private int lengthOfNumber(int number) {
        int length = 0;
        while (number != 0) {
            number = number / 10;
            length++;
        }
        return length;
    }

    public int findNumbersV2(int[] nums) {
        int count = 0;
        for (int num : nums) {
            if (String.valueOf(num).length() % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    public int findNumbersV3(int[] nums) {
        int count = 0;
        for (int num : nums) {
            if ((int) (Math.log10(num) + 1) % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        LeetCode1295 leetCode1295 = new LeetCode1295();
        System.out.println(leetCode1295.findNumbersV3(new int[]{12, 345, 2, 6, 7896}));
        System.out.println(leetCode1295.findNumbersV3(new int[]{555, 901, 482, 1771}));
    }
}
