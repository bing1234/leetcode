package com.geekbing.middle;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode394 {
    public String decodeString(String s) {
        if (!s.contains("[")) {
            return s;
        }
        int[] idx = findPattern(s);
        String str = s.substring(idx[0], idx[1]);
        s = s.replace(str, decode(str));
        return decodeString(s);
    }

    private int[] findPattern(String s) {
        String old = s;
        s = s.replaceFirst("[0-9]+\\[[a-z]+]", "*");
        int idx = s.indexOf("*");
        return new int[]{idx, idx + old.length() - s.length() + 1};
    }

    private String decode(String s) {
        int left = s.indexOf('[');
        int right = s.indexOf(']');
        int num = Integer.parseInt(s.substring(0, left));
        String str = s.substring(left + 1, right);
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < num; i++) {
            ans.append(str);
        }
        return ans.toString();
    }

    @Test
    public void testCase1() {
        LeetCode394 leetCode394 = new LeetCode394();
        assert leetCode394.decodeString("3[a]2[bc]").equals("aaabcbc");
    }

    @Test
    public void testCase2() {
        LeetCode394 leetCode394 = new LeetCode394();
        assert leetCode394.decodeString("3[a2[c]]").equals("accaccacc");
    }

    @Test
    public void testCase3() {
        LeetCode394 leetCode394 = new LeetCode394();
        assert leetCode394.decodeString("2[abc]3[cd]ef").equals("abcabccdcdcdef");
    }

    @Test
    public void testCase4() {
        LeetCode394 leetCode394 = new LeetCode394();
        assert leetCode394.decodeString("abc3[cd]xyz").equals("abccdcdcdxyz");
    }
}
