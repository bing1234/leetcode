package com.geekbing.easy;

import java.util.Arrays;

public class LeetCode1356 {
    public int[] sortByBits(int[] arr) {
        return Arrays.stream(arr).boxed().sorted((o1, o2) -> {
            Integer count1 = countOfBit(o1);
            Integer count2 = countOfBit(o2);
            if (!count1.equals(count2)) {
                return count1.compareTo(count2);
            }
            return o1.compareTo(o2);
        }).mapToInt(num -> num).toArray();
    }

    public int[] sortByBitsV2(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] += Integer.bitCount(arr[i]) * 100000;
        }
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            arr[i] %= 100000;
        }
        return arr;
    }

    private Integer countOfBit(int num) {
        int ans = 0;
        while (num != 0) {
            if ((num & 1) == 1) {
                ans++;
            }
            num = num >> 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode1356 leetCode1356 = new LeetCode1356();
        System.out.println(Arrays.toString(leetCode1356.sortByBits(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8})));
        System.out.println(Arrays.toString(leetCode1356.sortByBits(new int[]{1024, 512, 256, 128, 64, 32, 16, 8, 4, 2, 1})));
        System.out.println(Arrays.toString(leetCode1356.sortByBits(new int[]{10000, 10000})));
        System.out.println(Arrays.toString(leetCode1356.sortByBits(new int[]{2, 3, 5, 7, 11, 13, 17, 19})));
        System.out.println(Arrays.toString(leetCode1356.sortByBits(new int[]{10, 100, 1000, 10000})));
    }
}
