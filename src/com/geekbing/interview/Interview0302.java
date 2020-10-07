package com.geekbing.interview;

import java.util.Stack;

public class Interview0302 {
    private final Stack<Integer> data;
    private final Stack<Integer> minStack;

    /** initialize your data structure here. */
    public Interview0302() {
        data = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        data.push(x);
        if (minStack.isEmpty()) {
            minStack.push(x);
        } else {
            minStack.push(x > minStack.peek() ? minStack.peek() : x);
        }
    }

    public void pop() {
        data.pop();
        minStack.pop();
    }

    public int top() {
        return data.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        Interview0302 minStack = new Interview0302();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        // 返回 -3.
        System.out.println(minStack.getMin());
        minStack.pop();
        // 返回 0.
        System.out.println(minStack.top());
        // 返回 -2.
        System.out.println(minStack.getMin());
    }
}
