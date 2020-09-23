package com.geekbing;

import java.util.Scanner;

public class Main {
    private int maxSameLength(String str, int maxOperNums) {
        int left = 0, right = 0;
        int aNums = 0, bNums = 0;
        int ans = 0;
        while (right < str.length()) {
            if (str.charAt(right) == 'a') {
                aNums++;
            } else {
                bNums++;
            }
            if (aNums <= maxOperNums || bNums <= maxOperNums) {
                right++;
            } else {
                ans = Math.max(ans, right - left);
                if (str.charAt(left) == 'a') {
                    aNums--;
                } else {
                    bNums--;
                }
                left++;
                right++;
            }
        }
        ans = Math.max(ans, right - left);
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int maxOperNums = sc.nextInt();
        String str = sc.next();

        Main main = new Main();
        System.out.println(main.maxSameLength(str, maxOperNums));
    }
}
