package com.geekbing.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author bing
 */
public class LeetCode937 {
    public String[] reorderLogFiles(String[] logs) {
        String[] ans = new String[logs.length];

        // 保存字母日志
        List<String> letterLogs = new ArrayList<>();

        // 先从后向前排列数字日志
        int idx = ans.length - 1;
        for (int i = logs.length - 1; i >= 0; i--) {
            if (isNumLog(logs[i])) {
                ans[idx] = logs[i];
                idx--;
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

    private boolean isNumLog(String log) {
        char last = log.charAt(log.length() - 1);
        return '0' <= last && last <= '9';
    }

    public static void main(String[] args) {
        LeetCode937 leetCode937 = new LeetCode937();
        System.out.println(Arrays.toString(leetCode937.reorderLogFiles(new String[]{"dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero"})));
        System.out.println(Arrays.toString(leetCode937.reorderLogFiles(new String[]{"a1 9 2 3 1", "g1 act car", "zo4 4 7", "ab1 off key dog", "a8 act zoo"})));
    }
}
