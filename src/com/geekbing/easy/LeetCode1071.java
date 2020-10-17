package com.geekbing.easy;

public class LeetCode1071 {
    public String gcdOfStringsV2(String str1, String str2) {
        if (!str1.concat(str2).equals(str2.concat(str1))) {
            return "";
        }
        return str1.substring(0, gcd(str1.length(), str2.length()));
    }

    private int gcd(int a, int b) {
        int remainder = a % b;
        while (remainder != 0) {
            a = b;
            b = remainder;
            remainder = a % b;
        }
        return b;
    }

    public String gcdOfStrings(String str1, String str2) {
        // 特殊情况处理
        if (str1 == null || str1.equals("") || str2 == null || str2.equals("")) {
            return "";
        }

        // 最大公共前缀
        String prefix = findMaxCommonPrefix(str1, str2);
        if (prefix.equals("")) {
            return "";
        }

        for (int i = prefix.length(); i >= 1; i--) {
            String subStr = prefix.substring(0, i);
            if (canRepeat(str1, subStr) && canRepeat(str2, subStr)) {
                return subStr;
            }
        }
        return "";
    }

    private String findMaxCommonPrefix(String str1, String str2) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < str1.length() && i < str2.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                break;
            }
            ans.append(str1.charAt(i));
        }
        return ans.toString();
    }

    private boolean canRepeat(String str, String item) {
        if (str.length() % item.length() != 0) {
            return false;
        }
        int count = str.length() / item.length();
        StringBuilder repeat = new StringBuilder();
        for (int i = 0; i < count; i++) {
            repeat.append(item);
        }
        return str.equals(repeat.toString());
    }

    public static void main(String[] args) {
        LeetCode1071 leetCode1071 = new LeetCode1071();
        System.out.println(leetCode1071.gcdOfStringsV2("ABCABC", "ABC"));
        System.out.println(leetCode1071.gcdOfStringsV2("ABABAB", "ABAB"));
        System.out.println(leetCode1071.gcdOfStringsV2("LEET", "CODE"));
    }
}
