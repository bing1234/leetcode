package com.geekbing.middle;

/**
 * https://leetcode-cn.com/problems/single-number-ii/
 * 137. 只出现一次的数字 II
 * todo
 *
 * @author bing
 */
public class LeetCode137 {
    public int singleNumber(int[] nums) {
        for (int i = 0; i < 3; i++) {
            for (int num : nums) {

            }
        }
        return 0;
    }

    public static void main(String[] args) {
        LeetCode137 leetCode137 = new LeetCode137();
        System.out.println(leetCode137.singleNumber(new int[]{2, 2, 3, 2}));
        System.out.println(leetCode137.singleNumber(new int[]{0, 1, 0, 1, 0, 1, 99}));
    }
}
