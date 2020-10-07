package com.geekbing.easy;

import java.util.Stack;

public class LeetCode155 {
    private final Stack<Integer> data;
    private final Stack<Integer> minStack;

    public LeetCode155() {
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
        LeetCode155 minStack = new LeetCode155();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}
