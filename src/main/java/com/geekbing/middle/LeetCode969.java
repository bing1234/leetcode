package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author bing
 */
public class LeetCode969 {
    public List<Integer> pancakeSort(int[] arr) {
        return pancakeSortHelper(arr, arr.length);
    }

    private List<Integer> pancakeSortHelper(int[] arr, int len) {
        List<Integer> ans = new ArrayList<>();
        if (len <= 1) {
            return ans;
        }
        // 找到最大值和最大值的下标
        int max = Integer.MIN_VALUE, maxIdx = 0;
        for (int i = 0; i < len; i++) {
            if (arr[i] >= max) {
                max = arr[i];
                maxIdx = i;
            }
        }
        if (maxIdx == len - 1) {
            return pancakeSortHelper(arr, len - 1);
        }
        if (maxIdx != 0) {
            rotatePrefix(arr, maxIdx);
            ans.add(maxIdx + 1);
        }
        rotatePrefix(arr, len - 1);
        ans.add(len);
        ans.addAll(pancakeSortHelper(arr, len - 1));
        return ans;
    }

    private void rotatePrefix(int[] arr, int right) {
        int left = 0;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
    }

    @Test
    public void testCase1() {
        LeetCode969 leetCode969 = new LeetCode969();
        int[] arr = new int[]{3, 2, 4, 1};
        int[] temp = Arrays.copyOfRange(arr, 0, arr.length);
        List<Integer> ans = leetCode969.pancakeSort(arr);
        for (int num : ans) {
            rotatePrefix(temp, num - 1);
        }
        assert Arrays.equals(temp, new int[]{1, 2, 3, 4});
    }

    @Test
    public void testCase2() {
        LeetCode969 leetCode969 = new LeetCode969();
        int[] arr = new int[]{1, 2, 3};
        int[] temp = Arrays.copyOfRange(arr, 0, arr.length);
        List<Integer> ans = leetCode969.pancakeSort(arr);
        for (int num : ans) {
            rotatePrefix(temp, num - 1);
        }
        assert Arrays.equals(temp, new int[]{1, 2, 3});
    }
}
