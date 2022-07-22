package com.geekbing.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.IntStream;

/**
 * @author bing
 */
public class LeetCode2164 {
    public int[] sortEvenOdd(int[] nums) {
        // 奇数下标
        int[] odds = new int[nums.length / 2];
        // 偶数下标
        int[] evens = new int[nums.length - nums.length / 2];

        int oddIdx = 0, evenIdx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                evens[evenIdx] = nums[i];
                evenIdx++;
            } else {
                odds[oddIdx] = nums[i];
                oddIdx++;
            }
        }
        // 奇数下标倒排序
        odds = Arrays.stream(odds).boxed().sorted(Collections.reverseOrder()).mapToInt(Integer::intValue).toArray();
        // 偶数下标正排序
        Arrays.sort(evens);

        int[] ans = new int[nums.length];
        int idx = 0;
        for (int even : evens) {
            ans[idx] = even;
            idx += 2;
        }

        idx = 1;
        for (int odd : odds) {
            ans[idx] = odd;
            idx += 2;
        }
        return ans;
    }

    public int[] sortEvenOdd2(int[] nums) {
        // 奇数下标倒排序
        int[] odds = IntStream.range(0, nums.length).filter(idx -> idx % 2 != 0).mapToObj(idx -> nums[idx]).sorted(Collections.reverseOrder()).mapToInt(Integer::intValue).toArray();
        // 偶数下标正排序
        int[] evens = IntStream.range(0, nums.length).filter(idx -> idx % 2 == 0).map(idx -> nums[idx]).sorted().toArray();

        int[] ans = new int[nums.length];
        int idx = 0;
        for (int even : evens) {
            ans[idx] = even;
            idx += 2;
        }

        idx = 1;
        for (int odd : odds) {
            ans[idx] = odd;
            idx += 2;
        }
        return ans;
    }

    @Test
    public void testCase1() {
        LeetCode2164 leetCode2164 = new LeetCode2164();
        int[] ans = leetCode2164.sortEvenOdd2(new int[]{4, 1, 2, 3});
        int[] expert = new int[]{2, 3, 4, 1};
        assert Arrays.equals(expert, ans);
    }

    @Test
    public void testCase2() {
        LeetCode2164 leetCode2164 = new LeetCode2164();
        int[] ans = leetCode2164.sortEvenOdd2(new int[]{2, 1});
        int[] expert = new int[]{2, 1};
        assert Arrays.equals(expert, ans);
    }
}
