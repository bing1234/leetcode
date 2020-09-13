package com.geekbing.easy;

import java.util.HashMap;
import java.util.Map;

public class LeetCode5511 {
    public int numSpecial(int[][] mat) {
        Map<Integer, Integer> rowMap = new HashMap<>();
        Map<Integer, Integer> colMap = new HashMap<>();
        for (int i = 0; i < mat.length; i++) {
            int count = 0;
            for (int num : mat[i]) {
                if (num == 1) {
                    count++;
                }
            }
            rowMap.put(i, count);
        }
        for (int j = 0; j < mat[0].length; j++) {
            int count = 0;
            for (int[] ints : mat) {
                if (ints[j] == 1) {
                    count++;
                }
            }
            colMap.put(j, count);
        }
        int ans = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1 &&
                        (rowMap.get(i) != null && rowMap.get(i) == 1) &&
                        (colMap.get(j) != null && colMap.get(j) == 1)) {
                    ans++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode5511 leetCode5511 = new LeetCode5511();
//        int[][] case1 = new int[3][3];
//        case1[0] = new int[]{1, 0, 0};
//        case1[1] = new int[]{0, 0, 1};
//        case1[2] = new int[]{1, 0, 0};
//        System.out.println(leetCode5511.numSpecial(case1));
//
//        int[][] case2 = new int[3][3];
//        case2[0] = new int[]{1, 0, 0};
//        case2[1] = new int[]{0, 1, 0};
//        case2[2] = new int[]{0, 0, 1};
//        System.out.println(leetCode5511.numSpecial(case2));

        int[][] case3 = new int[3][2];
        case3[0] = new int[]{0, 0};
        case3[1] = new int[]{0, 0};
        case3[2] = new int[]{1, 0};
        System.out.println(leetCode5511.numSpecial(case3));
    }
}
