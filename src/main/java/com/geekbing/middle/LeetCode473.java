package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author bing
 */
public class LeetCode473 {
    public boolean makesquare(int[] matchsticks) {
        // 桶的数量
        int bucketLen = 4;
        // 倒排序
        Integer[] nums = Arrays.stream(matchsticks).boxed().sorted(Collections.reverseOrder()).toArray(Integer[]::new);
        int sum = Arrays.stream(matchsticks).sum();
        if (sum % bucketLen != 0) {
            return false;
        }
        // 初始化4个桶
        int[] bucket = new int[bucketLen];
        // 每个桶都初始化固定容量
        Arrays.fill(bucket, sum / bucketLen);
        // 采用回溯法来填桶
        return backtrackFillBucket(nums, 0, bucket);
    }

    private boolean backtrackFillBucket(Integer[] nums, int idx, int[] bucket) {
        if (idx == nums.length) {
            return true;
        }
        for (int i = 0; i < bucket.length; i++) {
            // 当前桶容量不够
            if (bucket[i] < nums[idx]) {
                continue;
            }
            // 填当前桶
            bucket[i] -= nums[idx];
            // 查看后面的是否能够填下
            boolean canFill = backtrackFillBucket(nums, idx + 1, bucket);
            if (canFill) {
                return true;
            } else {
                // 回溯
                bucket[i] += nums[idx];
            }
        }
        return false;
    }

    @Test
    public void testCase1() {
        LeetCode473 leetCode473 = new LeetCode473();
        assert leetCode473.makesquare(new int[]{1, 1, 2, 2, 2});
    }

    @Test
    public void testCase2() {
        LeetCode473 leetCode473 = new LeetCode473();
        assert !leetCode473.makesquare(new int[]{3, 3, 3, 3, 4});
    }
}
