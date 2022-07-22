package com.geekbing.hard;

/**
 * @author bing
 */
public class LeetCode76 {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        int[][] nextIdxs = buildNextIdxs(s, t);
        int[] maxIdxs = calMaxIdxsEachCol(nextIdxs);
        int[] minWindowArr = calMinWindow(maxIdxs);
        if (minWindowArr[0] == -1) {
            return "";
        }
        return s.substring(minWindowArr[0], minWindowArr[1] + 1);
    }

    private int[] calMinWindow(int[] maxIdxs) {
        int minWindow = Integer.MAX_VALUE;
        int[] ans = new int[]{-1, -1};
        for (int i = 0; i < maxIdxs.length; i++) {
            if (maxIdxs[i] == -1) {
                continue;
            }
            if (minWindow > maxIdxs[i] - i + 1) {
                minWindow = maxIdxs[i] - i + 1;
                ans = new int[]{i, maxIdxs[i]};
            }
        }
        return ans;
    }

    private int[] calMaxIdxsEachCol(int[][] nextIdxs) {
        int[] maxIdxs = new int[nextIdxs[0].length];
        for (int col = 0; col < nextIdxs[0].length; col++) {
            int max = Integer.MIN_VALUE;
            for (int[] nextIdx : nextIdxs) {
                if (nextIdx[col] == -1) {
                    max = -1;
                    break;
                }
                max = Math.max(max, nextIdx[col]);
            }
            maxIdxs[col] = max;
        }
        return maxIdxs;
    }

    private int[][] buildNextIdxs(String s, String t) {
        int[][] nextIdxs = new int[t.length()][s.length()];
        for (int i = 0; i < t.length(); i++) {
            nextIdxs[i] = buildNextIdx(s, t.charAt(i));
        }
        return nextIdxs;
    }

    private int[] buildNextIdx(String s, char c) {
        int[] nextIdx = new int[s.length()];
        int idx = -1;
        for (int i = s.toCharArray().length - 1; i >= 0; i--) {
            if (s.charAt(i) == c) {
                idx = i;
            }
            nextIdx[i] = idx;
        }
        return nextIdx;
    }

    public static void main(String[] args) {
        LeetCode76 leetCode76 = new LeetCode76();
        System.out.println(leetCode76.minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(leetCode76.minWindow("ab", "b"));
        System.out.println(leetCode76.minWindow("a", "b"));
        System.out.println(leetCode76.minWindow("aa", "aa"));
    }
}
