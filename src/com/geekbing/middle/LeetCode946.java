package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.Stack;

/**
 * @author bing
 */
public class LeetCode946 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int popIdx = 0;
        for (int num : pushed) {
            stack.push(num);
            while (!stack.isEmpty() && popped[popIdx] == stack.peek()) {
                stack.pop();
                popIdx++;
            }
        }
        return stack.isEmpty();
    }

    @Test
    public void testCase1() {
        LeetCode946 leetCode946 = new LeetCode946();
        assert leetCode946.validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 2, 1});
    }

    @Test
    public void testCase2() {
        LeetCode946 leetCode946 = new LeetCode946();
        assert !leetCode946.validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 3, 5, 1, 2});
    }
}
