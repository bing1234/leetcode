package com.geekbing.middle;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/word-break/
 * 139. 单词拆分
 *
 * @author bing
 */
public class LeetCode139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        // dp[i] 表示s[0...i]能否被拆分
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        LeetCode139 leetCode139 = new LeetCode139();
        System.out.println(leetCode139.wordBreak("abcd", new ArrayList<>(Arrays.asList("a", "abc", "b", "cd"))));
        System.out.println(leetCode139.wordBreak("leetcode", new ArrayList<>(Arrays.asList("leet", "code"))));
        System.out.println(leetCode139.wordBreak("applepenapple", new ArrayList<>(Arrays.asList("apple", "pen"))));
        System.out.println(leetCode139.wordBreak("catsandog", new ArrayList<>(Arrays.asList("cats", "dog", "sand", "and", "cat"))));
    }
}
