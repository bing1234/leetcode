package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode1037 {
    public boolean isBoomerang(int[][] points) {
        int x1 = points[0][0], y1 = points[0][1];
        int x2 = points[1][0], y2 = points[1][1];
        int x3 = points[2][0], y3 = points[2][1];

        if (x1 == x2 && x1 == x3) {
            return false;
        }
        if (y1 == y2 && y1 == y3) {
            return false;
        }
        return (x2 - x1) * (y3 - y1) != (x3 - x1) * (y2 - y1);
    }

    public static void main(String[] args) {
        LeetCode1037 leetCode1037 = new LeetCode1037();
        int[][] case1 = new int[3][2];
        case1[0] = new int[]{1, 1};
        case1[1] = new int[]{2, 3};
        case1[2] = new int[]{3, 2};
        System.out.println(leetCode1037.isBoomerang(case1));

        int[][] case2 = new int[3][2];
        case2[0] = new int[]{1, 1};
        case2[1] = new int[]{2, 2};
        case2[2] = new int[]{3, 3};
        System.out.println(leetCode1037.isBoomerang(case2));
    }
}
