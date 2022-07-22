package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode5763 {
    public boolean checkZeroOnes(String s) {
        char[] chars = s.toCharArray();
        int zeroLen = findMaxLen(chars, '0');
        int oneLen = findMaxLen(chars, '1');
        return oneLen > zeroLen;
    }

    private int findMaxLen(char[] chars, char target) {
        int ans = chars[0] == target ? 1 : 0;
        int curLen = ans;
        char pre = chars[0];
        for (int i = 1; i < chars.length; i++) {
            if (pre == chars[i]) {
                curLen++;
            } else {
                curLen = chars[i] == target ? 1 : 0;
                pre = chars[i];
            }
            ans = Math.max(ans, curLen);
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode5763 leetCode5763 = new LeetCode5763();

//        System.out.println(leetCode5763.checkZeroOnes("1101"));
//        System.out.println(leetCode5763.checkZeroOnes("111000"));
//        System.out.println(leetCode5763.checkZeroOnes("110100010"));
        System.out.println(leetCode5763.checkZeroOnes("01111110"));
    }
}
