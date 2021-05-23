package com.geekbing.interview;

public class Interview0101 {
    public boolean isUnique(String astr) {
        if (astr == null || "".equals(astr)) {
            return true;
        }
        if (astr.length() > 256) {
            return false;
        }
        boolean[] arr = new boolean[256];
        for (char c : astr.toCharArray()) {
            if (arr[c]) {
                return false;
            }
            arr[c] = true;
        }
        return true;
    }

    public static void main(String[] args) {
        Interview0101 interview0101 = new Interview0101();
        System.out.println(interview0101.isUnique("leetcode"));
        System.out.println(interview0101.isUnique("abc"));
    }
}
