package com.geekbing.middle;

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

    public static void main(String[] args) {
        LeetCode227 leetCode227 = new LeetCode227();
        System.out.println(leetCode227.calculate("1*2-3/4+5*6-7*8+9/10"));
//        System.out.println(leetCode227.calculate("3+2*2"));
//        System.out.println(leetCode227.calculate(" 3/2 "));
//        System.out.println(leetCode227.calculate(" 3+5 / 2 "));
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

    private List<String> convertInfixToPostfix(List<String> infixExps) {
        List<String> ans = new ArrayList<>();
        Stack<Character> stack = new Stack<>();
        stack.push('#');
        for (String str : infixExps) {
            if (Character.isDigit(str.charAt(0))) {
                ans.add(str);
            } else if ("(".equals(str)) {
                stack.push('(');
            } else if (")".equals(str)) {
                while (stack.peek() != '(') {
                    ans.add(String.valueOf(stack.pop()));
                }
                stack.pop();
            } else {
                Character cur = str.charAt(0);
                Character stackTop = stack.peek();
                // 比较当前操作符和栈顶操作符的优先级
                int temp = comparePriority(cur, stackTop);
                if (temp <= 0) {
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

    private int comparePriority(Character op1, Character op2) {
        Integer p1 = getPriority(op1);
        Integer p2 = getPriority(op2);
        return p1.compareTo(p2);
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
}
