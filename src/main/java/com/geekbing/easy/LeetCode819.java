package com.geekbing.easy;

import org.junit.jupiter.api.Test;

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
        for (int i = 0; i < paragraph.length(); i++) {
            char c = paragraph.charAt(i);
            if ('a' <= c && c <= 'z') {
                curWord += c;
            } else if ('A' <= c && c <= 'Z') {
                curWord += (char) (c + 32);
            } else {
                if (!"".equals(curWord) && !ban.contains(curWord)) {
                    int count = map.getOrDefault(curWord, 0) + 1;
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
            int count = map.getOrDefault(curWord, 0) + 1;
            if (count > cnt) {
                ans = curWord;
            }
        }
        return ans;
    }

    @Test
    public void testCase1() {
        LeetCode819 leetCode819 = new LeetCode819();
        assert leetCode819.mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", new String[]{"hit"}).equals("ball");
    }
}
