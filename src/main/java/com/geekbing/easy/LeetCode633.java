package com.geekbing.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @author bing
 */
public class LeetCode633 {
    public boolean judgeSquareSum(int c) {
        int left = 0;
        int right = (int) Math.sqrt(c), temp;
        while (left <= right) {
            temp = left * left + right * right;
            if (temp == c) {
                return true;
            } else if (temp < c) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }

    public boolean judgeSquareSumV2(int c) {
        int sqrt = (int) Math.sqrt(c);
        Set<Integer> square = new HashSet<>();
        for (int i = 0; i <= sqrt; i++) {
            square.add(i * i);
            if (square.contains(c - i * i)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LeetCode633 leetCode633 = new LeetCode633();
        System.out.println(leetCode633.judgeSquareSum(5));
        System.out.println(leetCode633.judgeSquareSum(3));
        System.out.println(leetCode633.judgeSquareSum(4));
        System.out.println(leetCode633.judgeSquareSum(2));
    }
}
