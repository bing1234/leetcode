package com.geekbing.easy;

import java.util.Stack;

/**
 * @author bing
 */
public class LeetCode20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            switch (c) {
                case '(':
                case '{':
                case '[':
                    stack.push(c);
                    break;
                case ')':
                    if (stack.isEmpty() || stack.pop() != '(') {
                        return false;
                    }
                    break;
                case '}':
                    if (stack.isEmpty() || stack.pop() != '{') {
                        return false;
                    }
                    break;
                case ']':
                    if (stack.isEmpty() || stack.pop() != '[') {
                        return false;
                    }
                    break;
                default:
                    break;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        LeetCode20 leetCode20 = new LeetCode20();

        System.out.println(leetCode20.isValid("()"));
        System.out.println(leetCode20.isValid("()[]{}"));
        System.out.println(leetCode20.isValid("(]"));
        System.out.println(leetCode20.isValid("([)]"));
        System.out.println(leetCode20.isValid("{[]}"));
    }
}
