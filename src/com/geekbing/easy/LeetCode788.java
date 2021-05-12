package com.geekbing.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author bing
 */
public class LeetCode788 {

    public int rotatedDigits(int N) {
        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (isGoodNum(i)) {
                count++;
            }
        }
        return count;
    }

    private boolean isGoodNum(int num) {
        int remainder;
        boolean flag = false;
        while (num != 0) {
            remainder = num % 10;
            if (remainder == 3 || remainder == 4 || remainder == 7) {
                return false;
            } else if (remainder == 2 || remainder == 5 || remainder == 6 || remainder == 9) {
                flag = true;
            }
            num = num / 10;
        }
        return flag;
    }

    public static void main(String[] args) {
        LeetCode788 leetCode788 = new LeetCode788();
        System.out.println(leetCode788.rotatedDigits(10));
    }
}
