package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bing
 */
public class LeetCode792 {
    public int numMatchingSubseq(String s, String[] words) {
        // 初始化26个桶
        List<String>[] bucket = new List[26];
        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = new ArrayList<>();
        }
        // 按照首字母将单词存放到桶中
        for (String word : words) {
            bucket[word.charAt(0) - 'a'].add(word);
        }
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 取出当前桶中的元素，消除首字母，然后重新存放进桶中
            List<String> items = new ArrayList<>(bucket[c - 'a']);
            bucket[c - 'a'] = new ArrayList<>();
            for (String item : items) {
                if (item.length() > 1) {
                    bucket[item.charAt(1) - 'a'].add(item.substring(1));
                } else {
                    ans++;
                }
            }
        }
        return ans;
    }

    @Test
    public void testCase1() {
        LeetCode792 leetCode792 = new LeetCode792();
        assert leetCode792.numMatchingSubseq("abcde", new String[]{"a", "bb", "acd", "ace"}) == 3;
    }

    @Test
    public void testCase2() {
        LeetCode792 leetCode792 = new LeetCode792();
        assert leetCode792.numMatchingSubseq("dsahjpjauf", new String[]{"ahjpjau", "ja", "ahbwzgqnuk", "tnmlanowax"}) == 2;
    }
}
