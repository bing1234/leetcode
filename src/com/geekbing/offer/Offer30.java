package com.geekbing.offer;

import java.util.Stack;

public class Offer30 {
    private final Stack<Integer> data;
    private final Stack<Integer> minStack;

    /**
     * initialize your data structure here.
     */
    public Offer30() {
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

    public int min() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        Offer30 minStack = new Offer30();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        // 返回 -3.
        System.out.println(minStack.min());
        minStack.pop();
        // 返回 0.
        System.out.println(minStack.top());
        // 返回 -2.
        System.out.println(minStack.min());
    }
}
