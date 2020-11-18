package com.geekbing.middle;

public class LeetCode134 {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalLeft = 0;
        int currentLeft = 0;
        int startIdx = 0;
        for (int i = 0; i < gas.length; i++) {
            totalLeft += gas[i] - cost[i];
            currentLeft += gas[i] - cost[i];
            if (currentLeft < 0) {
                startIdx = i + 1;
                currentLeft = 0;
            }
        }
        if (totalLeft < 0) {
            return -1;
        }
        return startIdx;
    }

    public static void main(String[] args) {
        LeetCode134 leetCode134 = new LeetCode134();
        System.out.println(leetCode134.canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2}));
        System.out.println(leetCode134.canCompleteCircuit(new int[]{2, 3, 4}, new int[]{3, 4, 3}));
    }
}
