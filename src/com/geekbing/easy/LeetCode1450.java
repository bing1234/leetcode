package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode1450 {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int count = 0;
        for (int i = 0; i < startTime.length; i++) {
            if (startTime[i] <= queryTime && queryTime <= endTime[i]) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        LeetCode1450 leetCode1450 = new LeetCode1450();
        System.out.println(leetCode1450.busyStudent(new int[]{1, 2, 3}, new int[]{3, 2, 7}, 4));
        System.out.println(leetCode1450.busyStudent(new int[]{4}, new int[]{4}, 4));
        System.out.println(leetCode1450.busyStudent(new int[]{4}, new int[]{4}, 5));
        System.out.println(leetCode1450.busyStudent(new int[]{1, 1, 1, 1}, new int[]{1, 3, 2, 4}, 7));
        System.out.println(leetCode1450.busyStudent(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1}, new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10}, 5));
    }
}
