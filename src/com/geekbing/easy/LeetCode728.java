package com.geekbing.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bing
 */
public class LeetCode728 {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> nums = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (selfDividingNumber(i)) {
                nums.add(i);
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        LeetCode728 leetCode728 = new LeetCode728();
        List<Integer> result = leetCode728.selfDividingNumbers(1, 22);
        System.out.println(result);
    }

    private boolean selfDividingNumber(int num) {
        if (num == 0) {
            return false;
        }

        int newNum = num;
        int current;
        while (newNum != 0) {
            current = newNum % 10;
            if (current == 0) {
                return false;
            }

            if (num % current != 0) {
                return false;
            }

            newNum = newNum / 10;
        }
        return true;
    }
}
