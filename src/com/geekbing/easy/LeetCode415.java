package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode415 {
    public String addStrings(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        int index1 = num1.length() - 1;
        int index2 = num2.length() - 1;
        int carry = 0, bit1, bit2, temp;
        while (index1 >= 0 || index2 >= 0) {
            bit1 = index1 < 0 ? 0 : num1.charAt(index1) - '0';
            bit2 = index2 < 0 ? 0 : num2.charAt(index2) - '0';
            temp = bit1 + bit2 + carry;
            result.insert(0, temp % 10);
            carry = temp / 10;
            index1--;
            index2--;
        }
        if (carry == 1) {
            result.insert(0, "1");
        }
        return result.toString();
    }

    public static void main(String[] args) {
        LeetCode415 leetCode415 = new LeetCode415();
        System.out.println(leetCode415.addStrings("123", "0"));
        System.out.println(leetCode415.addStrings("123", "1"));
        System.out.println(leetCode415.addStrings("123", "123"));
    }
}
