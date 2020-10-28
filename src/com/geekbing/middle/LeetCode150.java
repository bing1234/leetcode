package com.geekbing.middle;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/
 * 150. 逆波兰表达式求值
 *
 * @author bing
 */
public class LeetCode150 {
    public int evalRPN(String[] tokens) {
        Integer num1, num2;
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            switch (token) {
                case "+":
                    num1 = stack.pop();
                    num2 = stack.pop();
                    stack.push(num2 + num1);
                    break;
                case "-":
                    num1 = stack.pop();
                    num2 = stack.pop();
                    stack.push(num2 - num1);
                    break;
                case "*":
                    num1 = stack.pop();
                    num2 = stack.pop();
                    stack.push(num2 * num1);
                    break;
                case "/":
                    num1 = stack.pop();
                    num2 = stack.pop();
                    stack.push(num2 / num1);
                    break;
                default:
                    stack.push(Integer.parseInt(token));
                    break;
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        LeetCode150 leetCode150 = new LeetCode150();
        System.out.println(leetCode150.evalRPN(new String[]{"2", "1", "+", "3", "*"}));
        System.out.println(leetCode150.evalRPN(new String[]{"4", "13", "5", "/", "+"}));
        System.out.println(leetCode150.evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
    }
}
