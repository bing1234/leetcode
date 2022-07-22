package com.geekbing.easy;

import java.util.Stack;

/**
 * @author bing
 */
public class LeetCode232 {
    private static class MyQueue {
        private Stack<Integer> stackA, stackB;

        /**
         * Initialize your data structure here.
         */
        public MyQueue() {
            stackA = new Stack<>();
            stackB = new Stack<>();
        }

        /**
         * Push element x to the back of queue.
         */
        public void push(int x) {
            stackA.push(x);
        }

        /**
         * Removes the element from in front of queue and returns that element.
         */
        public int pop() {
            if (stackB.isEmpty()) {
                while (!stackA.isEmpty()) {
                    stackB.push(stackA.pop());
                }
            }
            return stackB.pop();
        }

        /**
         * Get the front element.
         */
        public int peek() {
            if (stackB.isEmpty()) {
                while (!stackA.isEmpty()) {
                    stackB.push(stackA.pop());
                }
            }
            return stackB.peek();
        }

        /**
         * Returns whether the queue is empty.
         */
        public boolean empty() {
            return stackA.empty() && stackB.isEmpty();
        }
    }

    public static void main(String[] args) {
        MyQueue obj = new MyQueue();
        obj.push(1);
        int param_2 = obj.pop();
        System.out.println(param_2);
        obj.push(2);
        int param_3 = obj.peek();
        System.out.println(param_3);
        boolean param_4 = obj.empty();
        System.out.println(param_4);
    }
}
