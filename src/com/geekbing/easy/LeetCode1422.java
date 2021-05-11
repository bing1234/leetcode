package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode1422 {
    public int maxScore(String s) {
        int[][] arr = new int[s.length() - 1][2];
        char[] chars = s.toCharArray();

        int leftZero = 0;
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == '0') {
                leftZero++;
            }
            arr[i][0] = leftZero;
        }

        int rightOne = 0;
        for (int i = chars.length - 1; i > 0; i--) {
            if (chars[i] == '1') {
                rightOne++;
            }
            arr[i - 1][1] = rightOne;
        }

        int ans = 0;
        for (int[] item : arr) {
            ans = Math.max(ans, item[0] + item[1]);
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode1422 leetCode1422 = new LeetCode1422();
        System.out.println(leetCode1422.maxScore("011101"));
        System.out.println(leetCode1422.maxScore("00111"));
        System.out.println(leetCode1422.maxScore("1111"));
    }
}
