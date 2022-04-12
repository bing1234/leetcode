package com.geekbing.hard;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author bing
 */
public class LeetCode224 {
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
        if (!list.isEmpty() && "-".equals(list.get(0))) {
            list.add(0, "0");
        }
        return list;
    }

    public List<String> convertInfixToPostfix(List<String> list) {
        List<String> ans = new ArrayList<>();
        // 符号栈
        Stack<String> stack = new Stack<>();
        for (String item : list) {
            // 操作符
            if (isOperator(item)) {
                while (!stack.isEmpty() && getPriority(stack.peek()) >= getPriority(item)) {
                    ans.add(stack.pop());
                }
                stack.push(item);
            } else if (item.equals("(")) {
                stack.push(item);
            } else if (item.equals(")")) {
                while (!stack.peek().equals("(")) {
                    ans.add(stack.pop());
                }
                stack.pop();
            } else {
                // 数字
                ans.add(item);
            }
        }
        while (stack.size() != 0) {
            ans.add(stack.pop());
        }
        return ans;
    }

    private boolean isOperator(String str) {
        return "+".equals(str) || "-".equals(str) || "*".equals(str) || "/".equals(str);
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
            if (isOperator(str)) {
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
            } else {
                stack.push(Integer.parseInt(str));
            }
        }
        return stack.pop();
    }

    @Test
    public void testCase1() {
        LeetCode224 leetCode224 = new LeetCode224();
        assert leetCode224.calculate("1 + 1") == 2;
    }

    @Test
    public void testCase2() {
        LeetCode224 leetCode224 = new LeetCode224();
        assert leetCode224.calculate(" 2-1 + 2 ") == 3;
    }

    @Test
    public void testCase3() {
        LeetCode224 leetCode224 = new LeetCode224();
        assert leetCode224.calculate("(1+(4+5+2)-3)+(6+8)") == 23;
    }

    @Test
    public void testCase4() {
        LeetCode224 leetCode224 = new LeetCode224();
        assert leetCode224.calculate("10 * 9 / 8 + 7 - 6 * 5 / 4 + 3 - 2 * 1") == 12;
    }

    @Test
    public void testCase5() {
        LeetCode224 leetCode224 = new LeetCode224();
        assert leetCode224.calculate("-2+ 1") == -1;
    }

    @Test
    public void testCase6() {
        LeetCode224 leetCode224 = new LeetCode224();
        assert leetCode224.calculate("- (3 + (4 + 5))") == -12;
    }

    @Test
    public void testCase7() {
        LeetCode224 leetCode224 = new LeetCode224();
        assert leetCode224.calculate("1-(-2)") == 3;
    }
}
