package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode1108 {
    public String defangIPaddr(String address) {
        StringBuilder result = new StringBuilder();
        for (char c : address.toCharArray()) {
            if (c == '.') {
                result.append("[.]");
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    public String defangIPaddrV2(String address) {
        return address.replaceAll("\\.", "[.]");
    }

    public static void main(String[] args) {
        LeetCode1108 leetCode1108 = new LeetCode1108();
        System.out.println(leetCode1108.defangIPaddr("1.1.1.1"));
        System.out.println(leetCode1108.defangIPaddr("255.100.50.0"));
    }
}
