package com.geekbing.middle;

public class LeetCode1395 {
    public int numTeams(int[] rating) {
        // big[i] 表示第i个元素右边比其大的元素的个数
        int[] big = new int[rating.length];
        // small[i] 表示第i个元素右边比其小的元素的个数
        int[] small = new int[rating.length];
        for (int i = 0; i < rating.length; i++) {
            for (int j = i + 1; j < rating.length; j++) {
                if (rating[i] < rating[j]) {
                    big[i]++;
                }
                if (rating[i] > rating[j]) {
                    small[i]++;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < rating.length; i++) {
            for (int j = i + 1; j < rating.length; j++) {
                if (rating[i] < rating[j]) {
                    ans += big[j];
                }
                if (rating[i] > rating[j]) {
                    ans += small[j];
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode1395 leetCode1395 = new LeetCode1395();
        System.out.println(leetCode1395.numTeams(new int[]{2, 5, 3, 4, 1}));
        System.out.println(leetCode1395.numTeams(new int[]{2, 1, 3}));
        System.out.println(leetCode1395.numTeams(new int[]{1, 2, 3, 4}));
    }
}
