package com.geekbing.easy;

public class LeetCode557 {
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int start = 0, end;
        for (int i = 0; i < chars.length; i++) {
            if (i == chars.length - 1) {
                end = i;
                reverseWords(chars, start, end);
            } else {
                if (chars[i] == ' ') {
                    end = i - 1;

                    reverseWords(chars, start, end);
                    start = i + 1;
                }
            }
        }
        return new String(chars);
    }

    private void reverseWords(char[] chars, int start, int end) {
        while (start < end && end < chars.length) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;

            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        LeetCode557 leetCode557 = new LeetCode557();
        System.out.println(leetCode557.reverseWords("Let's take LeetCode contest"));
    }
}
