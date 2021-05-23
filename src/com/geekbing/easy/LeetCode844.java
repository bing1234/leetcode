package com.geekbing.easy;

import java.util.Objects;

/**
 * @author bing
 */
public class LeetCode844 {
    public boolean backspaceCompare(String s, String t) {
        int indexS = s.length() - 1, indexT = t.length() - 1;
        int countS = 0, countT = 0;
        Character charS = null, charT = null;
        while (indexS >= 0 || indexT >= 0) {
            // 从后往前找到第一个字符
            while (indexS >= 0) {
                if (s.charAt(indexS) == '#') {
                    countS++;
                    indexS--;
                } else {
                    if (countS > 0) {
                        indexS--;
                        countS--;
                    } else {
                        charS = s.charAt(indexS);
                        indexS--;
                        break;
                    }
                }
            }
            while (indexT >= 0) {
                if (t.charAt(indexT) == '#') {
                    countT++;
                    indexT--;
                } else {
                    if (countT > 0) {
                        indexT--;
                        countT--;
                    } else {
                        charT = t.charAt(indexT);
                        indexT--;
                        break;
                    }
                }
            }
            if (!Objects.equals(charS, charT)) {
                return false;
            } else {
                charS = null;
                charT = null;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode844 leetCode844 = new LeetCode844();
        System.out.println(leetCode844.backspaceCompare("ab#c", "ad#c"));
        System.out.println(leetCode844.backspaceCompare("ab##", "c#d#"));
        System.out.println(leetCode844.backspaceCompare("a##c", "#a#c"));
        System.out.println(leetCode844.backspaceCompare("a#c", "b"));
        System.out.println(leetCode844.backspaceCompare("bbbextm", "bbb#extm"));
    }
}
