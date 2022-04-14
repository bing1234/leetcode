package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.Stack;

/**
 * @author bing
 */
public class LeetCode227 {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        char op = '+';
        int idx = 0;
        while (idx < s.length()) {
            char c = s.charAt(idx);
            if (c == '+' || c == '-' || c == '*' || c == '/') {
                op = c;
            } else if ('0' <= c && c <= '9') {
                // 得到当前数字
                int num = 0;
                while (idx < s.length() && '0' <= s.charAt(idx) && s.charAt(idx) <= '9') {
                    num = num * 10 + (s.charAt(idx) - '0');
                    idx++;
                }
                idx--;
                if (op == '+') {
                    stack.push(num);
                } else if (op == '-') {
                    stack.push(-num);
                } else if (op == '*') {
                    stack.push(stack.pop() * num);
                } else {
                    stack.push(stack.pop() / num);
                }
            }
            idx++;
        }
        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }

    @Test
    public void testCase1() {
        LeetCode227 leetCode227 = new LeetCode227();
        assert leetCode227.calculate("3+2*2") == 7;
    }

    @Test
    public void testCase2() {
        LeetCode227 leetCode227 = new LeetCode227();
        assert leetCode227.calculate(" 3/2 ") == 1;
    }

    @Test
    public void testCase3() {
        LeetCode227 leetCode227 = new LeetCode227();
        assert leetCode227.calculate(" 3+5 / 2 ") == 5;
    }
}
