package com.geekbing;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author bing
 */
public class LeetCode1213 {
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> ans = new ArrayList<>();
        int idx1 = 0, idx2 = 0, idx3 = 0;
        while (idx1 < arr1.length && idx2 < arr2.length && idx3 < arr3.length) {
            if (arr1[idx1] == arr2[idx2] && arr2[idx2] == arr3[idx3]) {
                ans.add(arr1[idx1]);
                idx1++;
                idx2++;
                idx3++;
            } else if (arr1[idx1] <= arr2[idx2] && arr1[idx1] <= arr3[idx3]) {
                idx1++;
            } else if (arr2[idx2] <= arr1[idx1] && arr2[idx2] <= arr3[idx3]) {
                idx2++;
            } else if (arr3[idx3] <= arr1[idx1] && arr3[idx3] <= arr2[idx2]) {
                idx3++;
            }
        }
        return ans;
    }

    @Test
    public void testCase1() {
        LeetCode1213 leetCode1213 = new LeetCode1213();
        List<Integer> ans = leetCode1213.arraysIntersection(new int[]{1, 2, 3, 4, 5}, new int[]{1, 2, 5, 7, 9}, new int[]{1, 3, 4, 5, 8});
        List<Integer> expert = new ArrayList<>(Arrays.asList(1, 5));
        assert expert.equals(ans);
    }

    @Test
    public void testCase2() {
        LeetCode1213 leetCode1213 = new LeetCode1213();
        List<Integer> ans = leetCode1213.arraysIntersection(new int[]{197, 418, 523, 876, 1356}, new int[]{501, 880, 1593, 1710, 1870}, new int[]{521, 682, 1337, 1395, 1764});
        assert new ArrayList<>().equals(ans);
    }
}
