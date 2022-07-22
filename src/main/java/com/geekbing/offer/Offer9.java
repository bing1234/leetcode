package com.geekbing.offer;

import org.junit.jupiter.api.Test;

import java.util.Stack;

/**
 * @author bing
 */
public class Offer9 {
    private static class CQueue {
        private final Stack<Integer> headStack;
        private final Stack<Integer> tailStack;

        public CQueue() {
            headStack = new Stack<>();
            tailStack = new Stack<>();
        }

        public void appendTail(int value) {
            tailStack.push(value);
        }

        public int deleteHead() {
            if (headStack.isEmpty()) {
                if (tailStack.isEmpty()) {
                    return -1;
                }
                while (!tailStack.isEmpty()) {
                    headStack.push(tailStack.pop());
                }
            }
            return headStack.pop();
        }
    }

    @Test
    public void testCase1() {
        CQueue queue = new CQueue();
        queue.appendTail(3);
        assert queue.deleteHead() == 3;
        assert queue.deleteHead() == -1;
    }

    @Test
    public void testCase2() {
        CQueue queue = new CQueue();
        assert queue.deleteHead() == -1;
        queue.appendTail(5);
        queue.appendTail(2);
        assert queue.deleteHead() == 5;
        assert queue.deleteHead() == 2;
    }
}
