package com.geekbing.interview;

public class Interview0103 {
    public String replaceSpaces(String S, int length) {
        int spaces = 0;
        for (int i = 0; i < length; i++) {
            if (S.charAt(i) == ' ') {
                spaces++;
            }
        }
        char[] chars = new char[length + spaces * 2];
        int end = chars.length - 1;
        for (int i = length - 1; i >= 0; i--) {
            if (S.charAt(i) == ' ') {
                chars[end--] = '0';
                chars[end--] = '2';
                chars[end--] = '%';
            } else {
                chars[end--] = S.charAt(i);
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        Interview0103 interview0103 = new Interview0103();
        System.out.println(interview0103.replaceSpaces("Mr John Smith    ", 13));
        System.out.println(interview0103.replaceSpaces("               ", 5));
    }
}
