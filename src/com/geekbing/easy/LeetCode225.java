package com.geekbing.easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author bing
 */
public class LeetCode225 {

    public static void main(String[] args) {
        MyStack obj = new MyStack();
        obj.push(1);
        int param_2 = obj.pop();
        obj.push(2);
        obj.push(3);
        int param_3 = obj.top();
        boolean param_4 = obj.empty();
    }

    private static class MyStack {
        private Queue<Integer> queue;

        /**
         * Initialize your data structure here.
         */
        public MyStack() {
            queue = new LinkedList<>();
        }

        /**
         * Push element x onto stack.
         */
        public void push(int x) {
            queue.add(x);
            for (int i = 0; i < queue.size() - 1; i++) {
                queue.offer(queue.peek());
                queue.poll();
            }
        }

        /**
         * Removes the element on top of the stack and returns that element.
         */
        public int pop() {
            return queue.poll();
        }

        /**
         * Get the top element.
         */
        public int top() {
            return queue.peek();
        }

        /**
         * Returns whether the stack is empty.
         */
        public boolean empty() {
            return queue.isEmpty();
        }
    }
}
