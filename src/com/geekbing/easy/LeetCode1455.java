package com.geekbing.easy;

public class LeetCode1455 {
    public int isPrefixOfWord(String sentence, String searchWord) {
        int curWords = 1, idxS = 0, idxW = 0;
        while (idxS < sentence.length() && idxW < searchWord.length()) {
            if (sentence.charAt(idxS) == ' ') {
                curWords++;
                idxS++;
                idxW = 0;
                continue;
            }
            if (sentence.charAt(idxS) != searchWord.charAt(idxW)) {
                idxW = 0;
                while (idxS < sentence.length() && sentence.charAt(idxS) != ' ') {
                    idxS++;
                }
            } else {
                idxW++;
                idxS++;
            }
        }
        return idxW == searchWord.length() ? curWords : -1;
    }

    public static void main(String[] args) {
        LeetCode1455 leetCode1455 = new LeetCode1455();
        System.out.println(leetCode1455.isPrefixOfWord("i love eating burger", "burg"));
        System.out.println(leetCode1455.isPrefixOfWord("this problem is an easy problem", "pro"));
        System.out.println(leetCode1455.isPrefixOfWord("i am tired", "you"));
        System.out.println(leetCode1455.isPrefixOfWord("i use triple pillow", "pill"));
        System.out.println(leetCode1455.isPrefixOfWord("hello from the other side", "they"));
        System.out.println(leetCode1455.isPrefixOfWord("hellohello hellohellohello", "ell"));
    }
}
