package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode5817 {
    public boolean isDecomposable(String s) {
        // 特殊情况处理
        if (s == null || s.length() < 2) {
            return false;
        }
        if (s.charAt(0) != s.charAt(1) || s.charAt(s.length() - 2) != s.charAt(s.length() - 1)) {
            return false;
        }

        int curIdx = 0, curLen = 0;
        boolean hasLenTwo = false;

        while (curIdx < s.length() - 1) {
            if (s.charAt(curIdx) == s.charAt(curIdx + 1)) {
                curLen++;
            } else {
                curLen++;
                if (curLen % 3 == 1) {
                    return false;
                } else if (curLen % 3 == 2) {
                    if (hasLenTwo) {
                        return false;
                    }
                    hasLenTwo = true;
                }
                curLen = 0;
            }
            curIdx++;
        }

        // 最后一段长度
        curLen++;
        if (curLen % 3 == 1) {
            return false;
        } else if (curLen % 3 == 2) {
            if (hasLenTwo) {
                return false;
            }
            hasLenTwo = true;
        }
        return hasLenTwo;
    }

    public static void main(String[] args) {
        LeetCode5817 leetCode5817 = new LeetCode5817();

//        System.out.println(leetCode5817.isDecomposable("000111000"));
//        System.out.println(leetCode5817.isDecomposable("00011111222"));
//        System.out.println(leetCode5817.isDecomposable("01110002223300"));

        System.out.println(leetCode5817.isDecomposable("66666666666677722"));

    }
}
