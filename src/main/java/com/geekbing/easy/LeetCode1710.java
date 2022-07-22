package com.geekbing.easy;

import java.util.Arrays;

public class LeetCode1710 {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, ((o1, o2) -> o2[1] - o1[1]));
        int sum = 0, ans = 0;
        for (int[] boxType : boxTypes) {
            if (sum + boxType[0] <= truckSize) {
                sum += boxType[0];
                ans += boxType[0] * boxType[1];
            } else {
                // 临界点
                ans += boxType[1] * (truckSize - sum);
                return ans;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode1710 leetCode1710 = new LeetCode1710();
        System.out.println(leetCode1710.maximumUnits(new int[][]{{1, 3}, {2, 2}, {3, 1}}, 4));
        System.out.println(leetCode1710.maximumUnits(new int[][]{{5, 10}, {2, 5}, {4, 7}, {3, 9}}, 10));
    }
}
