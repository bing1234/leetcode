package com.geekbing.todo;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode716 {
    private static class MaxStack {

        public MaxStack() {

        }

        public void push(int x) {

        }

        public int pop() {
            return 0;
        }

        public int top() {
            return 0;
        }

        public int peekMax() {
            return 0;
        }

        public int popMax() {
            return 0;
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
