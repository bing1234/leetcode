package com.geekbing.easy;

import java.util.Arrays;

public class LeetCode492 {
    public int[] constructRectangle(int area) {
        for (int i = (int) Math.sqrt(area); i >= 1; i--) {
            if (area % i == 0) {
                return new int[]{area / i, i};
            }
        }
        return new int[]{area, 1};
    }

    public static void main(String[] args) {
        LeetCode492 leetCode492 = new LeetCode492();
        System.out.println(Arrays.toString(leetCode492.constructRectangle(4)));
    }
}
