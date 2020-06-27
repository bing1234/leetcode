package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode709 {
    public String toLowerCase(String str) {
        StringBuilder s = new StringBuilder();
        for (char c : str.toCharArray()) {
            if ('A' <= c && c <= 'Z') {
                s.append((char) (c + 32));
            } else {
                s.append(c);
            }
        }
        return s.toString();
    }

    public static void main(String[] args) {
        LeetCode709 leetCode709 = new LeetCode709();
        System.out.println(leetCode709.toLowerCase("Hello"));
        System.out.println(leetCode709.toLowerCase("here"));
        System.out.println(leetCode709.toLowerCase("LOVELY"));
    }
}
