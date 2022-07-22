package com.geekbing.easy;

import org.junit.jupiter.api.Test;

import java.util.Stack;

/**
 * @author bing
 */
public class LeetCode716 {
    private static class MaxStack {
        private static Stack<Integer> dataStack;
        private static Stack<Integer> maxStack;

        public MaxStack() {
            dataStack = new Stack<>();
            maxStack = new Stack<>();
        }

        public void push(int x) {
            dataStack.push(x);
            if (maxStack.isEmpty()) {
                maxStack.push(x);
            } else {
                maxStack.push(x > maxStack.peek() ? x : maxStack.peek());
            }
        }

        public int pop() {
            int ans = dataStack.pop();
            maxStack.pop();
            return ans;
        }

        public int top() {
            return dataStack.peek();
        }

        public int peekMax() {
            return maxStack.peek();
        }

        public int popMax() {
            int max = maxStack.peek();
            Stack<Integer> temp = new Stack<>();
            while (dataStack.peek() != max) {
                temp.push(dataStack.pop());
                maxStack.pop();
            }
            dataStack.pop();
            maxStack.pop();
            while (!temp.isEmpty()) {
                push(temp.pop());
            }
            return max;
        }
    }

    @Test
    public void testCase1() {
        MaxStack stk = new MaxStack();
        stk.push(5);   // [5] - 5 既是栈顶元素，也是最大元素
        stk.push(1);   // [5, 1] - 栈顶元素是 1，最大元素是 5
        stk.push(5);   // [5, 1, 5] - 5 既是栈顶元素，也是最大元素
        assert stk.top() == 5;     // 返回 5，[5, 1, 5] - 栈没有改变
        assert stk.popMax() == 5;  // 返回 5，[5, 1] - 栈发生改变，栈顶元素不再是最大元素
        assert stk.top() == 1;     // 返回 1，[5, 1] - 栈没有改变
        assert stk.peekMax() == 5; // 返回 5，[5, 1] - 栈没有改变
        assert stk.pop() == 1;     // 返回 1，[5] - 此操作后，5 既是栈顶元素，也是最大元素
        assert stk.top() == 5;     // 返回 5，[5] - 栈没有改变
    }
}
