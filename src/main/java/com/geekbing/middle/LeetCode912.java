package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author bing
 */
public class LeetCode912 {
    /**
     * 归并所需的辅助数组
     */
    private int[] aux;

    public int[] sortArray(int[] nums) {
        aux = new int[nums.length];
        sort(nums, 0, nums.length - 1);
        return nums;
    }

    /**
     * 将数组nums[lo...hi]排序
     */
    private void sort(int[] nums, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        // 将左半边排序
        sort(nums, lo, mid);
        // 将右半边排序
        sort(nums, mid + 1, hi);
        // 归并两边排好序的结果
        merge(nums, lo, mid, hi);
    }

    /**
     * 将nums[lo...mid]和nums[mid+1...hi] 归并
     */
    private void merge(int[] nums, int lo, int mid, int hi) {
        // 将nums[lo...hi]复制到aux[lo...hi]
        System.arraycopy(nums, lo, aux, lo, hi + 1 - lo);

        // 归并回到nums[lo...hi]
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                nums[k] = aux[j++];
            } else if (j > hi) {
                nums[k] = aux[i++];
            } else if (aux[j] <= aux[i]) {
                nums[k] = aux[j++];
            } else {
                nums[k] = aux[i++];
            }
        }
    }

    @Test
    public void testCase1() {
        LeetCode912 leetCode912 = new LeetCode912();
        int[] ans = leetCode912.sortArray(new int[]{5, 2, 3, 1});
        int[] expert = new int[]{1, 2, 3, 5};
        assert Arrays.equals(expert, ans);
    }

    @Test
    public void testCase2() {
        LeetCode912 leetCode912 = new LeetCode912();
        int[] ans = leetCode912.sortArray(new int[]{5, 1, 1, 2, 0, 0});
        int[] expert = new int[]{0, 0, 1, 1, 2, 5};
        assert Arrays.equals(expert, ans);
    }
}
