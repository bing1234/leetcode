package com.geekbing;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author bing
 */
public class LeetCode1006 {
    public int clumsy(int n) {
        // 生成中缀表达式
        List<String> infixExps = genInfixExps(n);
        // 中缀表达式转后缀表达式
        List<String> postfixExps = convertInfixToPostfix(infixExps);
        // 计算后缀表达式
        return calPostfixExps(postfixExps);
    }

    private int calPostfixExps(List<String> list) {
        Stack<Integer> stack = new Stack<>();
        for (String str : list) {
            if (Character.isDigit(str.charAt(0))) {
                stack.push(Integer.parseInt(str));
            } else {
                int num2 = stack.pop();
                int num1 = stack.pop();
                switch (str) {
                    case "+":
                        stack.push(num1 + num2);
                        break;
                    case "-":
                        stack.push(num1 - num2);
                        break;
                    case "*":
                        stack.push(num1 * num2);
                        break;
                    case "/":
                        stack.push(num1 / num2);
                        break;
                    default:
                        break;
                }
            }
        }
        return stack.pop();
    }

    private List<String> convertInfixToPostfix(List<String> exps) {
        List<String> ans = new ArrayList<>();
        Stack<Character> stack = new Stack<>();
        stack.push('#');
        for (String str : exps) {
            if (Character.isDigit(str.charAt(0))) {
                ans.add(str);
            } else {
                Character cur = str.charAt(0);
                Character stackTop = stack.peek();
                // 比较当前操作符和栈顶操作符的优先级
                if (getPriority(cur) <= getPriority(stackTop)) {
                    ans.add(String.valueOf(stack.pop()));
                }
                stack.push(cur);
            }
        }
        while (!stack.isEmpty() && stack.peek() != '#') {
            ans.add(String.valueOf(stack.pop()));
        }
        return ans;
    }

    private Integer getPriority(Character op) {
        switch (op) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return 0;
        }
    }

    private List<String> genInfixExps(int n) {
        List<String> exps = new ArrayList<>();
        exps.add(String.valueOf(n));
        String op = "*";
        for (int i = n - 1; i >= 1; i--) {
            exps.add(op);
            exps.add(String.valueOf(i));
            switch (op) {
                case "*":
                    op = "/";
                    break;
                case "/":
                    op = "+";
                    break;
                case "+":
                    op = "-";
                    break;
                default:
                    op = "*";
                    break;
            }
        }
        return exps;
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
