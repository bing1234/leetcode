package com.geekbing.offer;

/**
 * @author bing
 */
public class Offer50 {
    public char firstUniqChar(String s) {
        int[] bucket = new int[26];
        if (s == null || "".equals(s)) {
            return ' ';
        }
        for (char c : s.toCharArray()) {
            bucket[c - 'a']++;
        }
        for (char c : s.toCharArray()){
            if (bucket[c - 'a'] == 1){
                return c;
            }
        }
        return ' ';
    }

    public static void main(String[] args) {
        Offer50 offer50 = new Offer50();

//        System.out.println(offer50.firstUniqChar("abaccdeff"));
//        System.out.println(offer50.firstUniqChar(""));
        System.out.println(offer50.firstUniqChar("leetcode"));
    }
}
