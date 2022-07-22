package com.geekbing.middle;

/**
 * @author bing
 */
public class LeetCode477 {
    public int totalHammingDistance(int[] nums) {
        int ans = 0, len = nums.length, base = 1, count;
        for (int i = 0; i < 32; i++) {
            count = 0;
            for (int num : nums) {
                if ((base & num) == base) {
                    count++;
                }
            }
            ans += count * (len - count);
            base <<= 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode477 leetCode477 = new LeetCode477();

        System.out.println(leetCode477.totalHammingDistance(new int[]{4, 14, 2}));
        System.out.println(leetCode477.totalHammingDistance(new int[]{4, 14, 4}));
    }
}
