package com.geekbing.easy;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode2047 {
    public int countValidWords(String sentence) {
        int ans = 0;
        for (String word : sentence.split(" ")) {
            if (isValidWord(word)) {
                ans++;
            }
        }
        return ans;
    }

    private boolean isValidWord(String word) {
        if ("".equals(word)) {
            return false;
        }

        char[] chars = word.toCharArray();
        int numOfConnect = 0, sign = 0;
        for (int i = 0; i < chars.length; i++) {
            if (isLetter(chars[i])) {
                continue;
            } else if (chars[i] == '-') {
                numOfConnect++;
                if (numOfConnect > 1) {
                    return false;
                }
                if (i == 0 || i == chars.length - 1) {
                    return false;
                }
                if (!isLetter(chars[i - 1]) || !isLetter(chars[i + 1])) {
                    return false;
                }
            } else if (chars[i] == '!' || chars[i] == '.' || chars[i] == ',') {
                sign++;
                if (sign > 1) {
                    return false;
                }
                if (i != chars.length - 1) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }

    private boolean isLetter(char c) {
        return 'a' <= c && c <= 'z';
    }

    @Test
    public void testCase1() {
        LeetCode2047 leetCode2047 = new LeetCode2047();
        assert leetCode2047.countValidWords("cat and  dog") == 3;
    }

    @Test
    public void testCase2() {
        LeetCode2047 leetCode2047 = new LeetCode2047();
        assert leetCode2047.countValidWords("!this  1-s b8d!") == 0;
    }

    @Test
    public void testCase3() {
        LeetCode2047 leetCode2047 = new LeetCode2047();
        assert leetCode2047.countValidWords("alice and  bob are playing stone-game10") == 5;
    }

    @Test
    public void testCase4() {
        LeetCode2047 leetCode2047 = new LeetCode2047();
        assert leetCode2047.countValidWords("he bought 2 pencils, 3 erasers, and 1  pencil-sharpener.") == 6;
    }
}
