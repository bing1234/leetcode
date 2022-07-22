package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode191 {
    public int hammingWeight(int n) {
        int count = 0;

        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0){
                count++;
            }
            mask = mask << 1;
        }
        return count;
    }

    public static void main(String[] args) {
        LeetCode191 leetCode191 = new LeetCode191();

        System.out.println(leetCode191.hammingWeight(3));
        System.out.println(leetCode191.hammingWeight(1));
        System.out.println(leetCode191.hammingWeight(-3));
    }
}
