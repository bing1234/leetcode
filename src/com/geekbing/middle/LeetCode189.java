package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author bing
 */
public class LeetCode189 {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        if (k == 0) {
            return;
        }

        // 复制最后K个元素到新数组
        int[] temp = Arrays.copyOfRange(nums, nums.length - k, nums.length);

        // 将数组前面length-k个元素朝后移动k个位置
        if (nums.length - k - 1 + 1 >= 0) System.arraycopy(nums, 0, nums, k, nums.length - k - 1 + 1);

        // 将temp元素覆盖前面k个位置
        System.arraycopy(temp, 0, nums, 0, temp.length);
    }

    @Test
    public void testCase1() {
        LeetCode189 leetCode189 = new LeetCode189();
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        leetCode189.rotate(nums, 3);
        int[] expert = new int[]{5, 6, 7, 1, 2, 3, 4};
        assert Arrays.equals(expert, nums);
    }

    @Test
    public void testCase2() {
        LeetCode189 leetCode189 = new LeetCode189();
        int[] nums = new int[]{-1, -100, 3, 99};
        leetCode189.rotate(nums, 2);
        int[] expert = new int[]{3, 99, -1, -100};
        assert Arrays.equals(expert, nums);
    }

    @Test
    public void testCase3() {
        LeetCode189 leetCode189 = new LeetCode189();
        int[] nums = new int[]{-1};
        leetCode189.rotate(nums, 2);
        int[] expert = new int[]{-1};
        assert Arrays.equals(expert, nums);
    }
}
