package com.geekbing.easy;

import java.util.Arrays;

public class LeetCode475 {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int ans = Integer.MIN_VALUE;
        for (int house : houses) {
            int radius = findMinRadius(house, heaters);
            ans = Math.max(ans, radius);
        }
        return ans;
    }

    /**
     * 找到最接近house的加热器，并返回两者距离
     */
    private int findMinRadius(int house, int[] heaters) {
        if (house < heaters[0]) {
            return heaters[0] - house;
        }
        if (house > heaters[heaters.length - 1]) {
            return house - heaters[heaters.length - 1];
        }
        // 找到第一个不小于house的heater
        int left = 0, right = heaters.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (heaters[mid] < house) {
                left = mid + 1;
            } else if (heaters[mid] == house) {
                return 0;
            } else {
                right = mid;
            }
        }
        if (right >= 1) {
            return Math.min(Math.abs(heaters[right - 1] - house), heaters[right] - house);
        } else {
            return heaters[right] - house;
        }
    }

    public static void main(String[] args) {
        LeetCode475 leetCode475 = new LeetCode475();
        System.out.println(leetCode475.findRadius(new int[]{1, 2, 3}, new int[]{2}));
        System.out.println(leetCode475.findRadius(new int[]{1, 2, 3, 4}, new int[]{1, 4}));
    }
}
