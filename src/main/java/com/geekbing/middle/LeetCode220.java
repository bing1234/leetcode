package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author bing
 */
public class LeetCode220 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        // 桶的下标 - 桶中的元素
        Map<Long, Long> bucket = new HashMap<>();

        int bucketWidth = t + 1;
        for (int i = 0; i < nums.length; i++) {
            // 获取需要插入到哪个桶中
            long bucketIdx = getBucketIdx(nums[i], bucketWidth);
            if (bucket.containsKey(bucketIdx)) {
                return true;
            }
            // 比较左边的
            if (bucket.containsKey(bucketIdx - 1) && Math.abs(bucket.get(bucketIdx - 1) - nums[i]) <= t) {
                return true;
            }
            // 比较右边的
            if (bucket.containsKey(bucketIdx + 1) && Math.abs(bucket.get(bucketIdx + 1) - nums[i]) <= t) {
                return true;
            }
            bucket.put(bucketIdx, (long) nums[i]);

            // 可以剔除之前的元素了
            if (i >= k) {
                bucket.remove(getBucketIdx(nums[i - k], bucketWidth));
            }
        }
        return false;
    }

    private long getBucketIdx(long num, int bucketWidth) {
        if (num >= 0) {
            return num / bucketWidth;
        }
        return (num + 1) / bucketWidth - 1;
    }

    @Test
    public void testCase1() {
        LeetCode220 leetCode220 = new LeetCode220();
        assert leetCode220.containsNearbyAlmostDuplicate(new int[]{1, 2, 3, 1}, 3, 0);
    }

    @Test
    public void testCase2() {
        LeetCode220 leetCode220 = new LeetCode220();
        assert leetCode220.containsNearbyAlmostDuplicate(new int[]{1, 0, 1, 1}, 1, 2);
    }

    @Test
    public void testCase3() {
        LeetCode220 leetCode220 = new LeetCode220();
        assert !leetCode220.containsNearbyAlmostDuplicate(new int[]{1, 5, 9, 1, 5, 9}, 2, 3);
    }

    @Test
    public void testCase4() {
        LeetCode220 leetCode220 = new LeetCode220();
        assert !leetCode220.containsNearbyAlmostDuplicate(new int[]{-2147483648, 2147483647}, 1, 1);
    }

    @Test
    public void testCase5() {
        LeetCode220 leetCode220 = new LeetCode220();
        assert leetCode220.containsNearbyAlmostDuplicate(new int[]{-3, 3, -6}, 2, 3);
    }

    @Test
    public void testCase6() {
        LeetCode220 leetCode220 = new LeetCode220();
        boolean ans = leetCode220.containsNearbyAlmostDuplicate(new int[]{2, 0, -2, 2}, 2, 1);
        assert !ans;
    }
}
