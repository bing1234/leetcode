package com.geekbing.easy;

import java.util.HashSet;
import java.util.Set;

public class LeetCode929 {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String email : emails) {
            String[] arr = email.split("@");
            String emailAddress = getEmailAddress(arr[0], arr[1]);
            set.add(emailAddress);
        }
        return set.size();
    }

    private String getEmailAddress(String pre, String post) {
        String[] arr = pre.split("\\+");
        StringBuilder email = new StringBuilder();
        for (char c : arr[0].toCharArray()) {
            if (c != '.') {
                email.append(c);
            }
        }
        return email + "@" + post;
    }

    public static void main(String[] args) {
        LeetCode929 leetCode929 = new LeetCode929();
        System.out.println(leetCode929.numUniqueEmails(new String[]{"test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"}));
    }
}
