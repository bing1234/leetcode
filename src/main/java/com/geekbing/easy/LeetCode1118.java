package com.geekbing.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author bing
 */
public class LeetCode1118 {
    private static final Set<Integer> MONTHS_31 = new HashSet<>(Arrays.asList(1, 3, 5, 7, 8, 10, 12));
    private static final Set<Integer> MONTHS_30 = new HashSet<>(Arrays.asList(4, 6, 9, 11));

    public int numberOfDays(int year, int month) {
        if (MONTHS_31.contains(month)) {
            return 31;
        }
        if (MONTHS_30.contains(month)) {
            return 30;
        }
        if ((year % 400 == 0) || (year % 100 != 0 && year % 4 == 0)) {
            return 29;
        }
        return 28;
    }

    @Test
    public void testCase1() {
        LeetCode1118 leetCode1118 = new LeetCode1118();
        assert leetCode1118.numberOfDays(1992, 7) == 31;
    }

    @Test
    public void testCase2() {
        LeetCode1118 leetCode1118 = new LeetCode1118();
        assert leetCode1118.numberOfDays(2000, 2) == 29;
    }

    @Test
    public void testCase3() {
        LeetCode1118 leetCode1118 = new LeetCode1118();
        assert leetCode1118.numberOfDays(1900, 2) == 28;
    }
}
