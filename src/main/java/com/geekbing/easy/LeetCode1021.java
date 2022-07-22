package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode1021 {
    public String removeOuterParentheses(String s) {
        StringBuilder result = new StringBuilder();
        int leftCount = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                leftCount++;
            } else {
                leftCount--;
            }

            if (leftCount == 1 && c == '(') {
                continue;
            }
            if (leftCount == 0) {
                continue;
            }
            result.append(c);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        LeetCode1021 leetCode1021 = new LeetCode1021();
        System.out.println(leetCode1021.removeOuterParentheses("(()())(())"));
        System.out.println(leetCode1021.removeOuterParentheses("(()())(())(()(()))"));
        System.out.println(leetCode1021.removeOuterParentheses("()()"));
    }
}
