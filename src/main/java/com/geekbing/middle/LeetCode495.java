package com.geekbing.middle;

public class LeetCode495 {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int lastEnd = -1, ans = 0;
        for (int startTime : timeSeries) {
            if (startTime > lastEnd) {
                ans += duration;
                lastEnd = startTime + duration;
            } else {
                if (startTime + duration > lastEnd) {
                    ans += startTime + duration - lastEnd;
                    lastEnd = startTime + duration;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode495 leetCode495 = new LeetCode495();
        System.out.println(leetCode495.findPoisonedDuration(new int[]{1, 4}, 2));
        System.out.println(leetCode495.findPoisonedDuration(new int[]{1, 2}, 2));
    }
}
