package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author bing
 */
public class LeetCode2161 {
    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer> small = new LinkedList<>();
        List<Integer> bigger = new LinkedList<>();
        int same = 0;
        for (int num : nums) {
            if (num < pivot) {
                small.add(num);
            } else if (num == pivot) {
                same++;
            } else {
                bigger.add(num);
            }
        }
        int[] ans = new int[nums.length];
        int idx = 0;
        for (int num : small) {
            ans[idx] = num;
            idx++;
        }
        for (int i = 0; i < same; i++) {
            ans[idx] = pivot;
            idx++;
        }
        for (int num : bigger) {
            ans[idx] = num;
            idx++;
        }
        return ans;
    }

    @Test
    public void testCase1() {
        LeetCode2161 leetCode2161 = new LeetCode2161();
        int[] ans = leetCode2161.pivotArray(new int[]{9, 12, 5, 10, 14, 3, 10}, 10);
        int[] expert = new int[]{9, 5, 3, 10, 10, 12, 14};
        assert Arrays.equals(expert, ans);
    }

    @Test
    public void testCase2() {
        LeetCode2161 leetCode2161 = new LeetCode2161();
        int[] ans = leetCode2161.pivotArray(new int[]{-3, 4, 3, 2}, 2);
        int[] expert = new int[]{-3, 2, 4, 3};
        assert Arrays.equals(expert, ans);
    }
}
