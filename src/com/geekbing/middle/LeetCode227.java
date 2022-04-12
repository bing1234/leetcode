package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author bing
 */
public class LeetCode227 {
    public int calculate(String s) {
        // 生成中缀表达式
        List<String> infixExps = genInfixExps(s);
        // 中缀表达式转后缀表达式
        List<String> postfixExps = convertInfixToPostfix(infixExps);
        // 计算后缀表达式
        return calPostfixExps(postfixExps);
    }

    private List<String> genInfixExps(String str) {
        List<String> list = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            char c = str.charAt(i);
            if (c == ' ') {
                i++;
            } else if (Character.isDigit(c)) {
                int num = 0;
                while (i < str.length() && Character.isDigit(str.charAt(i))) {
                    num = num * 10 + (str.charAt(i) - '0');
                    i++;
                }
                list.add(String.valueOf(num));
            } else {
                list.add(String.valueOf(c));
                i++;
            }
        }
        return list;
    }

    public List<String> convertInfixToPostfix(List<String> list) {
        List<String> ans = new ArrayList<>();
        // 符号栈
        Stack<String> stack = new Stack<>();
        for (String item : list) {
            // 如果是一个数
            if (item.matches("\\d+")) {
                ans.add(item);
            } else if (item.equals("(")) {
                stack.push(item);
            } else if (item.equals(")")) {
                while (!stack.peek().equals("(")) {
                    ans.add(stack.pop());
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() && getPriority(stack.peek()) >= getPriority(item)) {
                    ans.add(stack.pop());
                }
                stack.push(item);
            }
        }
        while (stack.size() != 0) {
            ans.add(stack.pop());
        }
        return ans;
    }

    private Integer getPriority(String op) {
        switch (op) {
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
            default:
                return 0;
        }
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
