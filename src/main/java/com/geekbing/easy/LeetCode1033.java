package com.geekbing.easy;

import java.util.Arrays;

/**
 * 1033. 移动石子直到连续
 * https://leetcode-cn.com/problems/moving-stones-until-consecutive/
 */
public class LeetCode1033 {
    public int[] numMovesStones(int a, int b, int c) {
        int min = a < b ? Math.min(a, c) : Math.min(b, c);
        int max = a < b ? Math.max(b, c) : Math.max(a, c);
        int second = a + b + c - min - max;

        // 三个数本来就是连续的特殊情况处理
        if (second - min == 1 && max - second == 1) {
            return new int[]{0, 0};
        }
        int minMoves = (second - min > 2 && max - second > 2) ? 2 : 1;
        int maxMoves = max - min - 2;
        return new int[]{minMoves, maxMoves};
    }

    public static void main(String[] args) {
        LeetCode1033 leetCode1033 = new LeetCode1033();
        System.out.println(Arrays.toString(leetCode1033.numMovesStones(1, 2, 5)));
        System.out.println(Arrays.toString(leetCode1033.numMovesStones(4, 3, 2)));
        System.out.println(Arrays.toString(leetCode1033.numMovesStones(3, 5, 1)));
    }
}
