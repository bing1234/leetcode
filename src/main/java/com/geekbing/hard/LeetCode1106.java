package com.geekbing.hard;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author bing
 */
public class LeetCode1106 {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> stack = new Stack<>();
        for (char c : expression.toCharArray()) {
            if (c == ')') {
                List<Character> list = new ArrayList<>();
                while (stack.peek() != '(') {
                    list.add(stack.pop());
                }
                // 弹出符号(
                stack.pop();
                // 弹出运算符号
                char op = stack.pop();
                if (op == '!') {
                    stack.push(calNot(list));
                } else if (op == '&') {
                    stack.push(calAnd(list));
                } else if (op == '|') {
                    stack.push(calOr(list));
                }
            } else {
                stack.push(c);
            }
        }
        return stack.pop() == 't';
    }

    private char calNot(List<Character> list) {
        boolean ans = (list.get(0) == 'f');
        return ans ? 't' : 'f';
    }

    private char calAnd(List<Character> list) {
        for (Character c : list) {
            if (c == 'f') {
                return 'f';
            }
        }
        return 't';
    }

    private char calOr(List<Character> list) {
        for (Character c : list) {
            if (c == 't') {
                return 't';
            }
        }
        return 'f';
    }

    @Test
    public void testCase1() {
        LeetCode1106 leetCode1106 = new LeetCode1106();
        assert leetCode1106.parseBoolExpr("!(f)");
    }

    @Test
    public void testCase2() {
        LeetCode1106 leetCode1106 = new LeetCode1106();
        assert leetCode1106.parseBoolExpr("|(f,t)");
    }

    @Test
    public void testCase3() {
        LeetCode1106 leetCode1106 = new LeetCode1106();
        assert !leetCode1106.parseBoolExpr("&(t,f)");
    }

    @Test
    public void testCase4() {
        LeetCode1106 leetCode1106 = new LeetCode1106();
        assert !leetCode1106.parseBoolExpr("|(&(t,f,t),!(t))");
    }
}
