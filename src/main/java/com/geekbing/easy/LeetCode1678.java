package com.geekbing.easy;

public class LeetCode1678 {
    public String interpret(String command) {
        StringBuilder ans = new StringBuilder();
        int i = 0;
        while (i < command.length()) {
            if (command.charAt(i) == 'G') {
                ans.append("G");
            } else if (command.charAt(i) == ')') {
                if (command.charAt(i - 1) == '(') {
                    ans.append("o");
                } else {
                    ans.append("al");
                }
            }
            i++;
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        LeetCode1678 leetCode1678 = new LeetCode1678();
        System.out.println(leetCode1678.interpret("G()(al)"));
        System.out.println(leetCode1678.interpret("G()()()()(al)"));
        System.out.println(leetCode1678.interpret("(al)G(al)()()G"));
    }
}
