package com.geekbing.middle;

public class LeetCode672 {
    public int flipLights(int n, int m) {
        // 前3个开关可以决定后面的所有开关的状态，故只需要考虑前3个开关的状态
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return Math.min(2, 1 + m);
        } else if (n == 2) {
            return Math.min(4, 1 + 2 * m);
        } else {
            return Math.min(8, 1 + 3 * m);
        }
    }

    public static void main(String[] args) {
        LeetCode672 leetCode672 = new LeetCode672();
        System.out.println(leetCode672.flipLights(1, 1));
        System.out.println(leetCode672.flipLights(2, 1));
        System.out.println(leetCode672.flipLights(3, 1));
    }
}
