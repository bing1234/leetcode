package com.geekbing.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/check-array-formation-through-concatenation/submissions/
 * 1640. 能否连接形成数组
 *
 * @author bing
 */
public class LeetCode1640 {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        // 开始元素对应的下标
        Map<Integer, Integer> startMap = new HashMap<>();
        for (int i = 0; i < pieces.length; i++) {
            startMap.put(pieces[i][0], i);
        }

        int idx1 = 0, cnt = 0;
        while (idx1 < arr.length) {
            Integer idx = startMap.get(arr[idx1]);
            if (idx == null) {
                return false;
            }
            int idx2 = 0;
            while (idx1 < arr.length && idx2 < pieces[idx].length) {
                if (arr[idx1] != pieces[idx][idx2]) {
                    return false;
                }
                idx1++;
                idx2++;
            }
            cnt++;
        }
        return idx1 == arr.length && cnt == pieces.length;
    }

    public static void main(String[] args) {
        LeetCode1640 leetCode1640 = new LeetCode1640();
        System.out.println(leetCode1640.canFormArray(new int[]{85}, new int[][]{{85}}));
        System.out.println(leetCode1640.canFormArray(new int[]{15, 88}, new int[][]{{88}, {15}}));
        System.out.println(leetCode1640.canFormArray(new int[]{49, 18, 16}, new int[][]{{16, 18, 49}}));
        System.out.println(leetCode1640.canFormArray(new int[]{91, 4, 64, 78}, new int[][]{{78}, {4, 64}, {91}}));
        System.out.println(leetCode1640.canFormArray(new int[]{1, 3, 5, 7}, new int[][]{{2, 4, 6, 8}}));
    }
}
