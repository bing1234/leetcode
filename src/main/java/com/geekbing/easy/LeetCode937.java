package com.geekbing.easy;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author bing
 */
public class LeetCode937 {
    public String[] reorderLogFiles(String[] logs) {
        int len = logs.length;
        String[] ans = new String[len];
        // 保存字母日志
        List<String> letterLogs = new ArrayList<>();

        // 先从后向前排列数字日志
        int idx = len - 1;
        for (int i = logs.length - 1; i >= 0; i--) {
            if (Character.isDigit(logs[i].charAt(logs[i].length() - 1))) {
                ans[idx--] = logs[i];
            } else {
                letterLogs.add(logs[i]);
            }
        }

        // 所有的字母日志按照规则排序
        letterLogs.sort((o1, o2) -> {
            String[] words1 = o1.split(" ");
            String[] words2 = o2.split(" ");
            // 先比较后面的
            for (int i = 1; i < words1.length && i < words2.length; i++) {
                int compare = words1[i].compareTo(words2[i]);
                if (compare != 0) {
                    return compare;
                }
            }
            if (words1.length == words2.length) {
                return words1[0].compareTo(words2[0]);
            }
            return Integer.compare(words1.length, words2.length);
        });
        idx = 0;
        for (String log : letterLogs) {
            ans[idx] = log;
            idx++;
        }
        return ans;
    }

    @Test
    public void testCase1() {
        LeetCode937 leetCode937 = new LeetCode937();
        String[] ans = leetCode937.reorderLogFiles(new String[]{"dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero"});
        String[] expert = new String[]{"let1 art can", "let3 art zero", "let2 own kit dig", "dig1 8 1 5 1", "dig2 3 6"};
        assert Arrays.equals(expert, ans);
    }

    @Test
    public void testCase2() {
        LeetCode937 leetCode937 = new LeetCode937();
        String[] ans = leetCode937.reorderLogFiles(new String[]{"a1 9 2 3 1", "g1 act car", "zo4 4 7", "ab1 off key dog", "a8 act zoo"});
        String[] expert = new String[]{"g1 act car", "a8 act zoo", "ab1 off key dog", "a1 9 2 3 1", "zo4 4 7"};
        assert Arrays.equals(expert, ans);
    }
}
