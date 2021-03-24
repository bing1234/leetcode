package com.geekbing.easy;

public class LeetCode1694 {
    public String reformatNumber(String number) {
        int count = 0;
        StringBuilder tmp = new StringBuilder();
        for (char c : number.toCharArray()) {
            if (c == ' ' || c == '-') {
                continue;
            }
            tmp.append(c);
            count++;
            if (count == 3) {
                tmp.append("-");
                count = 0;
            }
        }
        if (tmp.charAt(tmp.length() - 1) == '-') {
            tmp.deleteCharAt(tmp.length() - 1);
        }
        if (tmp.charAt(tmp.length() - 2) == '-') {
            tmp.deleteCharAt(tmp.length() - 2);
            tmp.insert(tmp.length() - 2, "-");
        }
        return tmp.toString();
    }

    public static void main(String[] args) {
        LeetCode1694 leetCode1694 = new LeetCode1694();
        System.out.println(leetCode1694.reformatNumber("1-23-45 6"));
        System.out.println(leetCode1694.reformatNumber("123 4-567"));
        System.out.println(leetCode1694.reformatNumber("123 4-5678"));
        System.out.println(leetCode1694.reformatNumber("12"));
        System.out.println(leetCode1694.reformatNumber("--17-5 229 35-39475 "));
    }
}
