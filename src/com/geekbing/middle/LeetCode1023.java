package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author bing
 */
public class LeetCode1023 {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> ans = new ArrayList<>();
        for (String query : queries) {
            ans.add(isMath(query, pattern));
        }
        return ans;
    }

    private boolean isMath(String query, String pattern) {
        int idx1 = 0, idx2 = 0, len1 = query.length(), len2 = pattern.length();
        while (idx1 < len1 && idx2 < len2) {
            while (idx1 < query.length() && query.charAt(idx1) != pattern.charAt(idx2)) {
                char c = query.charAt(idx1);
                if (c < 'a' || c > 'z') {
                    return false;
                }
                idx1++;
            }
            if (idx1 == len1) {
                return false;
            }
            idx1++;
            idx2++;
        }
        while (idx1 < len1) {
            char c = query.charAt(idx1);
            if (c < 'a' || c > 'z') {
                return false;
            }
            idx1++;
        }
        return idx2 == pattern.length();
    }

    @Test
    public void isMathTest() {
        LeetCode1023 leetCode1023 = new LeetCode1023();
        assert !leetCode1023.isMath("FooBar", "FoBaT");
        assert leetCode1023.isMath("FooBarTest", "FoBaT");
        assert !leetCode1023.isMath("FootBall", "FoBaT");
        assert !leetCode1023.isMath("FrameBuffer", "FoBaT");
        assert !leetCode1023.isMath("ForceFeedBack", "FoBaT");
    }

    @Test
    public void testCase1() {
        LeetCode1023 leetCode1023 = new LeetCode1023();
        List<Boolean> ans = leetCode1023.camelMatch(new String[]{"FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"}, "FB");
        List<Boolean> expert = new ArrayList<>(Arrays.asList(true, false, true, true, false));
        assert expert.equals(ans);
    }

    @Test
    public void testCase2() {
        LeetCode1023 leetCode1023 = new LeetCode1023();
        List<Boolean> ans = leetCode1023.camelMatch(new String[]{"FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"}, "FoBa");
        List<Boolean> expert = new ArrayList<>(Arrays.asList(true, false, true, false, false));
        assert expert.equals(ans);
    }

    @Test
    public void testCase3() {
        LeetCode1023 leetCode1023 = new LeetCode1023();
        List<Boolean> ans = leetCode1023.camelMatch(new String[]{"FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"}, "FoBaT");
        List<Boolean> expert = new ArrayList<>(Arrays.asList(false, true, false, false, false));
        assert expert.equals(ans);
    }
}
