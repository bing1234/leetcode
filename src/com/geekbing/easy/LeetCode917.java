package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode917 {
    public String reverseOnlyLetters(String S) {
        char[] result = new char[S.length()];
        int low = 0, high = S.length() - 1;
        while (low <= high) {
            while (low <= high && !isLetter(S.charAt(low))) {
                result[low] = S.charAt(low);
                low++;
            }
            while (low <= high && !isLetter(S.charAt(high))) {
                result[high] = S.charAt(high);
                high--;
            }
            if (low > high) {
                break;
            }
            result[low] = S.charAt(high);
            result[high] = S.charAt(low);
            low++;
            high--;
        }
        return new String(result);
    }

    private boolean isLetter(char c) {
        return ('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z');
    }

    public static void main(String[] args) {
        LeetCode917 leetCode917 = new LeetCode917();
        System.out.println(leetCode917.reverseOnlyLetters("-"));
//        System.out.println(leetCode917.reverseOnlyLetters("ab-cd"));
//        System.out.println(leetCode917.reverseOnlyLetters("a-bC-dEf-ghIj"));
//        System.out.println(leetCode917.reverseOnlyLetters("Test1ng-Leet=code-Q!"));
    }
}
