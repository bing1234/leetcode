package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author bing
 */
public class LeetCode870 {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        // 排序
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int[] arr = new int[nums1.length];
        int idx1 = nums1.length - 1;
        int idx2 = nums2.length - 1;
        while (idx1 >= 0 && idx2 >= 0) {
            while (idx2 >= 0 && nums1[idx1] <= nums2[idx2]) {
                idx2--;
            }
            if (idx2 < 0) {
                break;
            }
            arr[idx2] = nums1[idx1];
            idx1--;
        }

        return arr;
    }

    @Test
    public void testCase1() {
        LeetCode870 leetCode870 = new LeetCode870();
        int[] ans = leetCode870.advantageCount(new int[]{2, 7, 11, 15}, new int[]{1, 10, 4, 11});
        int[] expert = new int[]{2, 11, 7, 15};
        assert Arrays.equals(expert, ans);
    }

    @Test
    public void testCase2() {
        LeetCode870 leetCode870 = new LeetCode870();
        int[] ans = leetCode870.advantageCount(new int[]{12, 24, 8, 32}, new int[]{13, 25, 32, 11});
        int[] expert = new int[]{24, 32, 8, 12};
        assert Arrays.equals(expert, ans);
    }
}
