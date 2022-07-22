package com.geekbing.middle;

import java.util.ArrayList;
import java.util.List;

public class LeetCode842 {
    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> ans = new ArrayList<>();
        backtrack(ans, S, 0);
        return ans;
    }

    private boolean backtrack(List<Integer> ans, String S, int idx) {
        // 边界条件
        if (idx == S.length() && ans.size() >= 3) {
            return true;
        }
        for (int i = idx; i < S.length(); i++) {
            // 两位以上的数不能以0开头
            if (S.charAt(idx) == '0' && i > idx) {
                return false;
            }
            // 截取的数字
            long num = Long.parseLong(S.substring(idx, i + 1));
            // 截取的数不能超出int范围
            if (num > Integer.MAX_VALUE) {
                return false;
            }
            if (ans.size() >= 2 && num > ans.get(ans.size() - 1) + ans.get(ans.size() - 2)) {
                return false;
            }
            if (ans.size() <= 1 || num == ans.get(ans.size() - 1) + ans.get(ans.size() - 2)) {
                ans.add((int) num);
                if (backtrack(ans, S, i + 1)) {
                    return true;
                } else {
                    ans.remove(ans.size() - 1);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LeetCode842 leetCode842 = new LeetCode842();
        System.out.println(leetCode842.splitIntoFibonacci("123456579"));
        System.out.println(leetCode842.splitIntoFibonacci("11235813"));
        System.out.println(leetCode842.splitIntoFibonacci("112358130"));
        System.out.println(leetCode842.splitIntoFibonacci("0123"));
        System.out.println(leetCode842.splitIntoFibonacci("1101111"));
    }
}
