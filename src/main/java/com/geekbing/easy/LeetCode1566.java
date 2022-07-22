package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode1566 {
    public boolean containsPattern(int[] arr, int m, int k) {
        for (int i = 0; i <= arr.length - m * k; i++) {
            if (containLoop(arr, i, m, k)) {
                return true;
            }
        }
        return false;
    }

    private boolean containLoop(int[] arr, int begin, int m, int k) {
        int idx1 = begin, idx2 = begin + m;
        for (int j = 0; j < m * (k - 1); j++) {
            if (arr[idx1] != arr[idx2]) {
                return false;
            }
            idx1++;
            idx2++;
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode1566 leetCode1566 = new LeetCode1566();

        System.out.println(leetCode1566.containsPattern(new int[]{1, 2, 4, 1, 4, 1}, 2, 2));
        System.out.println(leetCode1566.containsPattern(new int[]{1, 2, 4, 4, 4, 4}, 1, 3));
        System.out.println(leetCode1566.containsPattern(new int[]{1, 2, 1, 2, 1, 1, 1, 3}, 2, 2));
        System.out.println(leetCode1566.containsPattern(new int[]{1, 2, 1, 2, 1, 3}, 2, 3));
        System.out.println(leetCode1566.containsPattern(new int[]{1, 2, 3, 1, 2}, 2, 2));
        System.out.println(leetCode1566.containsPattern(new int[]{2, 2, 2, 2}, 2, 3));
    }
}
