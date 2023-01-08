package com.geekbing.todo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author bing
 */
public class LeetCode1190 {
    public String reverseParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c != ')') {
                stack.push(c);
            } else {
                List<Character> list = new ArrayList<>();
                while (stack.peek() != '(') {
                    list.add(stack.pop());
                }
                // 弹出(
                stack.pop();
                for (Character ch : list) {
                    stack.push(ch);
                }
            }
        }
        StringBuilder ans = new StringBuilder();
        while (!stack.isEmpty()) {
            ans.insert(0, stack.pop());
        }
        return ans.toString();
    }

    @Test
    public void testCase1() {
        LeetCode1190 leetCode1190 = new LeetCode1190();
        assert "dcba".equals(leetCode1190.reverseParentheses("(abcd)"));
    }

    @Test
    public void testCase2() {
        LeetCode1190 leetCode1190 = new LeetCode1190();
        assert "iloveu".equals(leetCode1190.reverseParentheses("(u(love)i)"));
    }

    @Test
    public void testCase3() {
        LeetCode1190 leetCode1190 = new LeetCode1190();
        assert "leetcode".equals(leetCode1190.reverseParentheses("(ed(et(oc))el)"));
    }

    @Test
    public void testCase4() {
        LeetCode1190 leetCode1190 = new LeetCode1190();
        assert "apmnolkjihgfedcbq".equals(leetCode1190.reverseParentheses("a(bcdefghijkl(mno)p)q"));
    }

    @Test
    public void testCase5() {
        LeetCode1190 leetCode1190 = new LeetCode1190();
        assert "sxmdllqekix".equals(leetCode1190.reverseParentheses("sxmdll(q)eki(x)"));
    }
}
