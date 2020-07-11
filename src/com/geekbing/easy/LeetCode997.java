package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode997 {
    public int findJudge(int N, int[][] trust) {
        int[] count = new int[N];
        for (int[] ints : trust) {
            count[ints[0] - 1]--;
            count[ints[1] - 1]++;
        }
        for (int i = 0; i < N; i++) {
            if (count[i] == N - 1) {
                return i + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        LeetCode997 leetCode997 = new LeetCode997();

        int[][] case1 = new int[1][2];
        case1[0] = new int[]{1, 2};
        System.out.println(leetCode997.findJudge(2, case1));

        int[][] case2 = new int[2][2];
        case2[0] = new int[]{1, 3};
        case2[1] = new int[]{2, 3};
        System.out.println(leetCode997.findJudge(3, case2));

        int[][] case3 = new int[3][2];
        case3[0] = new int[]{1, 3};
        case3[1] = new int[]{2, 3};
        case3[2] = new int[]{3, 1};
        System.out.println(leetCode997.findJudge(3, case3));

        int[][] case4 = new int[2][2];
        case4[0] = new int[]{1, 2};
        case4[1] = new int[]{2, 3};
        System.out.println(leetCode997.findJudge(3, case4));

        int[][] case5 = new int[5][2];
        case5[0] = new int[]{1, 3};
        case5[1] = new int[]{1, 4};
        case5[2] = new int[]{2, 3};
        case5[3] = new int[]{2, 4};
        case5[4] = new int[]{4, 3};
        System.out.println(leetCode997.findJudge(4, case5));
    }
}
