package com.geekbing.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @author bing
 */
public class LeetCode1346 {
    public boolean checkIfExist(int[] arr) {
        Set<Integer> nums = new HashSet<>();
        for (int num : arr) {
            if (nums.contains(num * 2)) {
                return true;
            }
            if (num % 2 == 0 && nums.contains(num / 2)) {
                return true;
            }
            nums.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        LeetCode1346 leetCode1346 = new LeetCode1346();
        System.out.println(leetCode1346.checkIfExist(new int[]{10, 2, 5, 3}));
        System.out.println(leetCode1346.checkIfExist(new int[]{7, 1, 14, 11}));
        System.out.println(leetCode1346.checkIfExist(new int[]{3, 1, 7, 11}));
    }
}
