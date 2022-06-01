package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author bing
 */
public class LeetCode93 {
    private final List<String> ans = new ArrayList<>();
    private final List<String> segments = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        if (s.length() < 4 || s.length() > 12) {
            return ans;
        }
        dfs(s, 0);
        return ans;
    }

    private void dfs(String s, int begin) {
        if (begin == s.length() && segments.size() == 4) {
            ans.add(String.join(".", segments));
            return;
        }
        if (begin == s.length() && segments.size() < 4) {
            return;
        }
        for (int len = 1; len <= 3; len++) {
            // 保证后续s.substring(begin, begin + len)合法
            if (begin + len - 1 >= s.length()) {
                return;
            }
            // 去除非法的前导0
            if (len != 1 && s.charAt(begin) == '0') {
                return;
            }
            // 截取字符串
            String cur = s.substring(begin, begin + len);
            if (len == 3 && Integer.parseInt(cur) > 255) {
                return;
            }
            segments.add(cur);
            dfs(s, begin + len);
            segments.remove(segments.size() - 1);
        }
    }

    @Test
    public void testCase1() {
        LeetCode93 leetCode93 = new LeetCode93();
        List<String> ans = leetCode93.restoreIpAddresses("25525511135");
        List<String> expert = new ArrayList<>(Arrays.asList("255.255.11.135", "255.255.111.35"));
        Collections.sort(ans);
        Collections.sort(expert);
        assert ans.equals(expert);
    }

    @Test
    public void testCase2() {
        LeetCode93 leetCode93 = new LeetCode93();
        List<String> ans = leetCode93.restoreIpAddresses("0000");
        List<String> expert = new ArrayList<>(Collections.singletonList("0.0.0.0"));
        Collections.sort(ans);
        Collections.sort(expert);
        assert ans.equals(expert);
    }

    @Test
    public void testCase3() {
        LeetCode93 leetCode93 = new LeetCode93();
        List<String> ans = leetCode93.restoreIpAddresses("101023");
        List<String> expert = new ArrayList<>(Arrays.asList("1.0.10.23", "1.0.102.3", "10.1.0.23", "10.10.2.3", "101.0.2.3"));
        Collections.sort(ans);
        Collections.sort(expert);
        assert ans.equals(expert);
    }
}
