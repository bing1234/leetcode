package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode278 {
    private int first;

    public LeetCode278(int first) {
        this.first = first;
    }

    public int firstBadVersion(int n) {
        int low = 1, high = n, middle;
        while (low <= high) {
            if (high - low <= 1) {
                return isBadVersion(low) ? low : high;
            }
            middle = low + (high - low) / 2;
            if (isBadVersion(middle)) {
                high = middle;
            } else {
                low = middle;
            }
        }
        return low;
    }

    boolean isBadVersion(int version) {
        return version >= first;
    }

    public static void main(String[] args) {
        LeetCode278 solution278 = new LeetCode278(5);
        System.out.println(solution278.firstBadVersion(4));
    }
}
