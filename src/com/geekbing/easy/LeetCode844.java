package com.geekbing.easy;

public class LeetCode844 {
    public boolean backspaceCompare(String S, String T) {
        int indexS = S.length() - 1, indexT = T.length() - 1;
        int countS = 0, countT = 0;
        Character charS = null, charT = null;
        while (indexS >= 0 || indexT >= 0) {
            // 从后往前找到第一个字符
            while (indexS >= 0) {
                if (S.charAt(indexS) == '#') {
                    countS++;
                    indexS--;
                } else {
                    if (countS > 0) {
                        indexS--;
                        countS--;
                    } else {
                        charS = S.charAt(indexS);
                        indexS--;
                        break;
                    }
                }
            }
            while (indexT >= 0) {
                if (T.charAt(indexT) == '#') {
                    countT++;
                    indexT--;
                } else {
                    if (countT > 0) {
                        indexT--;
                        countT--;
                    } else {
                        charT = T.charAt(indexT);
                        indexT--;
                        break;
                    }
                }
            }
            if (charS != charT) {
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
