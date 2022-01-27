package com.geekbing.easy;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode1854 {
    private static final Integer BEGIN_YEAR = 1950;

    public int maximumPopulation(int[][] logs) {
        int[] years = new int[101];
        int maxNum = 0;
        for (int[] log : logs) {
            for (int i = log[0]; i < log[1]; i++) {
                years[i - BEGIN_YEAR]++;
                if (years[i - BEGIN_YEAR] > maxNum) {
                    maxNum = years[i - BEGIN_YEAR];
                }
            }
        }
        int maxYear = 1950;
        for (int i = 0; i < years.length; i++) {
            if (years[i] == maxNum) {
                return i + BEGIN_YEAR;
            }
        }
        return maxYear;
    }

    @Test
    public void testCase1() {
        LeetCode1854 leetCode1854 = new LeetCode1854();
        assert leetCode1854.maximumPopulation(new int[][]{{1993, 1999}, {2000, 2010}}) == 1993;
    }

    @Test
    public void testCase2() {
        LeetCode1854 leetCode1854 = new LeetCode1854();
        assert leetCode1854.maximumPopulation(new int[][]{{1950, 1961}, {1960, 1971}, {1970, 1981}}) == 1960;
    }
}
