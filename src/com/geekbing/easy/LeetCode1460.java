package com.geekbing.easy;

import java.util.Arrays;

/**
 * @author bing
 */
public class LeetCode1460 {
    public boolean canBeEqual(int[] target, int[] arr) {
        if (target.length != arr.length) {
            return false;
        }
        Arrays.sort(target);
        Arrays.sort(arr);
        for (int i = 0; i < target.length; i++) {
            if (target[i] != arr[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode1460 leetCode1460 = new LeetCode1460();
        System.out.println(leetCode1460.canBeEqual(new int[]{1, 2, 3, 4}, new int[]{2, 4, 1, 3}));
        System.out.println(leetCode1460.canBeEqual(new int[]{7}, new int[]{7}));
        System.out.println(leetCode1460.canBeEqual(new int[]{1, 12}, new int[]{12, 1}));
        System.out.println(leetCode1460.canBeEqual(new int[]{3, 7, 9}, new int[]{3, 7, 11}));
        System.out.println(leetCode1460.canBeEqual(new int[]{1, 1, 1, 1, 1}, new int[]{1, 1, 1, 1, 1}));
    }
}
