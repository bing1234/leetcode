package com.geekbing.hard;

public class LeetCode164 {
    public int maximumGap(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        if (min == max) {
            return 0;
        }
        int gap = (int) Math.ceil((double) (max - min) / (nums.length - 1));
        int[][] bucket = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            bucket[i][0] = Integer.MAX_VALUE;
            bucket[i][1] = Integer.MIN_VALUE;
        }
        for (int num : nums) {
            int idx = (num - min) / gap;
            bucket[idx][0] = Math.min(num, bucket[idx][0]);
            bucket[idx][1] = Math.max(num, bucket[idx][1]);
        }
        int maxGap = 0, pre = bucket[0][1];
        for (int i = 1; i < nums.length; i++) {
            if (bucket[i][0] > bucket[i][1]) {
                continue;
            }
            maxGap = Math.max(maxGap, bucket[i][0] - pre);
            pre = bucket[i][1];
        }
        return maxGap;
    }

    public static void main(String[] args) {
        LeetCode164 leetCode164 = new LeetCode164();
        System.out.println(leetCode164.maximumGap(new int[]{3, 6, 9, 1}));
        System.out.println(leetCode164.maximumGap(new int[]{10}));
    }
}
