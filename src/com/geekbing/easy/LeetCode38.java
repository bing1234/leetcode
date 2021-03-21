package com.geekbing.easy;

import java.util.HashMap;
import java.util.Map;

public class LeetCode38 {
    private static final Map<Integer, String> MAP = new HashMap<>();

    static {
        MAP.put(1, "1");
        MAP.put(2, "11");
    }

    public String countAndSay(int n) {
        if (MAP.containsKey(n)) {
            return MAP.get(n);
        }
        for (int i = 3; i <= n; i++) {
            // 获取i-1的结果
            String tmp = MAP.get(i - 1);
            String next = getNextStr(tmp);
            MAP.put(i, next);
        }
        return MAP.get(n);
    }

    private String getNextStr(String str) {
        StringBuilder ans = new StringBuilder();
        char cur = str.charAt(0), next;
        int curCnt = 1;
        for (int i = 1; i < str.length(); i++) {
            next = str.charAt(i);
            if (next == cur) {
                curCnt++;
                cur = next;
            } else {
                ans.append(curCnt).append(cur);
                cur = next;
                curCnt = 1;
            }
        }
        ans.append(curCnt).append(cur);
        return ans.toString();
    }

    public static void main(String[] args) {
        LeetCode38 leetCode38 = new LeetCode38();
        System.out.println(leetCode38.countAndSay(1));
        System.out.println(leetCode38.countAndSay(4));
//        System.out.println(leetCode38.getNextStr("1"));
//        System.out.println(leetCode38.getNextStr("11"));
//        System.out.println(leetCode38.getNextStr("21"));
//        System.out.println(leetCode38.getNextStr("1211"));
//        System.out.println(leetCode38.getNextStr("111221"));
    }
}