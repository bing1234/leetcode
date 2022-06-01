package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author bing
 */
public class LeetCode698 {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (nums.length < k) {
            return false;
        }

        // 倒排
        Integer[] sortNums = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(sortNums, Collections.reverseOrder());

        int sum = Arrays.stream(nums).sum();
        if (sum % k == 1) {
            return false;
        }

        int[] buckets = new int[k];
        // 给所有桶赋值初始容量
        Arrays.fill(buckets, sum / k);
        return backtrackFillBuckets(sortNums, 0, buckets);
    }

    /**
     * 回溯填桶
     *
     * @param nums    倒排数组
     * @param idx     当前填充第几个元素
     * @param buckets 桶
     * @return 是否能填充当前桶
     */
    private boolean backtrackFillBuckets(Integer[] nums, int idx, int[] buckets) {
        if (idx == nums.length) {
            return true;
        }
        for (int i = 0; i < buckets.length; i++) {
            // 当前桶剩余容量不够
            if (buckets[i] < nums[idx]) {
                continue;
            }
            buckets[i] -= nums[idx];
            boolean canFill = backtrackFillBuckets(nums, idx + 1, buckets);
            if (canFill) {
                return true;
            } else {
                // 还原，回溯
                buckets[i] += nums[idx];
            }
        }
        return false;
    }

    @Test
    public void testCase1() {
        LeetCode698 leetCode698 = new LeetCode698();
        assert leetCode698.canPartitionKSubsets(new int[]{4, 3, 2, 3, 5, 2, 1}, 4);
    }

    @Test
    public void testCase2() {
        LeetCode698 leetCode698 = new LeetCode698();
        assert leetCode698.canPartitionKSubsets(new int[]{1, 2, 3, 4}, 3);
    }
}
