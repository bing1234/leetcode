package com.geekbing.todo;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode1190 {
    public String reverseParentheses(String s) {
        if (s.length() < 2) {
            return s;
        }
        int left = 0, right = s.length() - 1;
        while (left < right) {
            while (left < right && s.charAt(left) != '(' && s.charAt(left) != ')') {
                left++;
            }
            while (left < right && s.charAt(right) != '(' && s.charAt(right) != ')') {
                right--;
            }
            if (left >= right) {
                return s;
            }
            String sub = s.substring(left + 1, right);
            sub = reverse(sub);
            return s.substring(0, left) + reverseParentheses(sub) + s.substring(right + 1);
        }
        return s;
    }

    private String reverse(String s) {
        StringBuilder ans = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            ans.append(s.charAt(i));
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
}
