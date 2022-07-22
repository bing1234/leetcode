package com.geekbing.middle;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode1381 {
    private static class CustomStack {
        /**
         * 用数组模拟栈
         */
        private final int[] stack;

        /**
         * 增量数组
         */
        private final int[] add;

        /**
         * 指向栈顶位置
         */
        private int idx;

        public CustomStack(int maxSize) {
            stack = new int[maxSize];
            add = new int[maxSize];
            idx = -1;
        }

        public void push(int x) {
            if (idx + 1 < stack.length) {
                stack[++idx] = x;
            }
        }

        public int pop() {
            if (idx == -1) {
                return -1;
            }
            int ans = stack[idx] + add[idx];
            if (idx - 1 >= 0) {
                add[idx - 1] += add[idx];
            }
            add[idx--] = 0;
            return ans;
        }

        public void increment(int k, int val) {
            int min = Math.min(k - 1, idx);
            if (min >= 0) {
                add[min] += val;
            }
        }
    }

    @Test
    public void testCase1() {
        CustomStack customStack = new CustomStack(3); // 栈是空的 []
        customStack.push(1);                                // 栈变为 [1]
        customStack.push(2);                                // 栈变为 [1, 2]
        assert customStack.pop() == 2;                         // 返回 2 --> 返回栈顶值 2，栈变为 [1]
        customStack.push(2);                                // 栈变为 [1, 2]
        customStack.push(3);                                // 栈变为 [1, 2, 3]
        customStack.push(4);                                // 栈仍然是 [1, 2, 3]，不能添加其他元素使栈大小变为 4
        customStack.increment(5, 100);                  // 栈变为 [101, 102, 103]
        customStack.increment(2, 100);                  // 栈变为 [201, 202, 103]
        assert customStack.pop() == 103;                       // 返回 103 --> 返回栈顶值 103，栈变为 [201, 202]
        assert customStack.pop() == 202;                       // 返回 202 --> 返回栈顶值 202，栈变为 [201]
        assert customStack.pop() == 201;                       // 返回 201 --> 返回栈顶值 201，栈变为 []
        assert customStack.pop() == -1;                        // 返回 -1 --> 栈为空，返回 -1
    }
}
