package com.geekbing.middle;

public class LeetCode738 {
    public int monotoneIncreasingDigits(int N) {
        int num = 111111111;
        int ans = 0;
        for (int i = 0; i < 9; i++) {
            while (ans + num > N) {
                num /= 10;
            }
            ans += num;
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode738 leetCode738 = new LeetCode738();
        System.out.println(leetCode738.monotoneIncreasingDigits(10));
        System.out.println(leetCode738.monotoneIncreasingDigits(1234));
        System.out.println(leetCode738.monotoneIncreasingDigits(332));
    }
}
