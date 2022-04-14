package com.geekbing.hard;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author bing
 */
public class LeetCode224 {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int ans = 0, sign = 1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int num = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + (s.charAt(i) - '0');
                    i++;
                }
                i--;
                ans += sign * num;
            } else if (c == '+') {
                sign = 1;
            } else if (c == '-') {
                sign = -1;
            } else if (c == '(') {
                stack.push(ans);
                stack.push(sign);
                ans = 0;
                sign = 1;
            } else if (c == ')') {
                ans *= stack.pop();
                ans += stack.pop();
            }
        }
        return ans;
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
        assert leetCode224.calculate("-2+ 1") == -1;
    }

    @Test
    public void testCase5() {
        LeetCode224 leetCode224 = new LeetCode224();
        assert leetCode224.calculate("- (3 + (4 + 5))") == -12;
    }

    @Test
    public void testCase6() {
        LeetCode224 leetCode224 = new LeetCode224();
        assert leetCode224.calculate("1-(-2)") == 3;
    }
}
