package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode717 {
    public boolean isOneBitCharacter(int[] bits) {
        int i = 0;
        while (i < bits.length) {
            if (bits[i] == 1) {
                i += 2;
                if (i == bits.length) {
                    return false;
                }
            } else {
                i++;
                if (i == bits.length) {
                    return true;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode717 leetCode717 = new LeetCode717();
        System.out.println(leetCode717.isOneBitCharacter(new int[]{1, 0, 0}));
        System.out.println(leetCode717.isOneBitCharacter(new int[]{1, 1, 1, 0}));
    }
}
