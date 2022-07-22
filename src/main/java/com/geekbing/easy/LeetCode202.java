package com.geekbing.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @author bing
 */
public class LeetCode202 {
    public boolean isHappy(int n) {
        Set<Integer> nums = new HashSet<>();
        nums.add(n);

        int num;
        while (true) {
            num = squareSum(n);
            if (num == 1) {
                return true;
            }
            if (nums.contains(num)) {
                return false;
            }
            nums.add(num);
            n = num;
        }
    }

    private int squareSum(int n) {
        int sum = 0;
        while (n != 0) {
            sum = sum + (n % 10) * (n % 10);
            n = n / 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        LeetCode202 leetCode202 = new LeetCode202();
        System.out.println(leetCode202.isHappy(19));
    }
}
