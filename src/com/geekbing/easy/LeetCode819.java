package com.geekbing.easy;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author bing
 */
public class LeetCode819 {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> ban = Arrays.stream(banned).collect(Collectors.toSet());
        Map<String, Integer> map = new HashMap<>();

        String ans = "", curWord = "";
        int cnt = 0;
        char[] chars = paragraph.toCharArray();
        for (char c : chars) {
            if ('a' <= c && c <= 'z') {
                curWord += c;
            } else if ('A' <= c && c <= 'Z') {
                curWord += (char) (c + 32);
            } else {
                if (!"".equals(curWord) && !ban.contains(curWord)) {
                    Integer count = map.get(curWord);
                    if (count == null) {
                        count = 0;
                    }
                    count++;
                    map.put(curWord, count);
                    if (count > cnt) {
                        cnt = count;
                        ans = curWord;
                    }
                }
                curWord = "";
            }
        }
        if (!"".equals(curWord)) {
            Integer count = map.get(curWord);
            if (count == null) {
                count = 0;
            }
            count++;
            if (count > cnt) {
                ans = curWord;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode819 leetCode819 = new LeetCode819();
        System.out.println(leetCode819.mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", new String[]{"hit"}));
        System.out.println(leetCode819.mostCommonWord("Bob", new String[]{}));
    }
}
