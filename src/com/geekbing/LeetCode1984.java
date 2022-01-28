package com.geekbing;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author bing
 */
public class LeetCode1984 {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);

        int[] diff = new int[nums.length - 1];
        for (int i = 0; i < nums.length - 1; i++) {
            diff[i] = nums[i + 1] - nums[i];
        }

        int i = 0, sum = 0, right = k - 1;
        while (i < right) {
            sum += diff[i];
            i++;
        }

        int ans = sum;
        while (right < diff.length) {
            sum = sum + diff[right] - diff[right - k + 1];
            ans = Math.min(ans, sum);
            right++;
        }
        return ans;
    }

    @Test
    public void testCase1() {
        LeetCode1984 leetCode1984 = new LeetCode1984();
        assert leetCode1984.minimumDifference(new int[]{90}, 1) == 0;
    }

    @Test
    public void testCase2() {
        LeetCode1984 leetCode1984 = new LeetCode1984();
        assert leetCode1984.minimumDifference(new int[]{9, 4, 1, 7}, 2) == 2;
    }

    @Test
    public void testCase3() {
        LeetCode1984 leetCode1984 = new LeetCode1984();
        assert leetCode1984.minimumDifference(new int[]{9, 4, 1, 7}, 3) == 5;
    }

    @Test
    public void testCase4() {
        LeetCode1984 leetCode1984 = new LeetCode1984();
        assert leetCode1984.minimumDifference(new int[]{64407, 3036}, 2) == 61371;
    }
}
