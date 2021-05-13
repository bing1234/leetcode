package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode1556 {
    public String thousandSeparator(int n) {
        if (n < 10) {
            return String.valueOf(n);
        }
        String ans = "";
        int cnt = 0, remainder = 0;
        while (n != 0) {
            remainder = n % 10;
            cnt++;

            ans = remainder + ans;
            if (cnt == 3) {
                ans = "." + ans;
                cnt = 0;
            }
            n /= 10;
        }
        if (ans.length() > 1 && ans.charAt(0) == '.') {
            return ans.substring(1);
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode1556 leetCode1556 = new LeetCode1556();
        System.out.println(leetCode1556.thousandSeparator(987));
        System.out.println(leetCode1556.thousandSeparator(1234));
        System.out.println(leetCode1556.thousandSeparator(123456789));
        System.out.println(leetCode1556.thousandSeparator(0));
    }
}
