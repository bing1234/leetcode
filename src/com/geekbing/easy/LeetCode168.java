package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode168 {
    public String convertToTitle(int n) {
        StringBuilder ans = new StringBuilder();
        while (n != 0) {
            int cur = n % 26;
            if (cur == 0) {
                cur = 26;
            }
            ans.insert(0, (char) (cur - 1 + 'A'));
            n = (n - cur) / 26;
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        LeetCode168 leetCode168 = new LeetCode168();
        System.out.println(leetCode168.convertToTitle(1));
        System.out.println(leetCode168.convertToTitle(28));
        System.out.println(leetCode168.convertToTitle(701));
    }
}
