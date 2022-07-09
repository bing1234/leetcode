package com.geekbing.middle;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode2024 {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int allT = replaceChar(answerKey, 'T', k);
        int allF = replaceChar(answerKey, 'F', k);
        return Math.max(allT, allF);
    }

    private int replaceChar(String answerKey, char targetChar, int k) {
        // 维持一个滑动窗口
        int left = 0, right = 0, ans = k;
        if (answerKey.charAt(0) != targetChar) {
            k--;
        }
        while (right + 1 < answerKey.length()) {
            if (right + 1 < answerKey.length() && answerKey.charAt(right + 1) == targetChar) {
                right++;
                ans = Math.max(ans, right + 1 - left);
            } else {
                if (k > 0) {
                    // 使用掉一次替换机会，且右边界直接扩张
                    k--;
                    right++;
                    ans = Math.max(ans, right + 1 - left);
                } else {
                    // 如果右边是对方字符，当前没有替换次数了，则左边进行收缩
                    if (answerKey.charAt(left) == targetChar) {
                        left++;
                    } else {
                        left++;
                        k++;
                    }
                }
            }
        }
        return ans;
    }

    @Test
    public void testCase1() {
        LeetCode2024 leetCode2024 = new LeetCode2024();
        assert leetCode2024.maxConsecutiveAnswers("TTFF", 2) == 4;
    }

    @Test
    public void testCase2() {
        LeetCode2024 leetCode2024 = new LeetCode2024();
        assert leetCode2024.maxConsecutiveAnswers("TFFT", 1) == 3;
    }

    @Test
    public void testCase3() {
        LeetCode2024 leetCode2024 = new LeetCode2024();
        assert leetCode2024.maxConsecutiveAnswers("TTFTTFTT", 1) == 5;
    }
}
