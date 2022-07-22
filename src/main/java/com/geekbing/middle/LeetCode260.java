package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author bing
 */
public class LeetCode260 {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }

        // 使用位运算x & -x 取出 x 的二进制表示中最低位那个1
        int mask = (xor == Integer.MIN_VALUE ? xor : xor & (-xor));

        int[] ans = new int[2];
        for (int num : nums) {
            if ((num & mask) != 0) {
                ans[0] ^= num;
            } else {
                ans[1] ^= num;
            }
        }
        return ans;
    }

    @Test
    public void testCase1() {
        LeetCode260 leetCode260 = new LeetCode260();
        int[] ans = leetCode260.singleNumber(new int[]{1, 2, 1, 3, 2, 5});
        Arrays.sort(ans);
        int[] expert = new int[]{3, 5};
        assert Arrays.equals(expert, ans);
    }

    @Test
    public void testCase2() {
        LeetCode260 leetCode260 = new LeetCode260();
        int[] ans = leetCode260.singleNumber(new int[]{-1, 0});
        Arrays.sort(ans);
        int[] expert = new int[]{-1, 0};
        assert Arrays.equals(expert, ans);
    }

    @Test
    public void testCase3() {
        LeetCode260 leetCode260 = new LeetCode260();
        int[] ans = leetCode260.singleNumber(new int[]{0, 1});
        Arrays.sort(ans);
        int[] expert = new int[]{0, 1};
        assert Arrays.equals(expert, ans);
    }
}
