package com.geekbing.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author bing
 */
public class LeetCode1337 {
    public int[] kWeakestRows(int[][] mat, int k) {
        List<Integer>[] idxMap = new List[Math.max(mat.length, mat[0].length) + 1];
        for (int i = 0; i < mat.length; i++) {
            int count = 0;
            for (int num : mat[i]) {
                if (num == 0) {
                    break;
                }
                count++;
            }
            if (idxMap[count] == null) {
                idxMap[count] = new ArrayList<>();
            }
            idxMap[count].add(i);
        }
        int[] ans = new int[k];
        int idx = 0;
        for (List<Integer> list : idxMap) {
            if (list == null) {
                continue;
            }
            list.sort(Integer::compareTo);
            for (Integer num : list) {
                if (idx == k) {
                    return ans;
                }
                ans[idx++] = num;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode1337 leetCode1337 = new LeetCode1337();
        System.out.println(Arrays.toString(leetCode1337.kWeakestRows(new int[][]{{1, 1, 0, 0, 0}, {1, 1, 1, 1, 0}, {1, 0, 0, 0, 0}, {1, 1, 0, 0, 0}, {1, 1, 1, 1, 1}}, 3)));
        System.out.println(Arrays.toString(leetCode1337.kWeakestRows(new int[][]{{1, 0, 0, 0}, {1, 1, 1, 1}, {1, 0, 0, 0}, {1, 0, 0, 0}}, 2)));
        System.out.println(Arrays.toString(leetCode1337.kWeakestRows(new int[][]{{1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1}}, 1)));
    }
}
