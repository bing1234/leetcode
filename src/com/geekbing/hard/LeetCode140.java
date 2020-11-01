package com.geekbing.hard;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/word-break-ii/
 * 140. 单词拆分 II
 *
 * @author bing
 */
public class LeetCode140 {
    private boolean[] dp;
    private Set<String> wordSet;
    private List<String> ans;

    public List<String> wordBreak(String s, List<String> wordDict) {
        // 第一步。计算s[0...i]是否能被拆分
        wordSet = new HashSet<>(wordDict);
        // dp[i] 表示s[0...i]能否被拆分
        dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        // 第二部。回溯
        ans = new ArrayList<>();
        if (dp[s.length()]) {
            backtrack(s, s.length(), new LinkedList<>());
        }
        return ans;
    }

    public void backtrack(String s, int len, Deque<String> temp) {
        if (len == 0) {
            ans.add(String.join(" ", temp));
            return;
        }
        for (int i = len - 1; i >= 0; i--) {
            String suffix = s.substring(i, len);
            if (dp[i] && wordSet.contains(suffix)) {
                temp.addFirst(suffix);
                backtrack(s, i, temp);
                temp.removeFirst();
            }
        }
    }

    public static void main(String[] args) {
        LeetCode140 leetCode140 = new LeetCode140();
        System.out.println(leetCode140.wordBreak("catsanddog", new ArrayList<>(Arrays.asList("cat", "cats", "and", "sand", "dog"))));
        System.out.println(leetCode140.wordBreak("pineapplepenapple", new ArrayList<>(Arrays.asList("apple", "pen", "applepen", "pine", "pineapple"))));
        System.out.println(leetCode140.wordBreak("catsandog", new ArrayList<>(Arrays.asList("cats", "dog", "sand", "and", "cat"))));
    }
}
