package com.geekbing.easy;

import java.util.*;

/**
 * @author bing
 */
public class LeetCode1576 {
    public String modifyString(String s) {
        StringBuilder ans = new StringBuilder();
        char[] chars = s.toCharArray();
        int idx = 0;
        while (idx < chars.length) {
            if (chars[idx] == '?') {
                // 找到当前下标左边第一个不为?的字符的下标
                Integer left = findLeft(chars, idx);
                // 找到当前下标右边第一个不为?的字符的下标
                Integer right = findRight(chars, idx);
                if (left == null && right == null) {
                    return genSubStr(null, null, chars.length);
                } else if (left == null) {
                    ans.append(genSubStr(null, chars[right], right));
                    idx = right;
                } else if (right == null) {
                    ans.append(genSubStr(chars[left], null, chars.length - left - 1));
                    idx = chars.length;
                } else {
                    ans.append(genSubStr(chars[left], chars[right], right - left - 1));
                    idx = right;
                }
            } else {
                ans.append(chars[idx]);
                idx++;
            }
        }
        return ans.toString();
    }

    private Integer findLeft(char[] chars, int idx) {
        for (int i = idx - 1; i >= 0; i--) {
            if (chars[i] != '?') {
                return i;
            }
        }
        return null;
    }

    private Integer findRight(char[] chars, int idx) {
        for (int i = idx + 1; i < chars.length; i++) {
            if (chars[i] != '?') {
                return i;
            }
        }
        return null;
    }

    private String genSubStr(Character left, Character right, int len) {
        List<Character> arr = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            arr.add((char) ('a' + i));
        }
        arr.remove(left);
        arr.remove(right);

        StringBuilder ans = new StringBuilder();
        int idx = 0, count = 0;
        while (count < len) {
            if (idx == arr.size()) {
                idx = 0;
            }
            ans.append(arr.get(idx));
            idx++;
            count++;
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        LeetCode1576 leetCode1576 = new LeetCode1576();

//        System.out.println(leetCode1576.modifyString("??"));
//        System.out.println(leetCode1576.modifyString("?zs"));
//        System.out.println(leetCode1576.modifyString("z?s"));
//        System.out.println(leetCode1576.modifyString("zs?"));
//        System.out.println(leetCode1576.modifyString("?zs"));
//        System.out.println(leetCode1576.modifyString("ubv?w"));
//        System.out.println(leetCode1576.modifyString("j?qg??b"));
//        System.out.println(leetCode1576.modifyString("??yw?ipkj?"));

        System.out.println(leetCode1576.modifyString("????????????????????????????????????????????????????????????????????????????????????????????????????"));
    }
}
