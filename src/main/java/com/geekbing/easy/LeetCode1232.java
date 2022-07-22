package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode1232 {
    public boolean checkStraightLine(int[][] coordinates) {
        // 竖线
        if (coordinates[0][0] == coordinates[1][0]) {
            for (int i = 1; i < coordinates.length - 1; i++) {
                if (coordinates[i][0] != coordinates[i + 1][0]) {
                    return false;
                }
            }
            return true;
        }
        // 横线
        if (coordinates[0][1] == coordinates[1][1]) {
            for (int i = 1; i < coordinates.length - 1; i++) {
                if (coordinates[i][1] != coordinates[i + 1][1]) {
                    return false;
                }
            }
            return true;
        }
        // 斜线
        int diffX = coordinates[1][0] - coordinates[0][0];
        int diffY = coordinates[1][1] - coordinates[0][1];
        for (int i = 2; i < coordinates.length; i++) {
            if (diffX * (coordinates[i][1] - coordinates[0][1]) != diffY * (coordinates[i][0] - coordinates[0][0])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode1232 leetCode1232 = new LeetCode1232();

        int[][] case1 = new int[6][2];
        case1[0] = new int[]{1, 2};
        case1[1] = new int[]{2, 3};
        case1[2] = new int[]{3, 4};
        case1[3] = new int[]{4, 5};
        case1[4] = new int[]{5, 6};
        case1[5] = new int[]{6, 7};
        System.out.println(leetCode1232.checkStraightLine(case1));

        int[][] case2 = new int[6][2];
        case2[0] = new int[]{1, 1};
        case2[1] = new int[]{2, 2};
        case2[2] = new int[]{3, 4};
        case2[3] = new int[]{4, 5};
        case2[4] = new int[]{5, 6};
        case2[5] = new int[]{7, 7};
        System.out.println(leetCode1232.checkStraightLine(case2));

        int[][] case3 = new int[3][2];
        case3[0] = new int[]{1, 2};
        case3[1] = new int[]{2, 3};
        case3[2] = new int[]{3, 5};
        System.out.println(leetCode1232.checkStraightLine(case3));
    }
}
