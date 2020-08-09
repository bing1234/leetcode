package com.geekbing.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * todo
 *
 * @author bing
 */
public class LeetCode1380 {
    public List<Integer> luckyNumbers(int[][] matrix) {
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        LeetCode1380 leetCode1380 = new LeetCode1380();
        int[][] case1 = new int[3][3];
        case1[0] = new int[]{3, 7, 8};
        case1[1] = new int[]{9, 11, 13};
        case1[2] = new int[]{15, 16, 17};
        System.out.println(leetCode1380.luckyNumbers(case1));

        int[][] case2 = new int[3][4];
        case2[0] = new int[]{1, 10, 4, 2};
        case2[1] = new int[]{9, 3, 8, 7};
        case2[2] = new int[]{15, 16, 17, 12};
        System.out.println(leetCode1380.luckyNumbers(case2));

        int[][] case3 = new int[2][2];
        case3[0] = new int[]{7, 8};
        case3[1] = new int[]{1, 2};
        System.out.println(leetCode1380.luckyNumbers(case3));
    }
}
