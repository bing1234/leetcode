package com.geekbing.middle;

/**
 * @author bing
 */
public class LeetCode560 {
    public int subarraySum(int[] nums, int k) {
        int ans = 0, total;
        for (int i = 0; i < nums.length; i++) {
            total = 0;
            for (int j = i; j < nums.length; j++) {
                total += nums[j];
                if (total == k) {
                    ans++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode560 leetCode560 = new LeetCode560();

        System.out.println(leetCode560.subarraySum(new int[]{1, 1, 1}, 2));
        System.out.println(leetCode560.subarraySum(new int[]{1, 2, 3}, 3));
        System.out.println(leetCode560.subarraySum(new int[]{206, -898, -376, -362, 956, 574, 469, -11, -661, 445, 134, -186, -56, 889, -7, 664, -106, 410, 191, -43, -605, 586, 486, 538, -447, 959, -401, -114, 587, 98, -13, 362, -991, 461, 269, 671, -214, 372, -343, 114, 601, -186, 231, 824, -497, -782, 309, -656, -612, -474, -834, 670, -76, 963, -262, 864, 786, 662, -616, 531, -352, -451, -865, 454, -139, 764, -363, -697, 623, 520, 741, 408, 57, 234, -155, 563, -141}, 558));
    }
}
