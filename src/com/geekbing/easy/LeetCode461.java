package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode461 {
    public int hammingDistance(int x, int y) {
        int result = 0;

        int num = x ^ y;
        while (num != 0) {
            if (num % 2 == 1) {
                result++;
            }
            num = num / 2;
        }
        return result;
    }

    public static void main(String[] args) {
        LeetCode461 leetCode461 = new LeetCode461();
        System.out.println(leetCode461.hammingDistance(1, 4));
    }
}
