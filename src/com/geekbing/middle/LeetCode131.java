package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author bing
 */
public class LeetCode131 {
    private final List<List<String>> ans = new ArrayList<>();
    private final List<String> temp = new ArrayList<>();

    public List<List<String>> partition(String s) {
        dfs(s, 0);
        return ans;
    }

    private void dfs(String s, int begin) {
        if (begin == s.length()) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int len = 1; len <= s.length(); len++) {
            if (begin + len - 1 >= s.length()) {
                return;
            }
            // 切割子串
            String cur = s.substring(begin, begin + len);
            // 如果当前不是回文字符串
            if (palindrome(cur)) {
                temp.add(cur);
                dfs(s, begin + len);
                temp.remove(temp.size() - 1);
            }
        }
    }

    private boolean palindrome(String s) {
        if (s == null || s.equals("")) {
            return false;
        }
        if (s.length() == 1) {
            return true;
        }
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    @Test
    public void testCase1() {
        LeetCode131 leetCode131 = new LeetCode131();
        List<List<String>> ans = leetCode131.partition("aab");
        List<List<String>> expert = new ArrayList<>();
        expert.add(new ArrayList<>(Arrays.asList("a", "a", "b")));
        expert.add(new ArrayList<>(Arrays.asList("aa", "b")));
        assert expert.equals(ans);
    }

    @Test
    public void testCase2() {
        LeetCode131 leetCode131 = new LeetCode131();
        List<List<String>> ans = leetCode131.partition("a");
        List<List<String>> expert = new ArrayList<>();
        expert.add(new ArrayList<>(Collections.singletonList("a")));
        assert expert.equals(ans);
    }

    @Test
    public void testCase3() {
        LeetCode131 leetCode131 = new LeetCode131();
        List<List<String>> ans = leetCode131.partition("efe");
        List<List<String>> expert = new ArrayList<>();
        expert.add(new ArrayList<>(Arrays.asList("e", "f", "e")));
        expert.add(new ArrayList<>(Collections.singletonList("efe")));
        assert expert.equals(ans);
    }
}
