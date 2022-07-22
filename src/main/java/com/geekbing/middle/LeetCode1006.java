package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.Stack;

/**
 * @author bing
 */
public class LeetCode1006 {
    public int clumsy(int n) {
        Stack<Integer> stack = new Stack<>();
        stack.push(n);
        char op = '*';
        for (int num = n - 1; num >= 1; num--) {
            switch (op) {
                case '*':
                    stack.push(stack.pop() * num);
                    op = '/';
                    break;
                case '/':
                    stack.push(stack.pop() / num);
                    op = '+';
                    break;
                case '+':
                    stack.push(num);
                    op = '-';
                    break;
                case '-':
                    stack.push(-num);
                    op = '*';
                    break;
                default:
                    break;
            }
        }
        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }

    @Test
    public void testCase1() {
        LeetCode1006 leetCode1006 = new LeetCode1006();
        int ans = leetCode1006.clumsy(4);
        assert ans == 7;
    }

    @Test
    public void testCase2() {
        LeetCode1006 leetCode1006 = new LeetCode1006();
        int ans = leetCode1006.clumsy(10);
        assert ans == 12;
    }
}
