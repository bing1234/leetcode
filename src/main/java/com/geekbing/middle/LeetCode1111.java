package com.geekbing.middle;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode1111 {
    public int[] maxDepthAfterSplit(String seq) {
        int[] ans = new int[seq.length()];
        int cnt = 0;
        for (int i = 0; i < seq.length(); i++) {
            if (seq.charAt(i) == '(') {
                cnt++;
                ans[i] = cnt % 2;
            } else {
                ans[i] = cnt % 2;
                cnt--;
            }
        }
        return ans;
    }

    @Test
    public void testCase1() {
        LeetCode1111 leetCode410 = new LeetCode1111();
        String seq = "(()())";

        int[] ans = leetCode410.maxDepthAfterSplit(seq);

        String a = seplitStr(seq, ans, 0);
        String b = seplitStr(seq, ans, 1);

        assert Math.abs(depth(a) - depth(b)) <= 1;
    }


    @Test
    public void testCase2() {
        LeetCode1111 leetCode410 = new LeetCode1111();

        String seq = "()(())()";
        int[] ans = leetCode410.maxDepthAfterSplit(seq);

        String a = seplitStr(seq, ans, 0);
        String b = seplitStr(seq, ans, 1);

        assert Math.abs(depth(a) - depth(b)) <= 1;
    }

    private int depth(String str) {
        int ans = 0, cnt = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                cnt++;
                ans = Math.max(ans, cnt);
            } else {
                cnt--;
            }
        }
        return ans;
    }

    private String seplitStr(String str, int[] idx, int num) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < idx.length; i++) {
            if (idx[i] == num) {
                ans.append(str.charAt(i));
            }
        }
        return ans.toString();
    }
}
