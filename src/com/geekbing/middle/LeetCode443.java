package com.geekbing.middle;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode443 {
    public int compress(char[] chars) {
        if (chars.length <= 1) {
            return chars.length;
        }
        int len = 0, cnt = 1;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1]) {
                cnt++;
            } else {
                chars[len++] = chars[i - 1];
                if (cnt > 1) {
                    for (char c : String.valueOf(cnt).toCharArray()) {
                        chars[len++] = c;
                    }
                }
                cnt = 1;
            }
        }
        chars[len++] = chars[chars.length - 1];
        if (cnt > 1) {
            for (char c : String.valueOf(cnt).toCharArray()) {
                chars[len++] = c;
            }
        }
        return len;
    }

    @Test
    public void testCase1() {
        LeetCode443 leetCode443 = new LeetCode443();
        char[] arr = new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        assert leetCode443.compress(arr) == 6;
        char[] expert = new char[]{'a', '2', 'b', '2', 'c', '3'};
        for (int i = 0; i < expert.length; i++) {
            assert arr[i] == expert[i];
        }
    }

    @Test
    public void testCase2() {
        LeetCode443 leetCode443 = new LeetCode443();
        char[] arr = new char[]{'a'};
        assert leetCode443.compress(arr) == 1;
        char[] expert = new char[]{'a'};
        for (int i = 0; i < expert.length; i++) {
            assert arr[i] == expert[i];
        }
    }

    @Test
    public void testCase3() {
        LeetCode443 leetCode443 = new LeetCode443();
        char[] arr = new char[]{'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'};
        assert leetCode443.compress(arr) == 4;
        char[] expert = new char[]{'a', 'b', '1', '2'};
        for (int i = 0; i < expert.length; i++) {
            assert arr[i] == expert[i];
        }
    }

    @Test
    public void testCase4() {
        LeetCode443 leetCode443 = new LeetCode443();
        char[] arr = new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        assert leetCode443.compress(arr) == 6;
        char[] expert = new char[]{'a', '2', 'b', '2', 'c', '3'};
        for (int i = 0; i < expert.length; i++) {
            assert arr[i] == expert[i];
        }
    }
}
