package com.geekbing.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/next-greater-element-i/
 * 496. 下一个更大元素 I
 *
 * @author bing
 */
public class LeetCode496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> nextMap = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int num : nums2) {
            while (!stack.isEmpty() && num > stack.peek()) {
                nextMap.put(stack.pop(), num);
            }
            stack.push(num);
        }

        while (!stack.isEmpty()) {
            nextMap.put(stack.pop(), -1);
        }

        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = nextMap.get(nums1[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode496 leetCode496 = new LeetCode496();

        System.out.println(Arrays.toString(leetCode496.nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2})));
        System.out.println(Arrays.toString(leetCode496.nextGreaterElement(new int[]{2, 4}, new int[]{1, 2, 3, 4})));
    }
}
