package com.geekbing.easy;

public class LeetCode868 {
    public int binaryGap(int n) {
        String binary = toBinary(n);
        return countMaxDiff(binary);
    }

    private String toBinary(int n) {
        StringBuilder ans = new StringBuilder();
        while (n != 0) {
            ans.insert(0, n % 2);
            n = n / 2;
        }
        return ans.toString();
    }

    private int countMaxDiff(String str) {
        int ans = 0, lastOne = 0;
        for (int i = 0; i < str.toCharArray().length; i++) {
            if (str.charAt(i) == '1') {
                if (i - lastOne >= ans) {
                    ans = i - lastOne;
                }
                lastOne = i;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode868 leetCode868 = new LeetCode868();
        System.out.println(leetCode868.toBinary(2897));
        System.out.println(leetCode868.toBinary(15));

        System.out.println(leetCode868.binaryGap(2897));
        System.out.println(leetCode868.binaryGap(15));
        System.out.println(leetCode868.binaryGap(22));
        System.out.println(leetCode868.binaryGap(5));
        System.out.println(leetCode868.binaryGap(6));
        System.out.println(leetCode868.binaryGap(8));
        System.out.println(leetCode868.binaryGap(1));
    }
}
