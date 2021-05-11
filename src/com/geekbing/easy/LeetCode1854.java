package com.geekbing.easy;

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

    public static void main(String[] args) {
        LeetCode1854 leetCode1854 = new LeetCode1854();
        System.out.println(leetCode1854.maximumPopulation(new int[][]{{1993, 1999}, {2000, 2010}}));
        System.out.println(leetCode1854.maximumPopulation(new int[][]{{1950, 1961}, {1960, 1971}, {1970, 1981}}));
        System.out.println(leetCode1854.maximumPopulation(new int[][]{{2033, 2034}, {2039, 2047}, {1998, 2042}, {2047, 2048}, {2025, 2029}, {2005, 2044}, {1990, 1992}, {1952, 1956}, {1984, 2014}}));
    }
}
