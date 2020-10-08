package com.geekbing.easy;

public class LeetCode1217 {
    public int minCostToMoveChips(int[] position) {
        int oddCount = 0, evenCount = 0;
        for (int num : position) {
            if (num % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }
        return Math.min(oddCount, evenCount);
    }

    public static void main(String[] args) {
        LeetCode1217 leetCode1217 = new LeetCode1217();
        System.out.println(leetCode1217.minCostToMoveChips(new int[]{1, 2, 3}));
        System.out.println(leetCode1217.minCostToMoveChips(new int[]{2, 2, 2, 3, 3}));
    }
}
