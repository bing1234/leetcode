package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author bing
 */
public class LeetCode739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        // 单调递减栈存储下标
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int idx = stack.pop();
                ans[idx] = i - idx;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int idx = stack.pop();
            ans[idx] = 0;
        }
        return ans;
    }

    @Test
    public void testCase1() {
        LeetCode739 leetCode739 = new LeetCode739();
        int[] ans = leetCode739.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
        int[] expert = new int[]{1, 1, 4, 2, 1, 1, 0, 0};
        assert Arrays.equals(expert, ans);
    }

    @Test
    public void testCase2() {
        LeetCode739 leetCode739 = new LeetCode739();
        int[] ans = leetCode739.dailyTemperatures(new int[]{30, 40, 50, 60});
        int[] expert = new int[]{1, 1, 1, 0};
        assert Arrays.equals(expert, ans);
    }

    @Test
    public void testCase3() {
        LeetCode739 leetCode739 = new LeetCode739();
        int[] ans = leetCode739.dailyTemperatures(new int[]{30, 60, 90});
        int[] expert = new int[]{1, 1, 0};
        assert Arrays.equals(expert, ans);
    }
}
