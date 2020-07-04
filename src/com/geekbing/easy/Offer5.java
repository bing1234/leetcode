package com.geekbing.easy;

/**
 * @author bing
 */
public class Offer5 {
    public String replaceSpace(String s) {
        StringBuilder result = new StringBuilder();

        char c;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (c == ' ') {
                result.append("%20");
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Offer5 offer5 = new Offer5();

        System.out.println(offer5.replaceSpace("We are happy."));
    }
}
