package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.Stack;

/**
 * @author bing
 */
public class LeetCode331 {
    public boolean isValidSerialization(String preorder) {
        Stack<String> stack = new Stack<>();
        String[] items = preorder.split(",");
        for (String item : items) {
            if (item.equals(",")) {
                continue;
            } else if (item.equals("#")) {
                while (stack.size() >= 2 && stack.peek().equals("#")) {
                    String temp = stack.pop();
                    if (stack.peek().equals("#")) {
                        stack.push(temp);
                        break;
                    } else {
                        stack.pop();
                    }
                }
                stack.push("#");
            } else {
                stack.push(item);
            }
        }
        return stack.size() == 1 && stack.peek().equals("#");
    }

    @Test
    public void testCase1() {
        LeetCode331 leetCode331 = new LeetCode331();
        assert leetCode331.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#");
    }

    @Test
    public void testCase2() {
        LeetCode331 leetCode331 = new LeetCode331();
        assert !leetCode331.isValidSerialization("1,#");
    }

    @Test
    public void testCase3() {
        LeetCode331 leetCode331 = new LeetCode331();
        assert !leetCode331.isValidSerialization("9,#,#,1");
    }

    @Test
    public void testCase4() {
        LeetCode331 leetCode331 = new LeetCode331();
        assert !leetCode331.isValidSerialization("1,#,#,#,#");
    }

    @Test
    public void testCase5() {
        LeetCode331 leetCode331 = new LeetCode331();
        assert leetCode331.isValidSerialization("9,#,92,#,#");
    }
}
