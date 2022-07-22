package com.geekbing.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode830 {

    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> ans = new ArrayList<>();
        int left = 0;
        char cur = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != cur) {
                if (i - left >= 3) {
                    ans.add(new ArrayList<>(Arrays.asList(left, i - 1)));
                }
                left = i;
                cur = s.charAt(i);
            }
        }
        if (s.length() - left >= 3) {
            ans.add(new ArrayList<>(Arrays.asList(left, s.length() - 1)));
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode830 leetCode830 = new LeetCode830();
        System.out.println(leetCode830.largeGroupPositions("abbxxxxzzy"));
        System.out.println(leetCode830.largeGroupPositions("abc"));
        System.out.println(leetCode830.largeGroupPositions("abcdddeeeeaabbbcd"));
        System.out.println(leetCode830.largeGroupPositions("aba"));
        System.out.println(leetCode830.largeGroupPositions("baa"));
    }
}
