package com.geekbing.middle;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode43 {
    public String multiply(String num1, String num2) {
        String ans = "0";
        if (num1.equals("0") || num2.equals("0")) {
            return ans;
        }
        StringBuilder base = new StringBuilder();
        for (int i = num2.length() - 1; i >= 0; i--) {
            String temp = mul(num1, num2.charAt(i)) + base;
            ans = add(ans, temp);
            base.append("0");
        }
        return ans;
    }

    private String mul(String num1, char c) {
        String ans = "0";
        for (int i = 0; i < c - '0'; i++) {
            ans = add(num1, ans);
        }
        return ans;
    }

    private String add(String num1, String num2) {
        int len = Math.max(num1.length(), num2.length());
        num1 = makeUpZero(num1, len);
        num2 = makeUpZero(num2, len);
        StringBuilder ans = new StringBuilder();
        int flag = 0;
        for (int i = len - 1; i >= 0; i--) {
            int a = num1.charAt(i) - '0';
            int b = num2.charAt(i) - '0';
            if (a + b + flag >= 10) {
                ans.insert(0, (a + b + flag - 10));
                flag = 1;
            } else {
                ans.insert(0, (a + b + flag));
                flag = 0;
            }
        }
        if (flag == 1) {
            ans.insert(0, 1);
        }
        return ans.toString();
    }

    private String makeUpZero(String num, int len) {
        if (num.length() >= len) {
            return num;
        }
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < len - num.length(); i++) {
            temp.append("0");
        }
        return temp + num;
    }

    @Test
    public void testCase1() {
        LeetCode43 leetCode43 = new LeetCode43();
        assert leetCode43.multiply("2", "3").equals("6");
    }

    @Test
    public void testCase2() {
        LeetCode43 leetCode43 = new LeetCode43();
        assert leetCode43.multiply("123", "456").equals("56088");
    }

    @Test
    public void testCase3() {
        LeetCode43 leetCode43 = new LeetCode43();
        assert leetCode43.multiply("123456789", "987654321").equals("121932631112635269");
    }

    @Test
    public void testCase4() {
        LeetCode43 leetCode43 = new LeetCode43();
        assert leetCode43.multiply("0", "52").equals("0");
    }
}
