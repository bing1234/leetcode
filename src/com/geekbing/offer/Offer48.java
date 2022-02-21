package com.geekbing.offer;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author bing
 */
public class Offer48 {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0, ans = 0;
        // 记录当前滑动窗口内部每个字符及该字符对应的下标
        Map<Character, Integer> map = new HashMap<>();
        while (right < s.length()) {
            char c = s.charAt(right);
            Integer idx = map.get(c);
            if (idx != null) {
                while (left <= idx) {
                    map.remove(s.charAt(left));
                    left++;
                }
            }
            map.put(c, right);
            ans = Math.max(ans, right - left + 1);
            right++;
        }
        return ans;
    }

    @Test
    public void testCase1() {
        Offer48 offer48 = new Offer48();
        assert offer48.lengthOfLongestSubstring("abcabcbb") == 3;
    }

    @Test
    public void testCase2() {
        Offer48 offer48 = new Offer48();
        assert offer48.lengthOfLongestSubstring("bbbbb") == 1;
    }

    @Test
    public void testCase3() {
        Offer48 offer48 = new Offer48();
        assert offer48.lengthOfLongestSubstring("pwwkew") == 3;
    }
}
