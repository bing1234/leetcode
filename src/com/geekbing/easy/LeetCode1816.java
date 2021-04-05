package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode1816 {
    public String truncateSentence(String s, int k) {
        int count = 0;
        StringBuilder sentence = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                count++;
                if (count == k) {
                    return sentence.toString();
                }
                sentence.append(c);
            } else {
                sentence.append(c);
            }
        }
        return sentence.toString();
    }

    public static void main(String[] args) {
        LeetCode1816 leetCode1816 = new LeetCode1816();
        System.out.println(leetCode1816.truncateSentence("Hello how are you Contestant", 4));
        System.out.println(leetCode1816.truncateSentence("What is the solution to this problem", 4));
        System.out.println(leetCode1816.truncateSentence("chopper is not a tanuki", 5));
    }
}
