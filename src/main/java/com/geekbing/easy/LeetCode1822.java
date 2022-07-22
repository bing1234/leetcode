package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode1822 {
    public int arraySign(int[] nums) {
        int negativeNum = 0;
        for (int num : nums) {
            if (num == 0) {
                return 0;
            } else if (num < 0) {
                negativeNum++;
            }
        }
        return negativeNum % 2 == 0 ? 1 : -1;
    }

    public static void main(String[] args) {
        LeetCode1822 solution1822 = new LeetCode1822();
        System.out.println(solution1822.arraySign(new int[]{-1, -2, -3, -4, 3, 2, 1}));
        System.out.println(solution1822.arraySign(new int[]{1, 5, 0, 2, -3}));
        System.out.println(solution1822.arraySign(new int[]{-1, 1, -1, 1, -1}));
    }
}
